package daf.ui;

import daf.AppTemplate;
import daf.file.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;

/**
 * Abstract representation of a graphical user interface (GUI).
 * 
 * @author Benjamin Shu
 */
public class AppGUI {
    /**
     * The AppTemplate instance that this AppGUI is associated with.
     */
    protected AppTemplate app;
    /**
     * The application's desktop and task bar icon.
     */
    protected Image icon;
    /**
     * The application's name/title.
     */
    protected String title;
    /**
     * The instance of Stage provided by the Java main thread.
     */
    protected Stage stage;
    /**
     * The Scene instance that will contain this GUI's content.
     */
    protected Scene scene;
    /**
     * An instance of Pane to represent the layout/arrangement 
     * of content in this GUI's Scene. Can be substituted with 
     * a Pane subclass like BorderPane, GridPane, etc.
     */
    protected Pane layout;
    /**
     * Public constructor for the AppGUI that builds a GUI
     * from an instance of AppTemplate and a Stage provided
     * by the Java main thread.
     * 
     * @param app The AppTemplate instance that will make use of this GUI.
     * 
     * @param stage The Stage object provided by the Java main thread.
     */
    public AppGUI(AppTemplate app, Stage stage) {
        this.app = app;
        this.stage = stage;
        this.title = app.getName();
        this.icon = app.getImage();
        this.layout = new Pane();
        this.scene = new Scene(this.layout, 300, 300);
        this.stage.setScene(this.scene);
    }
    /**
     * Public mutator method for the AppGUI's layout Pane.
     * Allows a Pane to be provided by a separate class.
     * 
     * @param layout The provided Pane.
     */
    public void setLayout(Pane layout) { this.layout = layout; }
}
