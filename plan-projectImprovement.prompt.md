Plan: projectImprovement Framework Upgrade

TL;DR: Restructure and harden the Selenium + JUnit 5 framework in phased releases: fix core architecture and lifecycle, unify config and data parsing, enhance test authoring patterns and page objects, integrate Allure + richer logging/observability, then add CI quality gates and advanced scalability (parallelism, cross-browser, grid). Each phase lists goals, actions, rationale, sizing, dependencies, and quick wins to reduce risk while accelerating value.

PHASES OVERVIEW
1. Foundations
2. Data & Config
3. Test Architecture
4. Reporting & Observability
5. Quality Gates & CI
6. Advanced Enhancements

---
PHASE 1: FOUNDATIONS
Goals:
- Correct build issues and missing sources.
- Normalize project structure and naming.
- Ensure deterministic, isolated test lifecycle.

Action Items (Effort: S=Small M=Medium L=Large):
1. Add JUnit Jupiter Engine dependency to pom.xml (S)
2. Resolve duplication: decide canonical driver class (DriverManager vs compiled SeleniumDriverBase); recreate source if missing (M)
3. Move BasePage from core/ to pages/ for semantic clarity (S)
4. Implement unified WebDriver factory with ENV-driven browser selection; default Chrome headless (M)
5. Refactor BaseTest to @BeforeEach/@AfterEach for per-test isolation (S)
6. Add missing imports and compile hygiene to BaseTest (S)
7. Introduce wait abstraction (FluentWait wrapper + ExpectedConditions) (M)
8. Scaffold pages/ with initial feature Page Object representing current test target (M)
9. Add internal README documenting lifecycle & usage (S)

Rationale: Eliminates brittle global driver state, clarifies architecture, sets stage for Allure and parallelism.
Dependencies: Page objects depend on finalized driver API; waits depend on driver class.
Quick Wins: JUnit engine dep, BaseTest imports, driver class clarity.

---
PHASE 2: DATA & CONFIG
Goals:
- Single source of truth for environment & file paths.
- Reliable parsers for XML/CSV/JSON -> modal POJOs.
- Remove duplication, inefficiency, silent failures.

Action Items:
1. Remove/refactor TestSettings (delegate to .env + Constants) (S)
2. Implement XMLHelper (XPath) aligned with existing compiled expectations (M)
3. Complete JsonHelper (object/array parsing + helpers) (S)
4. Optimize CSVHelper (single-pass read, encoding robustness) (S)
5. Add getters/setters (or immutability approach) to AddressModal & BookModal (S)
6. Fail-fast validation for required keys (timeouts, baseUrl) from config.xml (M)
7. Data loader facade mapping raw helpers to typed modals (M)
8. Build path existence sanity test (S)
9. Document data access patterns (README appendix) (S)

Rationale: Prevent data load ambiguity; enables parameterized tests; supports CI stability.
Dependencies: Modal accessors precede facade; helpers precede parameterization.
Quick Wins: CSVHelper fix, modal accessors, remove TestSettings.

---
PHASE 3: TEST ARCHITECTURE
Goals:
- Scalable, readable test suites.
- POM patterns.
- Separation of test intent vs mechanics.

Action Items:
1. Introduce @ParameterizedTest using CSV & XML providers (M)
2. Custom argument sources (@CsvAddressSource, @XmlBookSource) (M)
3. Build Page Objects for major workflows (L)
4. Assertion strategy (soft assertion helper) (M)
5. Centralize timeouts/waits configuration (S)
6. Tagging strategy (@Tag("smoke"), @Tag("regression")) (S)
7. Test data factory for randomized robustness (M)
8. Thread-safe driver handling (ThreadLocal) anticipating parallel runs (L)
9. Base assertion/logging hooks (S)

Rationale: Reuse, clarity, readiness for parallel & reporting.
Dependencies: Parameterization depends on Phase 2; thread safety on driver lifecycle.
Quick Wins: Tagging, central timeouts.

---
PHASE 4: REPORTING & OBSERVABILITY
Goals:
- Rich reports (steps, artifacts) for triage.
- Enhanced logging structure.
- Early flakiness visibility.

Action Items:
1. Add Allure dependencies (allure-junit5, allure-selenium, aspectjweaver) (S)
2. Annotate Page Object actions with @Step (M)
3. Capture screenshots & page source on failure (JUnit extension or @AfterEach) (M)
4. Attach console/performance logs where supported (M)
5. Add environment/build metadata as Allure labels (S)
6. Standardize Log4j2 pattern (timestamp, thread, test name) (S)
7. Test run summary artifact JSON (M)
8. LOG_LEVEL from .env for dynamic verbosity (S)
9. Basic flakiness detector (first vs retry outcome tagging) (L)

Rationale: Accelerates failure diagnosis; improves communication to stakeholders.
Dependencies: Page objects before steps; driver stability before artifacts.
Quick Wins: Add dependencies, metadata labels.

---
PHASE 5: QUALITY GATES & CI
Goals:
- Automated enforcement of standards.
- Fast feedback loops.

Action Items:
1. Jacoco coverage integration (S)
2. SpotBugs + Checkstyle + formatter (M)
3. Maven profiles for smoke vs full suites (S)
4. GitHub Actions CI: build, test, upload Allure results, coverage badge (M)
5. Minimum coverage threshold (S)
6. Dependency vulnerability scan (OWASP) (M)
7. Cache Maven dependencies (S)
8. Enable parallel test execution (Surefire/JUnit config) (M)
9. Nightly full regression workflow (L)

Rationale: Sustains health & prevents regressions.
Dependencies: Parallelization requires thread-safe drivers (Phase 3).
Quick Wins: Jacoco, suite profiles.

---
PHASE 6: ADVANCED ENHANCEMENTS
Goals:
- Scalability & robustness across environments.
- Performance & visual validation.

Action Items:
1. Cross-browser CI matrix (Chrome/Firefox/Edge) (M)
2. Selenium Grid / Docker Compose (L)
3. Retry-on-known-flake mechanism (M)
4. Visual regression pilot (baseline diffs) (L)
5. Performance timing capture (navigation/action metrics) (M)
6. Security scanning expansion (dependency + basic DAST stub) (M)
7. Config-driven test selection manifest (M)
8. Artifact retention rules (older screenshots pruning) (S)
9. Expand modals for complex datasets (customers.xml mapping) (M)

Rationale: Enterprise-grade resilience & insight.
Dependencies: Grid needs robust driver factory (Phase 1); visual regression needs stable screenshot capture (Phase 4).
Quick Wins: Artifact retention rules, cross-browser config once factory ready.

---
RISK ASSESSMENT
High: Parallelization, Grid, Visual regression
Medium: Allure integration, data facade
Low: JUnit engine dep, CSVHelper fix
Mitigations: Incremental PRs, smoke baseline, feature flags, validation & fail-fast.

SUCCESS METRICS
- Build success ≥95% (30-day rolling)
- Stable test pass rate ≥90% after flake filtering
- Test duration reduced ≥20% post waits optimization
- Coverage ≥70% (Phase 5), target 80% (Phase 6)
- Failure triage median <5 mins
- Cross-browser parity ≥85% pass
- Page object reuse ≥60% of tests by Phase 3
- Flaky test retry count trending downward

PRIORITIZED BACKLOG (Ordered)
1. JUnit engine dep; fix BaseTest imports
2. Resolve driver class; per-test lifecycle
3. CSVHelper optimization; remove TestSettings
4. XMLHelper + JsonHelper; modal accessors
5. Waits abstraction + timeouts
6. Page object scaffolding
7. Parameterized tests
8. Allure deps + screenshot on failure
9. @Step annotations; logging format
10. Jacoco + tagged profiles
11. Static analysis tools
12. Thread-safe driver; parallel tests
13. CI pipeline with artifacts
14. Cross-browser matrix
15. Flakiness detector & retry
16. Selenium Grid/Docker
17. Performance & visual regression
18. Security scanning expansion

DEPENDENCIES MATRIX (Highlights)
- Allure steps depend on Page Objects
- Parallelization depends on thread-safe driver + reporting stability
- CI artifacts depend on Allure integration
- Visual regression depends on screenshot stability
- Cross-browser depends on driver factory flexibility

EFFORT SUMMARY
Phase early focus: S/M for momentum; later phases include L items (page objects breadth, Grid, visual regression).

GOVERNANCE & INCREMENT STRATEGY
- Small PRs (<400 LOC)
- Maintain green smoke suite before structural merges
- Feature flags for parallel, visual regression
- CHANGELOG updates per phase

PLAN NAME
projectImprovement (file: plan-projectImprovement.prompt.md)

FOLLOW-UP QUESTIONS (OPTIONAL)
1. Preference for Lombok vs manual POJOs?
2. Target coverage threshold (lock at 70% or push to 80%)?
3. Priority: cross-browser vs parallel if resource constrained?

Quick Wins (execute first): JUnit engine dep, BaseTest fix, CSVHelper single-pass, remove TestSettings duplication, modal accessors, add Allure deps baseline.

