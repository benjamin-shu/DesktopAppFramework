package daf.props;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.util.HashMap;

/**
 * Subclass of AppPropertiesManager designed for reading
 * String properties from a JSON file.
 * 
 * Note that in this implementation, the properties are 
 * stored in a JsonArray.
 * 
 * @author Benjamin Shu
 */
public class JSONPropManager extends AppPropertiesManager {
    // Static String constants used to read from the JSON file.
    // For this implementation to work, there must be a JsonArray named "properties",
    // composed of JsonObjects with a "name" String and a "value" String.
    private static final String JSON_PROPERTIES = "properties",
            JSON_NAME = "name", JSON_VALUE = "value";
    
    // The location of the last file path that this JSONPropManager loaded properties from.
    private String filePath;
    
    /**
     * Constructor which creates a JSONPropManager with a blank file path and empty HashMap.
     * Declared as private to prevent instantiation of more than one JSONPropManager.
     */
    private JSONPropManager() {
        this.filePath = "";
        this.properties = new HashMap<>();
    }
    /**
     * Public accessor method for the single instance of JSONPropManager.
     * 
     * @return A reference to this JSONPropManager.
     */
    @Override
    public AppPropertiesManager getSingleton() {
        if (singleton == null || !(singleton instanceof JSONPropManager)) {
            singleton = new JSONPropManager();
        }
        return singleton;
    }
    /**
     * Public initialization method that loads String properties 
     * from a user-specified JSON file into a HashMap for use.
     * 
     * @param filePath The location of the JSON properties file.
     * 
     * @throws IOException If any error occurs while reading from the JSON file.
     */
    @Override
    public void loadProperties(String filePath) throws IOException {
        this.filePath = filePath;
        InputStream i = new FileInputStream(this.filePath);
        try (JsonReader reader = Json.createReader(i)) {
            JsonObject json = reader.readObject();
            JsonArray propsJson = json.getJsonArray(JSON_PROPERTIES);
            String name, value;
            for (int j = 0; j < propsJson.size(); j++) {
                json = propsJson.getJsonObject(j);
                name = json.getString(JSON_NAME);
                value = json.getString(JSON_VALUE);
                this.addProperty(name, value);
            }
        }
    }    
}
