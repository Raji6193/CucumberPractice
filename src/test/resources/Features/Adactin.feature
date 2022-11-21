Feature: Validation of hotel booking in Adactin Web Application

Scenario: TC01_Validation of hotel booking with valid details
Given User launches Adactin Web Application
When User enters valid username and valid password
And User clicks Login button
Then User verify Home page is displayed
When User enters valid location, Hotel, Room Type, Number of Rooms, check in date, check out date, Adults count and children count
And User clicks search
Then User verify Select hotel page is displayed
And User clicks Select button
And User clicks Continue button
Then User verify Book Hotel page
When User enters FirstName, LastName, BillingAddress, CreditCardNumber, CreditCardType, ExpiryDate and CVV number
And User clicks Book now button
Then User verify Booking confirmation page is displayed 
Then User verify Order number is displayed

Scenario Outline: TC02_Validation of hotel booking with valid details
Given User launches Adactin Web Application
When User enters valid "<username>" and valid "<password>"
And User clicks Login button
Then User verify Home page is displayed
When User selects valid "<location>", "<hotel>", "<roomType>", "<numberOfRooms>", enters valid "<checkInDate>", "<checkOutDate>", selects valid "<adultsCount>" and "<childrenCount>"
And User clicks search
Then User verify Select hotel page is displayed
And User clicks Select button
And User clicks Continue button
Then User verify Book Hotel page
When User enters "<firstName>", "<lastName>", "<billingAddress>", "<creditCardNumber>" selects valid "<creditCardType>", "<expiryMonth>", "<expiryDate>" and enters valid "<cvvNumber>"
And User clicks Book now button
Then User verify Booking confirmation page is displayed 
Then User verify Order number is displayed

Examples:
|username|password|location|hotel|roomType|numberOfRooms|checkInDate|checkOutDate|adultsCount|childrenCount|firstName|lastName|billingAddress|creditCardNumber|creditCardType|expiryMonth|expiryDate|cvvNumber|
|Raji6193|Raji6193|Sydney|Hotel Creek|Standard|1 - One|17/11/2022|18/11/2022|1 - One|1 - One|abc|mno|abc,mno|1234567812345678|VISA|February|2022|123|
|Raji6193|Raji6193|Melbourne|Hotel Sunshine|Double|2 - Two|17/11/2022|18/11/2022|2 - Two|2 - Two|xyz|jkl|xyz,jkl|1234567812345678|Master Card|March|2022|789|
|Raji6193|Raji6193|Brisbane|Hotel Hervey|Deluxe|3 - Three|17/11/2022|18/11/2022|3 - Three|3 - Three|def|ghi|def,ghi|1234567812345678|VISA|August|2022|456|
|Raji6193|Raji6193|Adelaide|Hotel Cornice|Super Deluxe|4 - Four|17/11/2022|18/11/2022|4 - Four|4 - Four|stu|vwx|stu,vwx|1234567812345678|American Express|September|2022|123|
