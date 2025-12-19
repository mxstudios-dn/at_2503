# Selenium + TestNG + Allure starter

Cross-browser UI test skeleton targeting https://demo.automationtesting.in/ with Chrome/Firefox/Edge and fixed 1920x1080 window sizing.

## Requirements
- Java 25 (matches pom)
- Maven 3.9+
- Browsers installed locally (Chrome, Firefox, Edge)
- Allure CLI installed and on PATH for viewing reports

## Quick start
- Run default (Chrome, headed):
  - `mvn test`
- Override browser/headless/size/timeouts:
  - `mvn test -Dbrowser=edge -Dheadless=true -DwindowSize=1920x1080 -DtimeoutSeconds=10 -DretryCount=1`
- Open Allure report:
  - `allure serve target/allure-results`

## Config flags (defaults in pom)
- `browser` (chrome|firefox|edge) – default chrome
- `baseUrl` – default https://demo.automationtesting.in/
- `headless` (true|false) – default false
- `timeoutSeconds` – default 10
- `retryCount` – default 1
- `windowSize` – default 1920x1080

## Structure
- Core config/driver: src/main/java/vn/vti/academy/automation/
- Tests, pages, listeners: src/test/java/vn/vti/academy/automation/
- Suite: testng.xml

## Notes
- WebDriverManager downloads drivers automatically.
- Allure attachments include screenshot and page source on failure/skip.
