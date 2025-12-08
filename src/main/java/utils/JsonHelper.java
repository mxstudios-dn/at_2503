package utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonHelper extends Helper {
    private JSONObject jsonObject;
    private JSONArray jsonArray;

    /**
     * Constructor to load JSON from file
     * @param filePath path to JSON file
     */
    public JsonHelper(String filePath) {
        super();
        loadJsonFile(filePath);
    }

    /**
     * Get the loaded JSON Object
     * @return JSONObject (null if file contains array)
     */
    public JSONObject getJsonObject() {
        return jsonObject;
    }

    /**
     * Get the loaded JSON Array
     * @return JSONArray (null if file contains object)
     */
    public JSONArray getJsonArray() {
        return jsonArray;
    }

    /**
     * Get value from JSON Object by key
     * @param key the key to retrieve
     * @return the value associated with the key
     */
    public Object getValue(String key) {
        if (jsonObject != null) {
            return jsonObject.opt(key);
        }
        logger.warn("JSON content is an array, not an object");
        return null;
    }

    /**
     * Get String value from JSON Object by key
     * @param key the key to retrieve
     * @return the string value
     */
    public String getStringValue(String key) {
        if (jsonObject != null) {
            return jsonObject.optString(key);
        }
        logger.warn("JSON content is an array, not an object");
        return null;
    }

    /**
     * Get Integer value from JSON Object by key
     * @param key the key to retrieve
     * @return the integer value
     */
    public int getIntValue(String key) {
        if (jsonObject != null) {
            return jsonObject.optInt(key);
        }
        logger.warn("JSON content is an array, not an object");
        return 0;
    }

    /**
     * Get Boolean value from JSON Object by key
     * @param key the key to retrieve
     * @return the boolean value
     */
    public boolean getBooleanValue(String key) {
        if (jsonObject != null) {
            return jsonObject.optBoolean(key);
        }
        logger.warn("JSON content is an array, not an object");
        return false;
    }


}

