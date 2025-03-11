package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Menu {
	WebDriver driver;
    Databank databank = new Databank();

	// Setup driver and go to contact.php
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(databank.menuURL);
    }

    // Teardown driver
    @AfterTest
    public void teardown() {
        driver.quit();
    }

	// Ensure we are selected on the Menu page (sanity test)
    @Test
    public void menuSanity() {
        String menuText = databank.menu;
        WebElement element = driver.findElement(By.linkText(menuText));
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
		for(String hours : databank.weekdayHours) {
			Assert.assertTrue(sidecardText.contains(hours));
		}
    }

    // Ensure lunch and dinner menus are available
    @Test
    public void confirmMenusAvailable() {
        for(String menu : databank.menuTitles) {
            WebElement elem = driver.findElement(By.linkText(menu));
            Assert.assertTrue(elem.isDisplayed() && elem.isEnabled());
        }
    }

    // Confirm lunch menu content
    @Test
    public void validateLunchMenu() {
        WebElement lunchElem = driver.findElement(By.linkText(databank.lunch));
        Assert.assertTrue(lunchElem.isDisplayed() && lunchElem.isEnabled());
        lunchElem.click();

        WebElement lunchMenu = driver.findElement(By.tagName("tbody"));
        for(int i = 0; i < databank.lunchItems.length; i++) {
            Assert.assertTrue(lunchMenu.getText().contains(databank.lunchItems[i]));
            Assert.assertTrue(lunchMenu.getText().contains(databank.lunchPrices[i]));
        }
    }

    // Confirm dinner menu navigation works
    @Test
    public void testDinnerNavigation() {
        // stub
    }
}
