# 🍽️ Foodsdictionary Automation

<p align="center">

### 🧪 QA Automation • Web Testing • End-to-End

**Automated testing framework for a real-world food & recipe website**

<br>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Playwright](https://img.shields.io/badge/Playwright-2EAD33?style=for-the-badge&logo=playwright&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-Reporting-6C63FF?style=for-the-badge)

</p>

---

## 🚀 About

**Foodsdictionary Automation** is a QA Automation project built to test the core functionality of the Foodsdictionary website.

The project automates real user scenarios across:

🍲 Food categories  
🔎 Search  
📖 Recipes  
🥗 Nutritional information  
🛒 Products  
🔗 Links & navigation  
📱 Social media  
🪟 Popups & windows  
🌐 End-to-End user flows  

The framework combines **Selenium WebDriver** and **Playwright** with reusable Page Objects and structured automated tests.

---

# 🧪 What Is Being Tested?

### 🏠 Website Navigation
- Home page
- Main sections
- Category navigation
- Internal links
- External links

### 🍲 Food Categories
- Category selection
- Category results
- Food items
- Navigation between categories

### 🔎 Search Engine
- Search for food
- Search for recipes
- Search results validation
- Opening search results
- Navigation from results to content

### 📖 Recipes
- Recipe pages
- Recipe information
- Recipe navigation
- Related content
- Nutritional information

### 🥗 Nutritional Data
Validation of nutritional information such as:

- Calories
- Nutritional values
- Food information
- Recipe information

### 🛒 Products
- Product pages
- Product information
- Different product types
- Navigation between product pages

### 🔗 Links & Social Media
- External links
- Instagram
- Twitter / X
- New browser tabs
- External page navigation

### 🪟 Popups & Windows
- Popup handling
- Modal elements
- New tabs
- Browser windows
- Closing popups
- Returning to the original page

---

# 🔥 Automation Stack

| Technology | Purpose |
|---|---|
| ☕ **Java** | Programming language |
| 🟢 **Selenium WebDriver** | Web UI automation |
| 🎭 **Playwright** | Modern browser automation |
| 🧪 **TestNG** | Test execution & assertions |
| 📦 **Maven** | Build & dependency management |
| 📊 **Allure** | Test reporting |
| 🧩 **Page Object Model** | Reusable automation architecture |
| 🌳 **Git / GitHub** | Version control |

---

# 🧱 Framework Architecture

The project uses the **Page Object Model (POM)** approach.

```text
                    🌐 Foodsdictionary
                           │
                           ▼
                    🧪 TestNG Tests
                           │
              ┌────────────┴────────────┐
              ▼                         ▼
        🟢 Selenium                🎭 Playwright
              │                         │
              └────────────┬────────────┘
                           ▼
                    📄 Page Objects
                           │
                           ▼
                    🖥️ Web Application
                           │
                           ▼
                    📊 Allure Report
```

---

# 🟢 Selenium Automation

Selenium is used for browser-based functional and End-to-End automation.

The Selenium implementation includes reusable Page Objects for different areas of the website.

### Example Page Objects

```text
HomePage
CategoryPage
SearchPage
RecipeProductPage
ArticleProductPage
BookProductPage
BooksListProductPage
```

This keeps locators and page-specific actions separated from the actual test scenarios.

---

# 🎭 Playwright Automation

The project also includes a Playwright implementation for modern browser automation.

Playwright scenarios cover:

- Page navigation
- Element interactions
- Search flows
- New tabs
- External pages
- Popup handling
- End-to-End scenarios

The Playwright implementation provides an additional automation layer alongside Selenium.

---

# 🔄 End-to-End Flow

One of the main goals is to test complete user journeys rather than isolated elements.

```text
🌐 Open Website
       ↓
🍲 Select Category
       ↓
🥘 Select Food / Recipe
       ↓
📖 Open Information Page
       ↓
🥗 Validate Nutritional Information
       ↓
🔗 Navigate to Related Content
       ↓
✅ Validate Expected Result
```

Another example:

```text
🔎 Search
   ↓
📋 Search Results
   ↓
🥘 Select Result
   ↓
📖 Open Recipe / Product
   ↓
🥗 Validate Information
   ↓
✅ Test Passed
```

---

# 📊 Allure Reporting

Every test execution can be analyzed through **Allure Reports**.

The reports provide:

```text
🧪 Test Case
   │
   ├── ▶️ Execution
   ├── ⏱️ Duration
   ├── ✅ Pass / ❌ Fail
   ├── 📸 Screenshots
   └── 🔍 Failure Details
```

Screenshots are used as visual evidence during test execution and failure investigation.

---

# 📁 Project Structure

```text
foodsdictionaryAuto
│
├── 📂 src
│   │
│   ├── 📂 main
│   │   └── 📂 java
│   │       └── 📂 il.guyrob.foodsdictionary
│   │           │
│   │           ├── 🟢 Selenium
│   │           │   └── 📂 Pages
│   │           │
│   │           └── 🎭 Playwright
│   │
│   ├── 📂 test
│   │   └── 📂 java
│   │       ├── 🧪 P1_Sections
│   │       └── 🔄 P2_E2E
│   │
│   └── 📂 ExtFiles
│       └── 📸 screenShots
│
├── 📦 pom.xml
└── 🧪 testng.xml
```

---

# ⚡ Quick Start

Clone the project:

```bash
git clone https://github.com/GuyRob/foodsdictionaryAuto.git
```

Open the project in **IntelliJ IDEA**, allow Maven to load the dependencies and run the TestNG suite.

Or execute:

```bash
mvn test
```

---

# 🏆 Key Features

<div align="center">

| 🧪 Testing | ⚙️ Automation | 📊 Reporting |
|:---:|:---:|:---:|
| Functional | Selenium | Allure |
| UI | Playwright | Screenshots |
| E2E | Page Objects | Test Results |
| Navigation | TestNG | Failure Analysis |

</div>

---

---

# 🃏 Allure Reports

<div align="center">

| V1 - https://f2h.io/9gab5y9doomi |

</div>

---

</p>
