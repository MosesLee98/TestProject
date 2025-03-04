file://<WORKSPACE>/src/test/java/Databank.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 232
uri: file://<WORKSPACE>/src/test/java/Databank.java
text:
```scala
package test.java;

public class Databank {
    public String indexURL = "http://www.padthairestaurant.ca/index.php";
    public String aboutUsURL = "http://www.padthairestaurant.ca/aboutus.php";

    // ids
    public String aboutU@@ = "textarea";

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

    // About us Text
    public String ourHistoryText = "Sisters Jenny and Jessie Trakulthongroj have owned and operated the Pad Thai Restaurant in Pitt Meadows, BC since 1999.";
    public String awardWinningText = "Time's Readers Choice awards for Best Thai Restaurant in Pitt Meadows/Maple Ridge in 2011.";

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
	dotty.tools.pc.completions.CompletionProvider.completions(CompletionProvider.scala:50)
	dotty.tools.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:146)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator