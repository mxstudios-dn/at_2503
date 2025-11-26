package utils;

import java.nio.file.Paths;

public class Constant {
    public static final String PROJECT_ROOT_DIR = System.getProperty("user.dir");
    public static final String PROJECT_ROOT_PATH = Paths.get(PROJECT_ROOT_DIR).toString();
    public static final String RESOURCES_PATH = Paths.get(PROJECT_ROOT_PATH, "src", "main", "resources").toString();
    public static final String PERSON_FILE_PATH = Paths.get(RESOURCES_PATH, "Person.xml").toString();
    public static final String BOOK_FILE_PATH = Paths.get(RESOURCES_PATH, "book.xml").toString();
    public static final String CUSTOMER_FILE_PATH = Paths.get(RESOURCES_PATH, "customers.xml").toString();
    public static final String CUSTOMERBT_FILE_PATH = Paths.get(RESOURCES_PATH, "Customer.xml").toString();
}
