package common;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.thoughtworks.selenium.DefaultSelenium;

public class Vod_modify {
	DefaultSelenium selenium;
	String loginName = "bestv";
	String password = "bestv";

	@Test
	public void f() {
		// ����˵������ݹ���->���缯����
		selenium.selectFrame("leftFrame");
		selenium.click("//td[@onclick='showsubmenu(2);']");
		selenium.click("link=���缯����");
		
		//��ѯ��Ŀ��ȫ����䡱
		selenium.selectFrame("main");
		selenium.type("id=search_Channel_contentParam_code", "1909874");
		String actorDisplay=selenium.getAttribute("id=actorDisplay");
		String writerDisplay=selenium.getAttribute("id=writerDisplay");
		selenium.type("id=actorDisplay", "autotest");
	}

	@BeforeClass
	public void beforeClass() {
		// �����������½tvcms
		selenium = new DefaultSelenium("localhost", 4444, "*iexplore",
				"http://10.61.41.40:8085");
		selenium.start();
		selenium.open("/tvcms");
		selenium.type("id=loginName", loginName);
		selenium.type("id=password", password);
		selenium.click("name=submit");
	}

	@AfterClass
	public void afterClass() {
		selenium.close();
	}

}
