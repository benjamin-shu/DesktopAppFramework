package daf.props;

import java.util.HashMap;

import java.io.IOException;

/**
 * Singleton class designed to handle reading String properties from saved files.
 * 
 * @author Benjamin Shu
 */
public abstract class AppPropertiesManager {
    // Static instance, to prevent creation of more than one AppPropertiesManager.
    // Declared as protected to allow access by subclasses.
    protected static AppPropertiesManager singleton;
    
    // HashMap object to store and provide access to loaded String properties.
    protected HashMap<String, String> properties;
    
    // Public accessor method for the single instance of AppPropertiesManager.
    public abstract AppPropertiesManager getSingleton();
    
    // Helper method for loading String properties into the AppPropertiesManager.
    public final void addProperty(Object key, String value) {
        this.properties.put(key.toString(), value);
    }
    
    // Public accessor method for an individual property based on its String key.
    public final String getProperty(Object key) {
        return this.properties.get(key.toString());
    }
    
    // Public initialization method that prepares all of the String properties for use.
    public abstract void loadProperties(String filePath) throws IOException;
}