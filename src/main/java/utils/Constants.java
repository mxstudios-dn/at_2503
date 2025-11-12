package utils;
import java.nio.file.Paths;

    public final class Constants {
        public static final String PROJECT_ROOT_DIR = System.getProperty("user.dir");
        public static final String PROJECT_ROOT_PATH = Paths.get(PROJECT_ROOT_DIR).toString();
        public static final String RESOURCES_PATH = Paths.get(PROJECT_ROOT_PATH, "src", "main", "resources").toString();
        public static final String CONFIG_FILE_PATH = Paths.get(RESOURCES_PATH, "config.xml").toString();
        public static final String BOOK_FILE_PATH = Paths.get(RESOURCES_PATH, "book.xml").toString();
        public static final String CUSTOMER_FILE_PATH = Paths.get(RESOURCES_PATH, "customers.xml").toString();
    }

