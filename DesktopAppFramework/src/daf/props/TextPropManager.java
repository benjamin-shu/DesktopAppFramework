package daf.props;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.HashMap;

/**
 * Subclass of AppPropertiesManager designed to read 
 * String properties from a text file.
 * 
 * Note that in this implementation, the properties must be 
 * written in the form prop_name = prop_value\n.
 * 
 * @author Benjamin Shu
 */
public class TextPropManager extends AppPropertiesManager {
    // The location of the last text file that this TextPropManager loaded properties from.
    private String filePath;
    /**
     * Constructor which creates a TextPropManager with a blank file path and empty HashMap.
     * Declared as private to prevent instantiation of more than one TextPropManager.
     */
    private TextPropManager() {
        this.filePath = "";
        this.properties = new HashMap<>();
    }
    /**
     * Public accessor method for the single instance of TextPropManager.
     * 
     * @return A reference to this TextPropManager.
     */
    @Override
    public AppPropertiesManager getSingleton() {
        if (singleton == null || !(singleton instanceof TextPropManager)) {
            singleton = new TextPropManager();
        }
        return singleton;
    }
    /**
     * Public initialization method which loads String properties
     * from a user-specified text file into a HashMap for use.
     * 
     * @param filePath The location of the text properties file.
     * 
     * @throws IOException If any error occurs while reading from the text file.
     */
    @Override
    public void loadProperties(String filePath) throws IOException {
        this.filePath = filePath;
        try (BufferedReader b = new BufferedReader(new FileReader(this.filePath))) {
            String line, name, value;
            String[] pieces;
            while ((line = b.readLine()) != null) {
                pieces = line.split("=");
                name = pieces[0].trim();
                value = pieces[1].trim();
                this.addProperty(name, value);
            }
        }
    }
}