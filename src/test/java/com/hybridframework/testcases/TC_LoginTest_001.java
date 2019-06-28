package com.hybridframework.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridframework.pageobjects.LoginPage;
///hybridframework/src/test/java/com/hybridframework/testcases/TC_LoginTest_001.java



public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("url is accessed");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("usename is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickLogin();
		logger.info("login is clicked");

		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Thread.sleep(5000);
			lp.clickLogout();
			logger.info("login is passed");
			Assert.assertTrue(true);
		} else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login is failed");
		}

	}

}
