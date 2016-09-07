package common;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.thoughtworks.selenium.DefaultSelenium;

public class Vod_queryByCode {
	DefaultSelenium selenium;

	@Test
	@Parameters({"vodCode"})
	public void queryByCode(String vodCode) {
		// ����˵������ݹ���->���缯����
		selenium.selectFrame("leftFrame");
		selenium.click("//td[@onclick='showsubmenu(2);']");
		selenium.click("link=���缯����");

		// ����CODE��ѯ��Ŀ
		selenium.selectWindow(null);
		selenium.type("id=search_Channel_contentParam_code", vodCode);
		selenium.click("css=input.button");
		
		//��֤��ѯ����Ƿ���ȷ
		selenium.click("link=�޸�");
		assert selenium.getText("//form[@id='editContent']/table[2]/tbody/tr[2]/td/table/tbody/tr/td[4]") == vodCode;
		//System.out.print(selenium.getText("//form[@id='editContent']/table[2]/tbody/tr[2]/td/table/tbody/tr/td[4]"));
	}


	@BeforeClass
	@Parameters({ "BaseUrl", "LoginName", "Password" })
	public void beforeClass(String BaseUrl,String LoginName,String Password) {
		// �����������½tvcms
		selenium = new DefaultSelenium("localhost", 4444, "*iexplore", BaseUrl);
		selenium.start();
		selenium.open("/tvcms");
		selenium.type("id=loginName", LoginName);
		selenium.type("id=password", Password);
		selenium.click("name=submit");
	}

	@AfterClass
	public void afterClass() {
		 selenium.close();
		 selenium.stop();
	}
}
