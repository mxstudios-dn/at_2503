package core;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;
import utils.Helper;
import static utils.Constants.*;
import java.util.Objects;

public class TestSettings {

    private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load();

    // Get test environment from system property or default to "GURU": mvn clean test -Denv=GURU
    public static final String TEST_ENV = System.getProperty("env", DOTENV.get("TEST_ENV","GURU"));
    public static final JSONObject ENV_CONFIG = Objects.requireNonNull(Helper.loadJsonFile(JSON_DATA_PATH)).getJSONObject(TEST_ENV);
    public static final String BASE_URL = ENV_CONFIG.getString("base_url");
    public static final int DEFAULT_TIMEOUT = 30; // in seconds
    public static final String BROWSER_TYPE = System.getProperty("browser", DOTENV.get("BROWSER","chrome")); // default browser type
    public static final String SCREEN_RESOLUTION = "1920,1080";
    public static final boolean HEADLESS = false;

    // WAIT SETTINGS
    public static final int WAIT_ELEMENT = 10; // in seconds

}
