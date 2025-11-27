package core;

import io.github.cdimascio.dotenv.Dotenv;

public class TestSettings {

    private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load();

    //  GENERAL SETTINGS
    public static final String ENV = DOTENV.get("TEST_ENV", "QA");
    public static final String BASE_URL = "https://demoqa.com/";
    public static final int DEFAULT_TIMEOUT = 30; // in seconds
    public static final String BROWSER_TYPE = "chrome"; // default browser type
    public static final String SCREEN_RESOLUTION = "1920,1080";
    public static final boolean HEADLESS = true;

//    CLOUD SETTINGS
    public static final String CLOUD_URL = "https://cloud.example.com";
    public static final String CLOUD_USERNAME = "your_username";
    public static final String CLOUD_ACCESS_KEY = "your_access_key";
}
