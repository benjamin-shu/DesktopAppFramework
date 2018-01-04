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
public abstract class AppGUI {
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
     * 
     */
    protected Stage stage;
    /**
     * 
     */
    protected Scene scene;
    /**
     * 
     */
    protected Pane layout;
}
class EditorGUI extends AppGUI {
    protected Pane topToolbar;
    protected AppYesNoCancelSingleton yesNoCancelDialog;
    protected AppMessageSingleton messageDialog;
    protected AppTextInputSingleton textInputDialog;
    protected AppFileEditor fileEditor;
}
