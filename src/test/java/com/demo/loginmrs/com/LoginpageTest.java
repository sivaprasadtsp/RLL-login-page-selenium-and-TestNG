package com.demo.loginmrs.com;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.Baseclass;
import base.Loginpage;
import utilities.Dataprovider;

public class LoginpageTest extends Baseclass   {
	public static ExtentReports extentrepo;
	public static ExtentTest extenttest;

	Loginpage lp;
	@BeforeSuite
	public void initializeExtentReport() {
		ExtentSparkReporter sparkrepo =new ExtentSparkReporter("report3.html");
		extentrepo =new ExtentReports();
		extentrepo.attachReporter(sparkrepo);
		extentrepo.setSystemInfo("OS", System.getProperty("os.name"));
		extentrepo.setSystemInfo("JAVA", System.getProperty("java.version"));
	}
	@AfterSuite
	public void generatereport() throws IOException {
		extentrepo.flush();
		Desktop.getDesktop().browse(new File("report3.html").toURI());
	}
	
	@BeforeTest
	public void start_browser()
	{
		OpenBrowser("Chrome");
		
		lp = new Loginpage(driver);
		String ActualTitle= driver.getTitle();
		String ExpectedTitle= "Login";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	
	@Test(priority='1',dataProvider="excelData",dataProviderClass=Dataprovider.class)
	public void test_login(String u,String p) throws InterruptedException, IOException
	{
		lp.user_login(u,p);
		
		Thread.sleep(1000);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		
		File destFile = new File("./Screenshots/health.png");

		FileUtils.copyFile(srcFile, destFile);
		
		
SoftAssert sf = new SoftAssert();
		
		String expectedtitle = "OpenMRS";
		String actualtitle = driver.getTitle();
		
	}
	@AfterTest
	
	public void close(){
		
		closebrowser();
	}
			
	
}
