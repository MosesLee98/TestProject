package test.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Contact {
    WebDriver driver;
    Databank databank = new Databank();

	// Setup driver and go to contact.php
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(databank.contactURL);
    }

    // Teardown driver
    @AfterTest
    public void teardown() {
        driver.quit();
    }

	// Ensure we are selected on the Contact us page (sanity test)
    @Test
    public void contactUsSanity() {
        String contactUsText = databank.contactUs;
        WebElement element = driver.findElement(By.linkText(contactUsText));
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

	// Confirm map is available (iframe)
	@Test
	public void confirmMapIframe() {
		Assert.assertFalse(driver.findElements(By.tagName("iframe")).isEmpty());
	}

    // Ensure contact us form is available and submittable - Happy Path
    @Test
    public void contactUsFormSuccess() {
        WebElement formName = driver.findElement(By.name(databank.formName));
        WebElement formEmail = driver.findElement(By.name(databank.formEmail));
        WebElement formComments = driver.findElement(By.name(databank.formComments));
        WebElement formSubmit = driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']"));
        // fill in values
        formName.sendKeys(databank.validName);
        formEmail.sendKeys(databank.validEmail);
        formComments.sendKeys(databank.validComments);
        // press submit button
        Assert.assertTrue(formSubmit.isDisplayed() && formSubmit.isEnabled());
        formSubmit.click();
        // confirm successful form submission
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(databank.sendFormURL));
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.getText().contains(databank.formSuccessText));
    }

    // Ensure contact us form is not submittable with empty content - Fail Path
    @Test
    public void contactUsFormEmpty() {
        WebElement formSubmit = driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']"));
        Assert.assertTrue(formSubmit.isDisplayed() && formSubmit.isEnabled());
        formSubmit.click();
        // confirm failed form submission
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(databank.sendFormURL));
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.getText().contains(databank.formErrorText));
        Assert.assertTrue(body.getText().contains(databank.commentErrorText));
    }

    // contact form invalid name - Fail Path
    @Test
    public void contactUsFormInvalidName() {
        WebElement formEmail = driver.findElement(By.name(databank.formEmail));
        WebElement formComments = driver.findElement(By.name(databank.formComments));
        WebElement formSubmit = driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']"));
        // fill in values
        formEmail.sendKeys(databank.validEmail);
        formComments.sendKeys(databank.validComments);
        // press submit button
        Assert.assertTrue(formSubmit.isDisplayed() && formSubmit.isEnabled());
        formSubmit.click();
        // confirm failed form submission
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(databank.sendFormURL));
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.getText().contains(databank.formErrorText));
    }

    // contact form invalid email - Fail Path
    @Test
    public void contactUsFormInvalidEmail() {
        WebElement formName = driver.findElement(By.name(databank.formName));
        WebElement formComments = driver.findElement(By.name(databank.formComments));
        WebElement formSubmit = driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']"));
        // fill in values
        formName.sendKeys(databank.validName);
        formComments.sendKeys(databank.validComments);
        // press submit button
        Assert.assertTrue(formSubmit.isDisplayed() && formSubmit.isEnabled());
        formSubmit.click();
        // confirm failed form submission
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(databank.sendFormURL));
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.getText().contains(databank.formErrorText));
        Assert.assertTrue(body.getText().contains(databank.emailErrorText));
    }

    // contact form invalid comments - Fail Path
    @Test
    public void contactUsFormInvalidComments() {
        WebElement formName = driver.findElement(By.name(databank.formName));
        WebElement formEmail = driver.findElement(By.name(databank.formEmail));
        WebElement formSubmit = driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']"));
        // fill in values
        formName.sendKeys(databank.validName);
        formEmail.sendKeys(databank.validEmail);
        // press submit button
        Assert.assertTrue(formSubmit.isDisplayed() && formSubmit.isEnabled());
        formSubmit.click();
        // confirm failed form submission
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(databank.sendFormURL));
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.getText().contains(databank.formErrorText));
        Assert.assertTrue(body.getText().contains(databank.commentErrorText));
    }
}