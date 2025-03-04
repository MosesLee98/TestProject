package test.java;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Index {
    WebDriver driver;
    Databank databank = new Databank();

    // Helper Functions
    public boolean isClickable(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    // Setup driver and go to index.php
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(databank.indexURL);
    }

    // Teardown driver
    @AfterTest
    public void teardown() {
        driver.quit();
    }

    // Ensure we are selected on the home page (sanity test)
    @Test
    public void homepageSanity() {
        String homeText = databank.navbarItems[0];
        WebElement element = driver.findElement(By.linkText(homeText));
        Assert.assertTrue(element.isSelected());
    }

    // Ensure all buttons on navbar are clickable
    @Test
    public void confirmNavbarItems() {
        for(String item : databank.navbarItems) {
            WebElement element = driver.findElement(By.linkText(item));
            Assert.assertTrue(isClickable(element));
        }
    }

	// Ensure contact info is available
    @Test
    public void confirmContactInfo() {
        String bodyText = driver.findElement(By.tagName("body")).getText();
		for(String info : databank.contactInfo) {
			Assert.assertTrue(bodyText.contains(info));
		}
    }

	// Ensure restaurant hours are available
    @Test
    public void confirmHours() {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		for(String hours : databank.hours) {
			Assert.assertTrue(bodyText.contains(hours));
		}
    }

	// Go to About us page
	@Test
	public void goToAboutUs() {
		WebElement element = driver.findElement(By.linkText(databank.aboutUs));
		element.click();
		Assert.assertTrue(element.isSelected());
	}

}
