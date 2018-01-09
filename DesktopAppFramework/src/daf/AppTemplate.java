package daf;

import daf.ui.*;

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
     * The application name/title.
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
     * Accessor method for the AppTemplate's name.
     * 
     * @return The name of the application.
     */
    public String getName() { return this.name; }
    /**
     * Accessor method for the AppTemplate's icon.
     * 
     * @return The icon used for this application on the task bar and desktop.
     */
    public Image getImage() { return this.icon; }
    /**
     * Accessor method for the AppTemplate's graphical user interface.
     * 
     * @return An abstracted representation of the application's GUI.
     */
    public AppGUI getGUI() { return this.gui; }
    /**
     * Initialization method for constructing the application's components.
     * Must be overridden by the subclass.
     */
    public abstract void buildApp();
    /**
     * Overridden implementation of start(Stage s) from 
     * javafx.stage.Stage for running the application.
     * 
     * @param stage The Stage object provided by the main thread.
     */
    @Override
    public void start(Stage stage) {
        // gui = new AppGUI(this, stage);
        buildApp();
        stage.show();
    }
}
