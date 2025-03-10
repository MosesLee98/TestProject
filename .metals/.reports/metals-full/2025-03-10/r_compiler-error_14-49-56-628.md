file://<WORKSPACE>/src/test/java/Contact.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 1992
uri: file://<WORKSPACE>/src/test/java/Contact.java
text:
```scala
package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void confirmContactUsForm() {
        WebElement formName = driver.findElement(By.name(databank.formName));
        WebElement formEmail = driver.findElement(By.name(databank.formEmail));
        WebElement formComments = @@driver.findElement(By.name(databank.formComments));
        

    }
}
```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:935)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:164)
	dotty.tools.pc.MetalsDriver.run(MetalsDriver.scala:45)
	dotty.tools.pc.HoverProvider$.hover(HoverProvider.scala:40)
	dotty.tools.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:376)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator