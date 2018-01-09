package daf.props;

import java.util.HashMap;

/**
 *
 * @author Benjamin Shu
 */
public class XMLPropManager extends AppPropertiesManager {
    private XMLPropManager() { }
    @Override
    public AppPropertiesManager getSingleton() {
        if (singleton == null || !(singleton instanceof XMLPropManager)) {
            singleton = new XMLPropManager();
            properties = new HashMap<>();
        }
        return singleton;
    }
    @Override
    public void loadProperties(String filePath) {
        
    }
}
