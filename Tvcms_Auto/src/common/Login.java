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
	    //����selenium Driver
		selenium = new DefaultSelenium("localhost", 4444, "*iexplore", BaseUrl);
		selenium.start();
		selenium.open("/tvcms");
		
		//�����˺����벢��½
		selenium.type("id=loginName", LoginName);
		selenium.type("id=password", Password);
		selenium.click("name=submit");		
		
		//��֤�Ƿ��½�ɹ�
		assert selenium.getText("link=�˳�ϵͳ") != null;
	}
	
	@AfterClass
	public void logout(){
		selenium.close();
		selenium.stop();
	}

}
