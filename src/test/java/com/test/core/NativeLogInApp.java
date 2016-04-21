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

public class NativeLogInApp {
	public AndroidDriver driver;

	@Test(priority = 1)
	public void setUp() throws MalformedURLException {

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
		System.out.println("----userAggrement----");
		driver.findElement(By.id("com.irobot.home:id/userAgreementCheckbox")).click();
	}

	@Test(priority = 4)
	public void setUpANewRoomba() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----setUpANewRoomba----");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		System.out.println("s=" + scrollStart);
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0, scrollStart, 0, scrollEnd, 2000);
		Thread.sleep(10000);

		WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.widget.TextView[contains(@resource-id, 'com.irobot.home:id/setupNewText')]")));

		el.click();
		System.out.println("---clicked on setUpANewRoomba---");
	}

	@Test(priority = 5)
	public void nextOne() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----nextOne----");
		driver.findElement(By.id("com.irobot.home:id/nextButton")).click();
	}

	@Test(priority = 6)
	public void nextTwo() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----nextTwo----");
		driver.findElement(By.id("com.irobot.home:id/nextButton")).click();
	}

	@Test(priority = 7)
	public void letsGo() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----letsGo----");
		driver.findElement(By.id("com.irobot.home:id/goButton")).click();
	}

	@Test(priority = 8)
	public void continueOne() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----continueOne----");
		driver.findElement(By.id("com.irobot.home:id/continueButton")).click();
	}

	@Test(priority = 9)
	public void wifiSettings() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----wifiSettings----");
		driver.findElement(By.id("com.irobot.home:id/table_row_text")).sendKeys("swtester1234");
		driver.findElement(By.id("com.irobot.home:id/continueButton")).click();
	}

	@Test(priority = 10)
	public void activateRoomba() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----activateRoomba----");
		driver.findElement(By.id("com.irobot.home:id/continueButton")).click();
	}

	@Test(priority = 11)
	public void success() {
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.widget.Button[contains(@resource-id, 'com.irobot.home:id/continueButton')]")));

		el.click();
		System.out.println("----success----");

	}

	@Test(priority = 12)
	public void personalizeRooma() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----personalizeRooma----");
		driver.findElement(By.id("com.irobot.home:id/robotNameInput")).sendKeys("Roomba 6945");
	}

	@Test(priority = 13)
	public void inputEmailId() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----inputEmailId----");
		driver.findElement(By.id("com.irobot.home:id/table_row_text")).sendKeys("swtesterirobot1234@gmail.com");
	}

	@Test(priority = 14)
	public void clickOnDone() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----clickOnDone----");
		driver.findElement(By.id("com.irobot.home:id/btnDone")).click();
	}
}
