# Plan: Build JUnit + Selenium + Allure Automation Framework

Create a complete test automation framework integrating JUnit 5 for test execution, Selenium for browser automation, and Allure for rich test reporting with screenshots, steps logging, and detailed test results visualization.

## Steps

1. Add Allure dependencies to [pom.xml](pom.xml): `allure-junit5`, `allure-selenium`, `aspectjweaver`, and configure `allure-maven` plugin with `maven-surefire-plugin` AspectJ integration
2. Create `src/test/java` with JUnit base test class containing `@BeforeEach`/`@AfterEach` hooks for WebDriver setup/teardown and Allure listeners
3. Extend [SeleniumDriverBase.java](src/main/java/core/SeleniumDriverBase.java) with driver initialization, browser factory methods, and Allure screenshot attachment on failures
4. Build page object base class with common WebElement actions annotated with `@Step` for Allure step reporting
5. Create sample JUnit test classes with `@Test`, `@DisplayName`, `@Tag` annotations demonstrating page object usage and parameterized tests with `@ParameterizedTest`
6. Add `allure.properties`, update [Constants.java](src/main/java/utils/Constants.java) with test configuration, and configure test data providers for data-driven testing

## Further Considerations

1. **JUnit Extensions**: Add custom JUnit 5 extensions for retry logic, test watchers, or conditional test execution?
2. **WebDriver Scope**: Use ThreadLocal for parallel execution with `@Execution(PARALLEL)` or singleton pattern for sequential tests?
3. **Test Organization**: Group tests by `@Nested` classes, use `@TestFactory` for dynamic tests, or organize by feature packages with `@Suite`?

