file://<WORKSPACE>/src/test/java/Index.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 760
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

public class Index {
    WebDriver driver;
    Databank databank = new Databank();

    // Helper Functions
    public boolean isClickable(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    // setup driver and go to index.php
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get(databank.indexURL);
    }

    // teardown driver
    @AfterTest
    public void teardown() {
        driver.quit();
    }

    // Ensure all buttons on navba@@r are clickable
    @Test
    public void confirmNavbar() {
        for(String item : databank.navBarItems) {
            WebElement element = driver.findElement(By.linkText(item));
            Assert.assertTrue(isClickable(element));
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
	dotty.tools.pc.HoverProvider$.hover(HoverProvider.scala:40)
	dotty.tools.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:376)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator