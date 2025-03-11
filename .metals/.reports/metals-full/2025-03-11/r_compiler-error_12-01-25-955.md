file://<WORKSPACE>/src/test/java/Databank.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 3292
uri: file://<WORKSPACE>/src/test/java/Databank.java
text:
```scala
package test.java;

public class Databank {
    // URLs
    public String indexURL = "http://www.padthairestaurant.ca/index.php";
    public String aboutUsURL = "http://www.padthairestaurant.ca/aboutus.php";
    public String contactURL = "http://www.padthairestaurant.ca/contact.php";
    public String sendFormURL = "http://www.padthairestaurant.ca/send_form_email.php";
    public String menuURL = "http://www.padthairestaurant.ca/menu.php";

    // Navbar
    public String home = "Home";
    public String aboutUs = "About us";
    public String menu = "Menu";
    public String contactUs = "Contact us";
    public String orderOnline = "Order Online";
	public String[] navbarItems = {home, aboutUs, menu, contactUs, orderOnline};

    // Ids
    public String sidebarId = "sidebar";
    public String mainContentId = "textarea";

    // Static information
    public String location = "Unit 102-12540 Harris Road, \nPitt Meadows, BC V3Y 2J4";
    public String phoneNumber = "604-465-1650";
    public String email = "padthairestaurant@shaw.ca";
    public String[] contactInfo = {location, phoneNumber, email};
    public String lunchHours = "Tuesday - Friday: 11:30am - 2:30pm";
    public String dinnerHours = "Monday - Friday: 5pm - 8:30pm";
    public String saturdayHours = "Saturday: 11:30am - 8:30pm";
    public String sundayHours = "Sunday: Closed";
    public String[] hours = {lunchHours, dinnerHours, saturdayHours, sundayHours};
    public String[] weekdayHours = {lunchHours, dinnerHours};

    // Home
    public String welcomeText = "Since December 1999, our passion for serving authentic Thai cuisine has created a loyal customer base here in Pitt Meadows and Tri-cities area.";
    public String ourCommitmentText = "Pad Thai Restaurant is committed to providing authentic and creative Thai cuisine. We are dedicated to serving consistent, authentic and unique Thai dishes in a warm and friendly atmosphere.";

    // About us
    public String ourHistoryText = "Sisters Jenny and Jessie Trakulthongroj have owned and operated the Pad Thai Restaurant in Pitt Meadows, BC since 1999.";
    public String awardWinningText = "Time's Readers Choice awards for Best Thai Restaurant in Pitt Meadows/Maple Ridge in 2011.";

    // Contact
    public String formName = "name";
    public String formEmail = "email";
    public String formComments = "comments";
    public String[] contactFormInputs = {formName, formEmail, formComments};
    public String formErrorText = "We are very sorry, but there were error(s) found with the form you submitted. These errors appear below.";
    public String commentErrorText = "You have not entered any comments";
    public String emailErrorText = "This email address does not appear to be valid.";
    public String formSuccessText = "Thank you very much for contacting us. Your feedback is valuable.";
    // Form mock data
    public String validName = "Quinn Hughes";
    public String validEmail = "QuinnHughes43@gmail.com";
    public String validComments = "Excellent Pad Thai here!";
    public String invalidEmail = "invalidEmail";

    // Menu
    public String lunch = "Lunch";
    public String dinner = "Dinner";
    public String[] menuTitles = {lunch, dinner};
    public String[] lunchItems = {"Pad Thai with Salad", "@@"}


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
	dotty.tools.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:32)
	dotty.tools.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:422)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator