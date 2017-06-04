package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 聊天室服务端
 * @author adminitartor
 *
 */
public class Server {
	/**
	 * java.net.ServerSocket
	 * 运行在服务端的Socket，主要作用:
	 * 1:向操作系统申请端口号
	 *   客户端就是通过这个端口与服务端应用程序
	 *   建立连接的。
	 * 2:监听服务端口，一旦一个客户端通过该端口
	 *   发起连接，ServerSocket会自动创建一个
	 *   Socket与客户端进行连接并完成后续交互。  
	 */
	private ServerSocket server;
	/*
	 * 该Map存放所有客户端的输出流
	 * 其中key:该客户端昵称
	 * value:该客户端输出流
	 */
	private Map<String,PrintWriter> allOut;
	
	/**
	 * 构造方法，用来初始化服务端
	 * @throws IOException 
	 */
	public Server() throws IOException{
		/*
		 * 初始化ServerSocket并向操作系统申请
		 * 端口号。该端口号不能与其他使用TCP协议
		 * 的应用程序申请的端口号相同，否则抛出
		 * 异常。
		 */
		server = new ServerSocket(8088);
		
		/*
		 * 初始化共享集合
		 */
		allOut = new HashMap<String,PrintWriter>();
	}
	/**
	 * 向共享集合中添加一个输出流
	 * @param out
	 */
	private synchronized void addOut(String nickName,PrintWriter out){
		//这里实际上还要做避免昵称重复的判定
		allOut.put(nickName,out);
	}
	/**
	 * 从共享集合中将给定的输出流删除	
	 * @param out
	 */
	private synchronized void removeOut(String nickName){
		allOut.remove(nickName);
	}
	/**
	 * 将消息转发给所有客户端(广播消息)
	 * @param message
	 */
	private synchronized void sendMessage(String message){
		for(PrintWriter out:allOut.values()){
			out.println(message);
		}
	}
	/**
	 * 私聊，给指定昵称的客户端发送消息
	 * @param message
	 * @return
	 */
	private synchronized boolean sendMessageToNickName(String nickName,String message){
		//获取目标昵称
		String targetNickName = message.substring(1,message.indexOf(":"));
		if(allOut.containsKey(targetNickName)){
			PrintWriter pw = allOut.get(targetNickName);
			pw.println(nickName+"对你说:"+message.substring(message.indexOf(":")+1));
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * 服务端开始工作的方法
	 */
	public void start(){
		try {
			/*
			 * ServerSocket提供了方法:
			 * Socket accept()
			 * 该方法是一个阻塞方法，作用是监听
			 * 申请的服务端口，直到一个客户端通过
			 * 该端口建立连接为止，然后该方法会
			 * 创建并返回一个Socket，服务端可以
			 * 通过该Socket与建立连接的客户端进行
			 * 交互。
			 */
			while(true){
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				//创建线程来处理该客户端的交互工作
				ClientHandler handler 
					= new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务端启动失败!");
		}
	}
	
	/**
	 * 该线程是用来与指定的客户端进行交互的。
	 * @author adminitartor
	 *
	 */
	class ClientHandler implements Runnable{
		//当前线程处理的客户端的Socket
		private Socket socket;
		//客户端的地址信息
		private String host;
		//该用户昵称
		private String nickName;
		
		public ClientHandler(Socket socket){
			this.socket = socket;
			/*
			 * 通过Socket获取远端计算机地址信息
			 */
			InetAddress address
				= socket.getInetAddress();
			//将远端计算机IP的字符串形式返回
			host = address.getHostAddress();
			
		}
		public void run(){
			PrintWriter pw = null;
			try {
				/*
				 * InputStream getInputStream()
				 * 获取输入流，通过该流读取的内容
				 * 就是远端计算机发送过来的数据
				 */
				InputStream in
					= socket.getInputStream();
				
				InputStreamReader isr
					= new InputStreamReader(
						in,"UTF-8"
					);
				
				BufferedReader br
					= new BufferedReader(isr);
				
				/*
				 * 首先读取昵称
				 */
				nickName = br.readLine();
				
				/*
				 * 通过Socket获取输出流，以便于可以将
				 * 消息发送给客户端
				 */
				OutputStream out 
					= socket.getOutputStream();
				OutputStreamWriter osw
					= new OutputStreamWriter(out,"UTF-8");
				pw = new PrintWriter(osw,true);
				//将该客户端的输出流存入共享集合
				addOut(nickName,pw);
				
				
				//广播该用户上线
				sendMessage(nickName+"上线了!当前在线人数为:"+allOut.size());
				String message = null;
				/*
				 * 当使用br.readLine读取远端计算机发送过来的
				 * 消息时，远端计算机(在这里就是客户端)的操作
				 * 系统不同，当其断开连接时，br.readLine的操
				 * 作结果不同:
				 * 当windows的客户端断开连接，br.readLine方法
				 * 会直接抛出异常。
				 * 当linux的客户端断开连接，br.readLine方法会
				 * 返回null。
				 */
				while((message = br.readLine())!=null){
//					System.out.println(host+"说:"+message);
//					pw.println(host+"说:"+message);
					//是否为私聊
					if(message.startsWith("@")){
						sendMessageToNickName(nickName,message);
					}else{
						//将该客户端发送内容转发给所有客户端
						sendMessage(nickName+"说:"+message);
					}
				}
			} catch (Exception e) {
				
			} finally{
				//处理客户端断开连接以后的操作
				/*
				 * 将该客户端的输出流从共享集合中删除
				 */
				removeOut(nickName);
				
				sendMessage(nickName+"下线了!当前在线人数为:"+allOut.size());
				
				/*
				 * 将该客户端的Socket关闭以释放
				 * 资源
				 */
				if(socket != null){
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}














