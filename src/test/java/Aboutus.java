package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Aboutus {
    WebDriver driver;
    Databank databank = new Databank();

	// Setup driver and go to aboutus.php
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(databank.aboutUsURL);
    }

    // Teardown driver
    @AfterTest
    public void teardown() {
        driver.quit();
    }

	// Ensure we are selected on the About us page (sanity test)
    @Test
    public void aboutUsSanity() {
        String aboutUsText = databank.aboutUs;
        WebElement element = driver.findElement(By.linkText(aboutUsText));
        Assert.assertTrue(element.isSelected());
    }

	// Ensure contact info is available
    @Test
    public void confirmContactInfo() {
        String sidecardText = driver.findElement(By.id(databank.sidebarId)).getText();
		for(String info : databank.contactInfo) {
			Assert.assertTrue(sidecardText.contains(info));
		}
    }

	// Ensure restaurant hours are available
    @Test
    public void confirmHours() {
		String sidecardText = driver.findElement(By.id(databank.sidebarId)).getText();
		for(String hours : databank.hours) {
			Assert.assertTrue(sidecardText.contains(hours));
		}
    }

	// Confirm main content text
	@Test
	public void confirmMainContentText() {
		String mainContent = driver.findElement(By.id(databank.mainContentId)).getText();
		Assert.assertTrue(mainContent.contains(databank.ourHistoryText));
		Assert.assertTrue(mainContent.contains(databank.awardWinningText));
	}
}