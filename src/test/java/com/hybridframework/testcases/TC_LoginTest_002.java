package com.hybridframework.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.hybridframework.pageobjects.LoginPage;
import com.hybridframework.utilities.XLUtils;

public class TC_LoginTest_002 extends BaseClass {

	@Test(dataProvider = "Login")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {

		driver.get(baseURL);
		driver.manage().window().maximize();

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		logger.info("User provided"); // logger msg

		lp.setPassword(pwd);
		logger.info("Password provided");// logger msg

		lp.clickLogin();
		logger.info("Login in Clicked");// logger msg

		Thread.sleep(2000);

		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clickLogout();
			Assert.assertTrue(true);

		} else {
			logger.info("Login Failed");// logger msg
			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "Login")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/hybridframework/testdata/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return logindata;

	}

}
