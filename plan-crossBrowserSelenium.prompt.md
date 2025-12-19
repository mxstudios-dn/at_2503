## Plan: Cross-Browser Selenium + TestNG + Allure

Set up a Maven Selenium/TestNG framework using WebDriverManager for Chrome/Firefox/Edge, Allure reporting, fixed 1920x1080 window, default retryCount=1, and a demo test against https://demo.automationtesting.in/.

### Steps
1. Extend pom.xml with Selenium Java, TestNG, WebDriverManager, AssertJ, Allure TestNG adapter, and Surefire system properties for browser/baseUrl/headless/timeout/retryCount/windowSize.
2. Add a config helper in src/main/java to read -D properties with defaults: browser=chrome, baseUrl=https://demo.automationtesting.in/, headless=false, timeout=10s, retryCount=1, windowSize=1920x1080.
3. Implement a driver factory/manager in src/main/java for chrome/firefox/edge applying the fixed window size and optional headless, with thread-local lifecycle handling.
4. Create BaseTest plus TestNG listener/retry analyzer in src/test/java for driver setup/teardown, retries, and Allure attachments (screenshot/page source) on failure.
5. Add a page object and smoke TestNG test in src/test/java asserting a visible element/text on https://demo.automationtesting.in/.
6. Provide testng.xml and README instructions (mvn test -Dbrowser=edge -Dheadless=true -DretryCount=1 -DwindowSize=1920x1080, allure serve target/allure-results).

### Further Considerations
1. Fixed window size 1920x1080 confirmed; no change needed.
