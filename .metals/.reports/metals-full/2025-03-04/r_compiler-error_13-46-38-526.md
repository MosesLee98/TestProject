file://<WORKSPACE>/src/test/java/Index.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file://<WORKSPACE>/src/test/java/Index.java
text:
```scala
package test.java;
import test.java.Databank;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Index {
    WebDriver driver;
    Databank

    // Helper Functions
    public boolean isClickable(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    // setup driver and go to index.php
    @BeforeTest
    public void setup() {
        String url = "http://www.padthairestaurant.ca/index.php";
        driver = new ChromeDriver();
        driver.get(url);
    }

    // teardown driver
    @AfterTest
    public void teardown() {
        driver.quit();
    }

    // Ensure all buttons on navbar are clickable
    @Test
    public void confirmNavbar() {
        // About us
        WebElement element = driver.findElement(By.linkText("About us"));
        Assert.assertTrue(isClickable(element));

        // Menu
        element = driver.findElement(By.linkText("Menu"));
        Assert.assertTrue(isClickable(element));

        // Contact us
        element = driver.findElement(By.linkText("Contact us"));
        Assert.assertTrue(isClickable(element));

        // Order Online
        element = driver.findElement(By.linkText("Order Online"));
        Assert.assertTrue(isClickable(element));
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