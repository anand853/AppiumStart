package com.test.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.log4j.Logger;

public class NativeLogInApp {
	public AndroidDriver driver;
	static Logger log = Logger.getLogger(NativeLogInApp.class.getName());

	@Test(priority = 1)
	public void setUp() throws MalformedURLException {

		// File resourcesDirectory = new File("src/test/resources"); maven to
		// get the resoure folder

		File appDir = new File(Constants.FOLDER_PATH);
		File app = new File(appDir, Constants.APP_NAME);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(Constants.DEVICE, Constants.ANDROID);

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.GALAXY_S6);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Constants.ANDROID);

		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver(new URL(Constants.APPIUM_URL), capabilities);

	}

	@Test(priority = 2)
	public void getTexts() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String welcome = driver.findElement(By.xpath("//android.widget.TextView[@text='Welcome!']")).getText();
		Assert.assertEquals(welcome, "Welcome!");

		String please_accept = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Please accept the following:']")).getText();
		Assert.assertEquals(please_accept, "Please accept the following:");

		String end_user_agre = driver
				.findElement(
						By.xpath("//android.widget.TextView[@text='Accept End User License Agreement (required)']"))
				.getText();
		Assert.assertEquals(end_user_agre, "Accept End User License Agreement (required)");

		String review = driver.findElement(By.xpath("//android.widget.TextView[@text='Review']")).getText();
		Assert.assertEquals(review, "Review");

		String app_lang = driver.findElement(By.xpath("//android.widget.TextView[@text='App Language']")).getText();
		Assert.assertEquals(app_lang, "App Language");

		String automatic = driver.findElement(By.xpath("//android.widget.TextView[@text='Automatic (set by device)']"))
				.getText();
		Assert.assertEquals(automatic, "Automatic (set by device)");

		String stay_tuned = driver.findElement(By.xpath("//android.widget.TextView[@text='Stay Informed']")).getText();
		Assert.assertEquals(stay_tuned, "Stay Informed");

		String aboutThisApp = driver.findElement(By.xpath("//android.widget.TextView[@text='About this App']"))
				.getText();
		Assert.assertEquals(aboutThisApp, "About this App");

	}

	@Test(priority = 3)
	public void clickUserAggrement() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----userAggrement----");
		log.info("Hello this is an info message");
		driver.findElement(By.id("com.irobot.home:id/userAgreementCheckbox")).click();
	}

	@Test(priority = 4)
	public void setUpANewRoomba() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----setUpANewRoomba----");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();

		Double screenHeightEnd = dimensions.getHeight() * 0.1;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
		Thread.sleep(10000);
		log.info("--dimensions---" + dimensions);
		log.info("--screenHeightStart---" + screenHeightStart);
		log.info("--scrollStart---" + scrollStart);
		log.info("--screenHeightEnd---" + screenHeightEnd);
		log.info("--scrollEnd---" + scrollEnd);

		WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.widget.TextView[contains(@resource-id, 'com.irobot.home:id/setupNewText')]")));

		el.click();
		log.info("---clicked on setUpANewRoomba---");
	}

	@Test(priority = 5)
	public void nextOne() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----nextOne----");
		driver.findElement(By.id("com.irobot.home:id/nextButton")).click();
	}

	@Test(priority = 6)
	public void nextTwo() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----nextTwo----");
		driver.findElement(By.id("com.irobot.home:id/nextButton")).click();
	}

	@Test(priority = 7)
	public void letsGo() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----letsGo----");
		driver.findElement(By.id("com.irobot.home:id/goButton")).click();
	}

	@Test(priority = 8)
	public void continueOne() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----continueOne----");
		driver.findElement(By.id("com.irobot.home:id/continueButton")).click();
	}

	@Test(priority = 9)
	public void wifiSettings() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----wifiSettings----");
		driver.findElement(By.id("com.irobot.home:id/table_row_text")).sendKeys("swtester1234");
		driver.findElement(By.id("com.irobot.home:id/continueButton")).click();
	}

	@Test(priority = 10)
	public void activateRoomba() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----activateRoomba----");
		driver.findElement(By.id("com.irobot.home:id/continueButton")).click();
	}

	@Test(priority = 11)
	public void success() {
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.widget.Button[contains(@resource-id, 'com.irobot.home:id/continueButton')]")));

		el.click();
		log.info("----success----");

	}

	@Test(priority = 12)
	public void personalizeRooma() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----personalizeRooma----");
		driver.findElement(By.id("com.irobot.home:id/robotNameInput")).sendKeys("Roomba 6945");
	}

	@Test(priority = 13)
	public void inputEmailId() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----inputEmailId----");
		driver.findElement(By.id("com.irobot.home:id/table_row_text")).sendKeys("swtesterirobot1234@gmail.com");
	}

	@Test(priority = 14)
	public void clickOnDone() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("----clickOnDone----");
		driver.findElement(By.id("com.irobot.home:id/btnDone")).click();
	}
}
