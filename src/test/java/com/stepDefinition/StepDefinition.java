package com.stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ccl.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	BaseClass b = new BaseClass();
	WebDriver driver;

	@Given("User launches Adactin Web Application")
	public void user_launches_Adactin_Web_Application() {
		driver = b.launchBrowser();
		b.launchUrl("http://adactinhotelapp.com/");
	}

	@When("User enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() {
		WebElement txtUsername = driver.findElement(By.id("username"));
		b.sendkeys(txtUsername, "Raji6193");
		WebElement txtPassword = driver.findElement(By.id("password"));
		b.sendkeys(txtPassword, "Raji6193");
	}

	@And("User clicks Login button")
	public void user_clicks_Login_button() {
		WebElement btnLogin = driver.findElement(By.id("login"));
		b.btnClick(btnLogin);
	}

	@Then("User verify Home page is displayed")
	public void user_verify_Home_page_is_displayed() {
		WebElement hdgHome = driver.findElement(By.xpath("//td[@class='login_title']"));
		String headingHome = hdgHome.getText();
		System.out.println(headingHome);
		Assert.assertTrue(headingHome.contains("Search Hotel"));
	}

	@When("User enters valid location, Hotel, Room Type, Number of Rooms, check in date, check out date, Adults count and children count")
	public void user_enters_valid_location_Hotel_Room_Type_Number_of_Rooms_check_in_date_check_out_date_Adults_count_and_children_count() {
		WebElement dropdownLocation = driver.findElement(By.id("location"));
		b.selectByVisibleTextDropDown(dropdownLocation, "New York");
		WebElement dropdownHotel = driver.findElement(By.id("hotels"));
		b.selectByVisibleTextDropDown(dropdownHotel, "Hotel Sunshine");
		WebElement dropdownRoomType = driver.findElement(By.id("room_type"));
		b.selectByVisibleTextDropDown(dropdownRoomType, "Deluxe");
		WebElement dropdownRoomNos = driver.findElement(By.id("room_nos"));
		b.selectByVisibleTextDropDown(dropdownRoomNos, "3 - Three");
		WebElement txtCheckInDate = driver.findElement(By.id("datepick_in"));
		b.sendkeys(txtCheckInDate, "10/20/2022");
		WebElement txtCheckOutDate = driver.findElement(By.id("datepick_out"));
		b.sendkeys(txtCheckOutDate, "10/25/2022");
		WebElement dropdownAdultCount = driver.findElement(By.id("adult_room"));
		b.selectByVisibleTextDropDown(dropdownAdultCount, "2 - Two");
		WebElement dropdownChildCount = driver.findElement(By.id("child_room"));
		b.selectByVisibleTextDropDown(dropdownChildCount, "2 - Two");
	}

	@And("User clicks search")
	public void user_clicks_search() {
		WebElement btnSearch = driver.findElement(By.id("Submit"));
		b.btnClick(btnSearch);
	}

	@Then("User verify Select hotel page is displayed")
	public void user_verify_Select_hotel_page_is_displayed() {
		WebElement hdgSelect = driver.findElement(By.xpath("//td[@class='login_title']"));
		String headingSelect = hdgSelect.getText();
		System.out.println(headingSelect);
		Assert.assertTrue(headingSelect.contains("Select Hotel"));
	}

	@And("User clicks Select button")
	public void user_clicks_Select_button() {
		WebElement btnRadio = driver.findElement(By.id("radiobutton_0"));
		b.btnClick(btnRadio);
	}

	@And("User clicks Continue button")
	public void user_clicks_Continue_button() {
		WebElement btnContinue = driver.findElement(By.id("continue"));
		b.btnClick(btnContinue);
	}

	@When("User enters FirstName, LastName, BillingAddress, CreditCardNumber, CreditCardType, ExpiryDate and CVV number")
	public void user_enters_FirstName_LastName_BillingAddress_CreditCardNumber_CreditCardType_ExpiryDate_and_CVV_number() {

		WebElement txtCvvNum = driver.findElement(By.id("cc_cvv"));
		b.scrollDownUsingJs(txtCvvNum);
		WebElement txtFirstname = driver.findElement(By.id("first_name"));
		b.sendkeys(txtFirstname, "abc");
		WebElement txtLastname = driver.findElement(By.id("last_name"));
		b.sendkeys(txtLastname, "def");
		WebElement txtAddress = driver.findElement(By.id("address"));
		b.sendkeys(txtAddress, "xyz,123");
		WebElement txtCreditCardNum = driver.findElement(By.id("cc_num"));
		b.sendkeys(txtCreditCardNum, "1234567812345678");
		WebElement dropDownCreditCardType = driver.findElement(By.id("cc_type"));
		b.selectByVisibleTextDropDown(dropDownCreditCardType, "Master Card");
		WebElement dropDownExpiryMonth = driver.findElement(By.id("cc_exp_month"));
		b.selectByVisibleTextDropDown(dropDownExpiryMonth, "December");
		WebElement dropDownExpiryYear = driver.findElement(By.id("cc_exp_year"));
		b.selectByVisibleTextDropDown(dropDownExpiryYear, "2022");
		b.sendkeys(txtCvvNum, "123");
	}

	@And("User clicks Book now button")
	public void user_clicks_Book_now_button() {
		WebElement btnBookNow = driver.findElement(By.id("book_now"));
		b.btnClick(btnBookNow);
	}

	@Then("User verify Booking confirmation page is displayed")
	public void user_verify_Booking_confirmation_page_is_displayed() throws InterruptedException {
//		By txtOrderNo = By.id("order_no");
//		b.explicitWait(txtOrderNo);
		Thread.sleep(10000);
		WebElement hdgConfirm = driver.findElement(By.xpath("//td[@class='login_title']"));
		String headingConfirm = hdgConfirm.getText();
		System.out.println(headingConfirm);
		Assert.assertTrue(headingConfirm.contains("Booking Confirmation"));
	}

	@Then("User verify Order number is displayed")
	public void user_verify_Order_number_is_displayed() {
		By txtOrderNo = By.id("order_no");
		b.explicitWait(txtOrderNo);
		b.scrollDownUsingJs(driver.findElement(txtOrderNo));
		String textValue = b.getAttributeValue(driver.findElement(txtOrderNo), "value");
		System.out.println(textValue);
		b.quitBrowser();
	}

	@Then("User verify Book Hotel page")
	public void user_verify_Book_Hotel_page() {
		WebElement hdgBook = driver.findElement(By.xpath("(//td[@class='login_title'])[2]"));
		String headingBook = hdgBook.getText();
		System.out.println(headingBook);
		Assert.assertTrue(headingBook.contains("Book A Hotel"));
	}

	@When("User enters valid {string} and valid {string}")
	public void user_enters_valid_and_valid(String userName, String password) {
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("User selects valid {string}, {string}, {string}, {string}, enters valid {string}, {string}, selects valid {string} and {string}")
	public void user_selects_valid_enters_valid_selects_valid_and(String location, String hotel, String roomType,
			String roomNos, String checkInDate, String checkOutDate, String adultCount, String childCount) {
		
		b.selectByVisibleTextDropDown(driver.findElement(By.id("location")), location);
		b.selectByVisibleTextDropDown(driver.findElement(By.id("hotels")), hotel);
		b.selectByVisibleTextDropDown(driver.findElement(By.id("room_type")), roomType);
		b.selectByVisibleTextDropDown(driver.findElement(By.id("room_nos")), roomNos);
		b.sendkeys(driver.findElement(By.id("datepick_in")), checkInDate);
		b.sendkeys(driver.findElement(By.id("datepick_out")), checkOutDate);
		b.selectByVisibleTextDropDown(driver.findElement(By.id("adult_room")), adultCount);
		b.selectByVisibleTextDropDown(driver.findElement(By.id("child_room")), childCount);
	}

	@When("User enters {string}, {string}, {string}, {string} selects valid {string}, {string}, {string} and enters valid {string}")
	public void user_enters_selects_valid_and_enters_vali(String firstName, String lastName, String address,
			String creditCardNo, String creditcardType, String expiryMonth, String expiryDate, String cvvNumber) {
		
		WebElement txtCvvNum = driver.findElement(By.id("cc_cvv"));
		b.scrollDownUsingJs(txtCvvNum);
		b.sendkeys(driver.findElement(By.id("first_name")), firstName);
		b.sendkeys(driver.findElement(By.id("last_name")), lastName);
		b.sendkeys(driver.findElement(By.id("address")), address);
		b.sendkeys(driver.findElement(By.id("cc_num")), creditCardNo);
		b.selectByVisibleTextDropDown(driver.findElement(By.id("cc_type")), creditcardType);
		b.selectByVisibleTextDropDown(driver.findElement(By.id("cc_exp_month")), expiryMonth);
		b.selectByVisibleTextDropDown(driver.findElement(By.id("cc_exp_year")), expiryDate);
		b.sendkeys(txtCvvNum, cvvNumber);
	}

}
