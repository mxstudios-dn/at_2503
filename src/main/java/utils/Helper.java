package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    protected final static Logger logger = LogManager.getLogger();

    /**
     * Logs a test step message.
     * @param message
     */
    protected void logStep(String message) {
        logger.info("[STEP] " + message);
    }

    protected void sleepInSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logger.error("Sleep interrupted", e);
            Thread.currentThread().interrupt();
        }
    }

    protected void logMethodStep(String methodName) {
        logger.warn("---- Executing method: {} ----", methodName);
    }

    /**
     * Retrieves the value of an environment variable, or returns a default value if not set.
     * @param varName Name of the environment variable
     * @param defaultValue Default value to return if variable is not set
     * @return Value of the environment variable or default value
     */
    public static String getEnvVariable(String varName, String defaultValue) {
        String value = System.getenv(varName);
        return (value != null) ? value : defaultValue;
    }

    /**
     * Load JSON file and store as JSONObject or JSONArray
     * @param filePath path to JSON file
     */
    public static JSONObject loadJsonFile(String filePath) {
        try {
            String content = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
            return new JSONObject(content);
        } catch (Exception e) {
            logger.error("Failed to load JSON file: {}", filePath, e);
            return null;
        }
    }


}
