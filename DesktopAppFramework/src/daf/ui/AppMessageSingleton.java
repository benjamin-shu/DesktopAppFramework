package daf.ui;

import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

/**
 * Singleton class used to display text messages.
 * 
 * @author Benjamin Shu
 */
public class AppMessageSingleton extends Stage {
    // String constant for the single button's label.
    private static final String CLOSE = "Close";
    
    // Static instance of this class to prevent creation of more than one AppMessageSingleton.
    private static AppMessageSingleton singleton;
    
    // Scene object to display the AppMessageSingleton's contents.
    private static Scene scene;
    // VBox object to vertically align JavaFX scene components.
    private static VBox layout;
    // Text object to display String messages.
    private static Text message;
    // Button object for the user to close the dialog after viewing the message.
    private static Button close;
    
    /**
     * Private constructor, declared to prevent creation of multiple instances.
     */
    private AppMessageSingleton() { }
    /**
     * Public accessor method for the singleton object.
     * 
     * @return The one instance of AppMessageSingleton.
     */
    public AppMessageSingleton getSingleton() {
        if (singleton == null) {
            singleton = new AppMessageSingleton();
        }
        return singleton;
    }
    /**
     * Method that prepares the AppMessageSingleton for use.
     * 
     * @param owner The Stage with which this AppMessageSingleton will be associated.
     */
    public void init(Stage owner) {
        initModality(Modality.WINDOW_MODAL);
        initOwner(owner);
        
        layout = new VBox();
        message = new Text();
        close = new Button(CLOSE);
        close.setOnAction(e -> { AppMessageSingleton.this.close(); });
        layout.getChildren().addAll(message, close);
        
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
        layout.setPadding(new Insets(50, 50, 50, 50));
        
        scene = new Scene(layout, 300, 300);
        this.setScene(scene);
    }
    /**
     * Method which displays a user-specified message and title.
     * 
     * @param title The user-specified title for this AppMessageSingleton.
     * 
     * @param text The user-specified message for this AppMessageSingleton.
     */
    public void showMessage(String title, String text) {
        this.setTitle(title);
        message.setText(text);
        this.showAndWait();
    }
}