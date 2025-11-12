package utils;

import java.nio.file.Paths;

public class Constants {
    private static final  String PROJECT_ROOT_PATH = System.getProperty("user.dir");
    public static final String CATALOG_PATH = Paths.get(PROJECT_ROOT_PATH,"src", "main", "resources","catalog.xml").toString();
    public static final String CUSTOMER_PATH = Paths.get(PROJECT_ROOT_PATH,"src", "main", "resources","customer.xml").toString();
}
