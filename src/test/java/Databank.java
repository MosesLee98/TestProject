package test.java;

public class Databank {
    // URLs
    public String indexURL = "http://www.padthairestaurant.ca/index.php";
    public String aboutUsURL = "http://www.padthairestaurant.ca/aboutus.php";

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

    // Information
    public String location = "Unit 102-12540 Harris Road, \nPitt Meadows, BC V3Y 2J4";
    public String phoneNumber = "604-465-1650";
    public String email = "padthairestaurant@shaw.ca";
    public String[] contactInfo = {location, phoneNumber, email};
    public String lunchHours = "Tuesday - Friday: 11:30am - 2:30pm";
    public String dinnerHours = "Monday - Friday: 5pm - 8:30pm";
    public String saturdayHours = "Saturday: 11:30am - 8:30pm";
    public String sundayHours = "Sunday: Closed";
    public String[] hours = {lunchHours, dinnerHours, saturdayHours, sundayHours};

    // Home
    public String welcomeText = "Since December 1999, our passion for serving authentic Thai cuisine has created a loyal customer base here in Pitt Meadows and Tri-cities area.";
    public String ourCommitmentText = "Pad Thai Restaurant is committed to providing authentic and creative Thai cuisine. We are dedicated to serving consistent, authentic and unique Thai dishes in a warm and friendly atmosphere.";

    // About us
    public String ourHistoryText = "Sisters Jenny and Jessie Trakulthongroj have owned and operated the Pad Thai Restaurant in Pitt Meadows, BC since 1999.";
    public String awardWinningText = "Time's Readers Choice awards for Best Thai Restaurant in Pitt Meadows/Maple Ridge in 2011.";

    public Databank() {}
}
