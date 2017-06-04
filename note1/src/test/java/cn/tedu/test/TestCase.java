package cn.tedu.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestCase {
	
	@Test
	public void testMd5(){
		String str = "12345678ÄãºÃ";
		String md5 = DigestUtils.md5Hex(str);
		System.out.println(md5);
			
	}
	
	@Test
	public void testSaltPwd(){
		String pwd = "123";
		String salt = "Äã³ÔÁËÂğ";
		String s = DigestUtils.md5Hex(pwd+salt);
		System.out.println(s);
		
		//16c1cac6ab164a4e840607339865d6ce
		
	}
}
