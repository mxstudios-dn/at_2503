package core;

import java.util.HashMap;
import java.util.Map;

import utils.Helper;

/**
 * ShareValueManager provides thread-safe storage for sharing string values
 * across different test steps using ThreadLocal.
 */
public class ShareValueManager extends Helper {
    
    protected static ThreadLocal<Map<String, String>> sharingVariables = ThreadLocal.withInitial(HashMap::new);
    
    /**
     * Stores a string value with the specified key in the thread-local storage.
     * @param key The key to associate with the value.
     * @param value The string value to store.
     */
    public static void setValue(String key, String value) {
        logger.info("[ShareValueManager] Set {}: {}", key, value);
        sharingVariables.get().put(key, value);
    }

    /**
     * Retrieves the string value associated with the specified key from the thread-local storage.
     * @param key The key whose associated value is to be returned.
     * @return The string value associated with the key, or null if not found.
     */
    public static String getValue(String key) {
        String value = sharingVariables.get().get(key);
        logger.info("[ShareValueManager] Get {}: {}", key, value);
        return value;
    }

    /**
     * Update the string value associated with the specified key in the thread-local storage.
     * @param key The key whose associated value is to be updated.
     * @param value The new string value to associate with the key.
     */
    public static void updateValue(String key, String value) {
        logger.info("[ShareValueManager] Update {}: {}", key, value);
        sharingVariables.get().put(key, value);
    }

    /**
     * Removes the string value associated with the specified key from the thread-local storage.
     * @param key The key whose associated value is to be removed.
     */
    public static void removeValue(String key) {
        logger.info("[ShareValueManager] Remove value for key: {}", key);
        sharingVariables.get().remove(key);
    }

    /**
     * Clears all key-value pairs from the thread-local storage.
     */
    public static void clearValues() {
        logger.info("[ShareValueManager] Clearing all sharing values");
        sharingVariables.get().clear();
    }
}
