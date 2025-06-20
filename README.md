🧪 Automation Exercise Website Testing Project
This project contains end-to-end UI automation scripts for the Automation Exercise website using Selenium WebDriver with Java, TestNG, Maven, and the Page Object Model (POM) design pattern.


📌 Table of Contents:

🔧 Technologies Used
📁 Project Structure
✅ Automated Test Scenarios


🔧 Technologies Used:

🖥 Language: Java
🧪 Framework: TestNG
🛠 Automation Tool: Selenium WebDriver
📦 Build Tool: Maven
📄 Design Pattern: Page Object Model (POM)
🌐 Test Target: Automation Exercise


📁 Project Structure

├── src
│   ├── main
│   │   └── java
│   │       └── pages              # Page classes (e.g., HomePage, SignupPage)
│   └── test
│       └── java
│           ├── tests             # Test classes
│           └── utilities         # Helpers (e.g., browser actions, waits, screenshots)
├── pom.xml                       # Maven dependencies
└── testng.xml                    # Test suite config


✅ Automated Test Scenarios:
The following test cases from the official Automation Exercise Test Cases are implemented:


🔐 User Authentication

Register a new user
Login with valid/invalid credentials
Logout user
Delete account


🛍 Product Interactions

View all products
View product details
Search for a product
Add product to cart
View cart & verify items
Remove products from cart


🧾 Orders

Place order while registered
Place order while checkout
Download invoice
Review order history


💬 Miscellaneous

Contact us form
Scroll down and up using arrow button
Scroll up without arrow button
Verify subscription in footer
Verify recommended items

