package daf.props;

import java.util.HashMap;

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
    private HashMap<String, String> properties;
    
    // Public accessor method for the single instance of AppPropertiesManager.
    public abstract AppPropertiesManager getSingleton();
    
    // Helper method for loading String properties into the AppPropertiesManager.
    public abstract void addProperty(Object key, String value);
    
    // Public accessor method for an individual property based on its String key.
    public abstract String getProperty(Object key);
    
    // Public initialization method that prepares all of the String properties for use.
    public abstract void loadProperties(String filePath);
}
class TextPropManager extends AppPropertiesManager {
    private TextPropManager() { }
    @Override
    public AppPropertiesManager getSingleton() {
        if (singleton == null || !(singleton instanceof TextPropManager)) {
            singleton = new TextPropManager();
        }
        return singleton;
    }
    @Override
    public void addProperty(Object key, String value) {
        
    }
    @Override
    public String getProperty(Object key) {
        return null;
    }
    @Override
    public void loadProperties(String filePath) {
        
    }
}
class JSONPropManager extends AppPropertiesManager {
    private JSONPropManager() { }
    @Override
    public AppPropertiesManager getSingleton() {
        if (singleton == null || !(singleton instanceof JSONPropManager)) {
            singleton = new JSONPropManager();
        }
        return singleton;
    }
    @Override
    public void addProperty(Object key, String value) {
        
    }
    @Override
    public String getProperty(Object key) {
        return null;
    }
    @Override
    public void loadProperties(String filePath) {
        
    }    
}
class XMLPropManager extends AppPropertiesManager {
    private XMLPropManager() { }
    @Override
    public AppPropertiesManager getSingleton() {
        if (singleton == null || !(singleton instanceof XMLPropManager)) {
            singleton = new XMLPropManager();
        }
        return singleton;
    }
    @Override
    public void addProperty(Object key, String value) {
        
    }
    @Override
    public String getProperty(Object key) {
        return null;
    }
    @Override
    public void loadProperties(String filePath) {
        
    }
}