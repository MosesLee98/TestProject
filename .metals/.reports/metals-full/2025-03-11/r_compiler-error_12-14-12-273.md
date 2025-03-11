file://<WORKSPACE>/src/test/java/Menu.java
### java.lang.AssertionError: assertion failed: position not set for <error> # -1 of class dotty.tools.dotc.ast.Trees$Ident in <WORKSPACE>/src/test/java/Menu.java

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file://<WORKSPACE>/src/test/java/Menu.java
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
    @
}

```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:8)
	dotty.tools.dotc.typer.Typer$.assertPositioned(Typer.scala:72)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3262)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3271)
	dotty.tools.dotc.typer.Typer.typedType(Typer.scala:3385)
	dotty.tools.dotc.typer.Namer.typedAheadType$$anonfun$1(Namer.scala:1698)
	dotty.tools.dotc.typer.Namer.typedAhead(Namer.scala:1691)
	dotty.tools.dotc.typer.Namer.typedAheadType(Namer.scala:1698)
	dotty.tools.dotc.typer.Namer.typedAheadAnnotationClass(Namer.scala:1707)
	dotty.tools.dotc.typer.Namer.typedAheadAnnotationClass(Namer.scala:1706)
	dotty.tools.dotc.typer.Namer.typedAheadAnnotationClass(Namer.scala:1704)
	dotty.tools.dotc.typer.Namer$Completer.addAnnotations$$anonfun$1(Namer.scala:850)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.immutable.List.foreach(List.scala:334)
	dotty.tools.dotc.typer.Namer$Completer.addAnnotations(Namer.scala:849)
	dotty.tools.dotc.typer.Namer$Completer.completeInCreationContext(Namer.scala:950)
	dotty.tools.dotc.typer.Namer$Completer.complete(Namer.scala:828)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.completeFrom(SymDenotations.scala:174)
	dotty.tools.dotc.core.Denotations$Denotation.completeInfo$1(Denotations.scala:188)
	dotty.tools.dotc.core.Denotations$Denotation.info(Denotations.scala:190)
	dotty.tools.dotc.core.SymDenotations$SymDenotation.ensureCompleted(SymDenotations.scala:392)
	dotty.tools.dotc.typer.Typer.retrieveSym(Typer.scala:3057)
	dotty.tools.dotc.typer.Typer.typedNamed$1(Typer.scala:3082)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3196)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3267)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3271)
	dotty.tools.dotc.typer.Typer.traverse$1(Typer.scala:3293)
	dotty.tools.dotc.typer.Typer.typedStats(Typer.scala:3339)
	dotty.tools.dotc.typer.Typer.typedClassDef(Typer.scala:2736)
	dotty.tools.dotc.typer.Typer.typedTypeOrClassDef$1(Typer.scala:3104)
	dotty.tools.dotc.typer.Typer.typedNamed$1(Typer.scala:3108)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3196)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3267)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3271)
	dotty.tools.dotc.typer.Typer.traverse$1(Typer.scala:3293)
	dotty.tools.dotc.typer.Typer.typedStats(Typer.scala:3339)
	dotty.tools.dotc.typer.Typer.typedPackageDef(Typer.scala:2879)
	dotty.tools.dotc.typer.Typer.typedUnnamed$1(Typer.scala:3149)
	dotty.tools.dotc.typer.Typer.typedUnadapted(Typer.scala:3197)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3267)
	dotty.tools.dotc.typer.Typer.typed(Typer.scala:3271)
	dotty.tools.dotc.typer.Typer.typedExpr(Typer.scala:3382)
	dotty.tools.dotc.typer.TyperPhase.typeCheck$$anonfun$1(TyperPhase.scala:45)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:458)
	dotty.tools.dotc.typer.TyperPhase.typeCheck(TyperPhase.scala:51)
	dotty.tools.dotc.typer.TyperPhase.$anonfun$4(TyperPhase.scala:97)
	scala.collection.Iterator$$anon$6.hasNext(Iterator.scala:479)
	scala.collection.Iterator$$anon$9.hasNext(Iterator.scala:583)
	scala.collection.immutable.List.prependedAll(List.scala:152)
	scala.collection.immutable.List$.from(List.scala:685)
	scala.collection.immutable.List$.from(List.scala:682)
	scala.collection.IterableOps$WithFilter.map(Iterable.scala:900)
	dotty.tools.dotc.typer.TyperPhase.runOn(TyperPhase.scala:96)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:315)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1323)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:308)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:349)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:358)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:69)
	dotty.tools.dotc.Run.compileUnits(Run.scala:358)
	dotty.tools.dotc.Run.compileSources(Run.scala:261)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:161)
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

java.lang.AssertionError: assertion failed: position not set for <error> # -1 of class dotty.tools.dotc.ast.Trees$Ident in <WORKSPACE>/src/test/java/Menu.java