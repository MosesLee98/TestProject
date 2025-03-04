file://<WORKSPACE>/src/test/java/Index.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 1965
uri: file://<WORKSPACE>/src/test/java/Index.java
text:
```scala
package test.java;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

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

	// Ensure main content text is available
    @Test
    public void confirmMainContentTex@@() {
		String sidecardText = driver.findElement(By.id(databank.sidebarId)).getText();
		for(String hours : databank.hours) {
			Assert.assertTrue(sidecardText.contains(hours));
		}
    }

	// Go to About us page
	@Test
	public void goToAboutUs() {
		WebElement element = driver.findElement(By.linkText(databank.aboutUs));
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Assert.assertTrue(element.isSelected());
	}

	// Go to Menu page
	@Test
	public void goToMenu() {
		WebElement element = driver.findElement(By.linkText(databank.menu));
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Assert.assertTrue(element.isSelected());
	}

	// Go to Contact us page
	@Test
	public void goToContactUs() {
		WebElement element = driver.findElement(By.linkText(databank.contactUs));
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Assert.assertTrue(element.isSelected());
	}

	// Go to Order Online page
	@Test
	public void goToAOrderOnline() {
		WebElement element = driver.findElement(By.linkText(databank.orderOnline));
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Assert.assertTrue(element.isSelected());
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
	dotty.tools.pc.completions.CompletionProvider.completions(CompletionProvider.scala:50)
	dotty.tools.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator