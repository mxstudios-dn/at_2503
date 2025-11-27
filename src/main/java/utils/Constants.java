package utils;

import java.nio.file.Paths;

public final class Constants {
    // Project Path Constants
    public static final String PROJECT_ROOT_DIR = System.getProperty("user.dir");
    public static final String PROJECT_ROOT_PATH = Paths.get(PROJECT_ROOT_DIR).toString();
    public static final String RESOURCES_PATH = Paths.get(PROJECT_ROOT_PATH, "src", "main", "resources").toString();

    // XML Helper Constants
    public static final String CONFIG_FILE_PATH = Paths.get(RESOURCES_PATH, "config.xml").toString();
    public static final String BOOK_FILE_PATH = Paths.get(RESOURCES_PATH, "book.xml").toString();

    // CSV Helper Constants
    public static final String ADDRESSES_FILE_PATH = Paths.get(RESOURCES_PATH, "addresses.csv").toString();
    public static final String CSV_DELIMITER = ",";
    
    // Log Path Constants
    public static final String LOG_DIR = Paths.get(PROJECT_ROOT_PATH, "target", "logs").toString();
    public static final String AUTOMATION_LOG = Paths.get(LOG_DIR, "automation.log").toString();
    public static final String ERROR_LOG = Paths.get(LOG_DIR, "errors.log").toString();
    public static final String TEST_LOG = Paths.get(LOG_DIR, "test-execution.log").toString();
}
