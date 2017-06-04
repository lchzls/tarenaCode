package day06;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File
 * 该类用于描述文件系统中的一个文件或目录
 * File可以:
 * 1:访问文件或目录的属性信息
 * 2:访问一个目录中的所有子项
 * 3:操作文件或目录(创建，删除)
 * File不可以:
 * File不可以访问文件数据
 * @author adminitartor
 *
 */
public class FileDemo1 {
	public static void main(String[] args) {
		/*
		 * 路径尽量不写绝对路径
		 * 常用的是使用相对路径:
		 * 1:相对于项目目录（当前目录）
		 * 2:相对于类加载目录（实际开发更常用）
		 */   
		File file = new File(
			"."+File.separator+"test.txt"
		);
		
		/*
		 * 获取当前文件的属性信息
		 */
		//获取文件或目录名
		String name = file.getName();
		System.out.println("name:"+name);
		//获取文件长度(字节)
		long length = file.length();
		System.out.println("length:"+length+"字节");
		//最后修改时间
		long time = file.lastModified();
		System.out.println("最后修改时间:"+time);
		Date date = new Date(time);
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy年M月d日，H:m:s"
			);
		System.out.println("最后修改时间:"+sdf.format(date));
		/*
		 * 可读，可写，可运行
		 */
		file.canRead();
		file.canWrite();
		file.canExecute();
		boolean canWrite = file.canWrite();
		System.out.println("只读:"+!canWrite);
		
		file.isHidden();
	}
}














