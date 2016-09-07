package common;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.thoughtworks.selenium.DefaultSelenium;

public class Login {
	DefaultSelenium selenium;

	@Test
	@Parameters({ "BaseUrl", "LoginName", "Password" })
	public void testLogin(String BaseUrl,String LoginName,String Password) {
	    //启动selenium Driver
		selenium = new DefaultSelenium("localhost", 4444, "*iexplore", BaseUrl);
		selenium.start();
		selenium.open("/tvcms");
		
		//输入账号密码并登陆
		selenium.type("id=loginName", LoginName);
		selenium.type("id=password", Password);
		selenium.click("name=submit");		
		
		//验证是否登陆成功
		assert selenium.getText("link=退出系统") != null;
	}
	
	@AfterClass
	public void logout(){
		selenium.close();
		selenium.stop();
	}

}
