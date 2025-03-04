file://<WORKSPACE>/src/test/java/Databank.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file://<WORKSPACE>/src/test/java/Databank.java
text:
```scala
package test.java;

public class Databank {
    public String indexURL = "http://www.padthairestaurant.ca/index.php";
    public String aboutusURL = "http://www.padthairestaurant.ca/aboutus.php";

    public String home = "Home";
    public String aboutUs = "About us";
    public String menu = "Menu";
    public String contactUs = "Contact us";
    public String orderOnline = "Order Online";
	public String[] navbarItems = {home, aboutUs, menu, contactUs, orderOnline};

    // Contact Info
    public String location = "Unit 102-12540 Harris Road, \nPitt Meadows, BC V3Y 2J4";
    public String phoneNumber = "604-465-1650";
    public String email = "padthairestaurant@shaw.ca";
    public String[] contactInfo = {location, phoneNumber, email};

    // Hours
    public String lunchHours = "Tuesday - Friday: 11:30am - 2:30pm";
    public String dinnerHours = "Monday - Friday: 5pm - 8:30pm";
    public String saturdayHours = "Saturday: 11:30am - 8:30pm";
    public String sundayHours = "Sunday: Closed";
    public String[] hours = {lunchHours, dinnerHours, saturdayHours, sundayHours};

    // About us Te

    public Databank() {}
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