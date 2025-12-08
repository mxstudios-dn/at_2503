# Copilot Instructions - JUnit 5 + Selenium Test Automation Framework

## Architecture Overview

This is a **Selenium-based test automation framework** being evolved to integrate JUnit 5 and Allure reporting. The project follows a layered architecture:

- **`core/`** - WebDriver management (`SeleniumDriverBase`) with browser factory pattern
- **`pages/`** - Page Object Model base classes extending `BasePage`
- **`modals/`** - Data models (POJOs) like `BookModal`, `AddressModal`
- **`utils/`** - Helper utilities for XML/CSV/JSON parsing and environment configuration
- **`BaseTest`** - Test foundation class (currently minimal, pending JUnit 5 lifecycle hooks)

**Key Pattern**: All core classes extend `Helper` to inherit `.env` configuration loading via Dotenv.

## Critical Development Workflows

### Build & Test Execution
```bash
# Compile project (Java 25)
mvn clean compile

# Run tests with Surefire
mvn test

# Future: Generate Allure reports (pending implementation)
mvn allure:serve
```

### Environment Configuration
- **`.env` file required** in project root - contains `ENV` variable (e.g., `ENV=QA`)
- `XMLHelper.getUrl()` dynamically retrieves URLs from `config.xml` based on `.env` environment
- Constants defined in `utils/Constants.java` for all file paths

### Browser Configuration
- Default browser: **Chrome (headless mode)**
- Supported: Chrome, Firefox, Edge
- Browser options in `SeleniumDriverBase.initializeDriver()`:
  - `--headless=new`, `--window-size=1980,1080`, `start-maximized`

## Project-Specific Conventions

### Class Naming & Structure
- **Modals not Models** - Data classes are in `modals/` package (e.g., `BookModal`)
- **Helper base class** - Every main class extends `Helper` for `.env` access
- **Driver injection** - Page objects receive `SeleniumDriverBase` via constructor

### Data Handling Patterns
```java
// XML parsing with XPath
XMLHelper xml = new XMLHelper(Constants.CONFIG_FILE_PATH);
String url = xml.getUrl(); // Reads from .env ENV + config.xml

// CSV reading with OpenCSV
CSVHelper csv = new CSVHelper(Constants.ADDRESSES_FILE_PATH);
List<String[]> data = csv.getCsvData();

// All file paths use Constants.java (e.g., RESOURCES_PATH, BOOK_FILE_PATH)
```

### Test Data Resources
Located in `src/main/resources/` (copied to `target/classes/`):
- `config.xml` - Environment-specific URLs and timeouts
- `book.xml`, `customers.xml` - XML test data
- `addresses.csv` - CSV test data
- `address_json.json` - JSON test data

## Planned Integration (In Progress)

**Per `plan-junitSeleniumAllureFramework.prompt.md`:**
1. Add Allure dependencies (`allure-junit5`, `allure-selenium`, `aspectjweaver`)
2. Implement JUnit 5 lifecycle hooks in `BaseTest` (`@BeforeEach`/`@AfterEach`)
3. Add `@Step` annotations to page object methods for Allure step logging
4. Configure Allure screenshot capture on test failures
5. Use `@ParameterizedTest` for data-driven tests with CSV/XML helpers

### Maven Dependencies Already Present
- Selenium 4.38.0
- JUnit Jupiter 6.0.1  
- Surefire 3.5.4
- OpenCSV 5.12.0, JSON 20240303, Dotenv 3.2.0

**Next**: Add Allure dependencies and create JUnit test classes with proper annotations.

## Coding Guidelines

### When Creating Tests
- Extend `BaseTest` class
- Place in `src/test/java/` with feature-based package structure (e.g., `DastBoard/`)
- Use `Constants.java` for all file paths - never hardcode paths
- Initialize `SeleniumDriverBase` in `@BeforeEach`, quit in `@AfterEach`

### When Creating Page Objects
```java
public class LoginPage extends BasePage {
    public LoginPage(SeleniumDriverBase driverBase) {
        super(driverBase);
    }
    // Use driverBase.getDriver() or driverBase.findElement(By.x)
}
```

### When Adding Test Data
- XML/CSV/JSON files go in `src/main/resources/`
- Add path constants to `Constants.java`
- Use appropriate helper (`XMLHelper`, `CSVHelper`, `FileHelper`)
- Parse to modal objects (`BookModal`, `AddressModal`)

## Key Files Reference

- **`core/SeleniumDriverBase.java`** - WebDriver initialization and browser options
- **`utils/Helper.java`** - Base class providing Dotenv access to all components
- **`utils/Constants.java`** - Central path constants (`PROJECT_ROOT_PATH`, `RESOURCES_PATH`)
- **`BaseTest.java`** - Test foundation (needs JUnit hooks added)
- **`pom.xml`** - Dependencies and Surefire plugin configuration
