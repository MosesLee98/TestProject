file://<WORKSPACE>/src/test/java/Aboutus.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 1252
uri: file://<WORKSPACE>/src/test/java/Aboutus.java
text:
```scala
package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	// Confirm "Our History" text block
	@Test
	public void confirmOurHistory() {
		String bodyText = driv@@er.findElement(By.id(databank.infoId)).getText();
		Assert.assertTrue(bodyText.contains(databank.ourHistoryText));
	}

	// Confirm "Award-Winning" text block
	@Test
	public void confirmAwardWinning() {
		String bodyText = driver.findElement(By.id(databank.infoId)).getText();
		Assert.assertTrue(bodyText.contains(databank.awardWinningText));
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