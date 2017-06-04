package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*�Զ���JSTL��ǩ�࣬�������������ʱ��
 * ʱ����Ĭ�ϵĸ�ʽ��Ҳ����ָ��һ����ʽ
 * */
public class SysdateTag extends SimpleTagSupport {
 
	//ʱ�� �ĸ�ʽ����Ĭ��ֵ������ͨ��set�����޸���ֵ��
	private String format ="yyyy/MM/dd HH:mm:ss";
	
	public void setFormat(String format){
		this.format =format;
	}
	
	public String getFormat(String format){
		return format;
		
	}
	
	
	@Override
	public void doTag() throws JspException, IOException {
	//����������ʱ��
		Date date = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String now = sdf.format(date);
		//��ʱ������������
		//�÷�����������JspContext�����ࣩ
		//�÷���ʵ�ʷ��ص���PageContext�����ࣩ
		//PageContext extends JspContext
		
		PageContext ctx = (PageContext) getJspContext();
		JspWriter out = ctx.getOut(); //��ȡ����
		out.println(now);
		//�˴��������ܹرգ���ΪJSP�ϻ��������ı�ǩҪʹ�������
		
	}

}
