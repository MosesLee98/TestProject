file://<WORKSPACE>/src/test/java/Index.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
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

	// Ensure rest is available
    @Test
    public void confirmHours() {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		for(String hours : databank.hours) {
			Assert.assertTrue(bodyText.contains(hours));
		}
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