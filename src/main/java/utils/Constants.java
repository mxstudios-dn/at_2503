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
}
