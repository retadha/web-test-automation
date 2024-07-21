# 🧪 Automation Test Framework

Welcome to the Automation Test Framework repository! This project combines Web UI and API tests in one comprehensive framework.

## 📋 Project Structure

```
test
├── java
    ├── api
        ├── features
        ├── objects
        ├── schemes
        ├── stepdef
    ├── ui
        ├── features
        ├── pages
        ├── stepdef
    ├── APITest
    ├── UITest
```

## 🌐 UI Tests

The UI tests cover the functionality of the [SauceDemo](https://www.saucedemo.com/) website, focusing on key features such as:
- Login
- Inventory
- Cart
- Checkout

## 📡 API Tests

The API tests cover the [GoRest](https://gorest.co.in/) API for:
- Users endpoint: GET, POST, PATCH, DELETE requests
- Posts endpoint: POST request

## ⚙️ Prerequisites

Ensure you have the following installed:
- Java
- Gradle

## 🚀 Running the Tests

Clone the repository:
```bash
git clone https://github.com/retadha/jayjay-final-project.git
cd jayjay-final-project
```

Build the project:
```sh
./gradlew build
```
    
Run the UI test:
```bash
./gradlew webTest
```

Run the API test:
```bash
./gradlew apiTest
```

## 📊 Viewing the Reports

The test reports can be found in:
- `reports/api-test-report.html`
- `reports/ui-test-report.html`

## 🔄 Continuous Integration

This project uses GitHub Actions to automate tests on the main branch whenever there is a push or pull request.

Test results:
- [API Test Results](https://retadha.github.io/jayjay-final-project/api-test-report)
- [UI Test Results](https://retadha.github.io/jayjay-final-project/ui-test-report)

## 🛠️ Technologies Used

- Git and GitHub
- Java
- Gradle
- Rest Assured
- Junit
- Selenium
- Gherkin
- Cucumber
- GitHub Actions



