file://<WORKSPACE>/src/test/java/Aboutus.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
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

	// Confirm "Our History" text block
	@Test
	public void confirmOurHistory() {
		String mainContent = driver.findElement(By.id(databank.mainContentId)).getText();
		Assert.assertTrue(mainContent.contains(databank.ourHistoryText));
		As
	}

	// Confirm "Award-Winning" text block
	@Test
	public void confirmAwardWinning() {
		String bodyText = driver.findElement(By.id(databank.mainContentId)).getText();
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
	dotty.tools.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:31)
	dotty.tools.pc.SimpleCollector.<init>(PcCollector.scala:345)
	dotty.tools.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:63)
	dotty.tools.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:88)
	dotty.tools.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:109)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator