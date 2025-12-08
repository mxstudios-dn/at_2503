package utils;

import core.TestSettings;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    protected final static Logger logger = LogManager.getLogger("at_2503");

    public Helper(){
        try {
            logger.debug("Environment configuration loaded from .env file");
        } catch (Exception e) {
            logger.error("Failed to load .env configuration", e);
            throw new RuntimeException("Environment configuration failed", e);
        }
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
