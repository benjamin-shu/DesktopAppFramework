package daf;

import daf.ui.AppGUI;
import daf.props.AppPropertiesManager;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 * The base framework for simple desktop applications. 
 * Only the most basic features (i.e. application name,
 * program icon, and an abstracted graphical user interface)
 * are specified to allow for more varied subclasses.
 * 
 * @author Benjamin Shu
 */
public abstract class AppTemplate extends Application {
    /**
     * An instance of the PropertiesManager singleton used to handle
     * loading String properties from XML files.
     */
    protected AppPropertiesManager propsManager;
    /**
     * The application name/title. Loaded from an XML file by this
     * AppTemplate's PropertiesManager and passed to the AppGUI on
     * initialization.
     */
    protected String name;
    /**
     * The icon that will appear on the application's desktop shortcut
     * and in the top left corner of it's GUI.
     */
    protected Image icon;
    /**
     * An instance of AppGUI used to provide a user interface for the
     * application. Due to the numerous types of desktop applications, 
     * different features for specific subclasses of AppTemplate will
     * be provided by subclasses of AppGUI.
     */
    protected AppGUI gui;
    
    /**
     * Accessor methods for the AppTemplate's data fields.
     */
    public String getName() { return this.name; }
    public Image getImage() { return this.icon; }
    public AppGUI getGUI() { return this.gui; }
    /**
     * 
     */
    @Override
    public void start(Stage stage) {
        
    }
    public boolean loadProperties() {
        return false;
    }
}
