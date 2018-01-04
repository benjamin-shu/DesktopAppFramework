package daf.ui;

import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

/**
 * Singleton class designed to prompt the user for String input.
 * 
 * @author Benjamin Shu
 */
public class AppTextInputSingleton extends Stage {
    // String constants for the two button labels.
    private static final String ENTER = "Enter", CANCEL = "Cancel";
    
    // Static instance of this class to prevent creation of more than one AppTextInputSingleton.
    private static AppTextInputSingleton singleton;
    // Scene object to display the AppTextInputSingleton's content.
    private static Scene scene;
    // VBox object to vertically align JavaFX scene components.
    private static VBox layout;
    // Text object to prompt the user for input.
    private static Text prompt;
    // TextArea object for the user to enter text input.
    private static TextArea textEntry;
    // HBox object to horizontally align the two buttons.
    private static HBox buttons;
    // Button objects for the user to either submit input or close the dialog.
    private static Button enterButton, cancelButton;
    // String object for storing user input.
    private static String response;
    
    /**
     * Private constructor, declared to prevent creation of multiple instances.
     */
    private AppTextInputSingleton() { }
    /**
     * Public accessor method for the singleton object.
     * 
     * @param singleton The one instance of AppTextInputSingleton.
     */
    public AppTextInputSingleton getSingleton() {
        if (singleton == null) {
            singleton = new AppTextInputSingleton();
        }
        return singleton;
    }
    /**
     * Method that prepares the AppTextInputSingleton for use.
     * 
     * @param owner The Stage with which this AppTextInputSingleton will be associated.
     */
    public void init(Stage owner) {
        initModality(Modality.WINDOW_MODAL);
        initOwner(owner);
        
        layout = new VBox();
        prompt = new Text();
        textEntry = new TextArea();
        
        buttons = new HBox();
        enterButton = new Button(ENTER);
        enterButton.setOnAction(e -> {
            response = textEntry.getText();
            AppTextInputSingleton.this.close();
        });
        cancelButton = new Button(CANCEL);
        cancelButton.setOnAction(e -> {
            response = null;
            AppTextInputSingleton.this.close();
        });
        buttons.getChildren().addAll(enterButton, cancelButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);
        
        layout.getChildren().addAll(prompt, textEntry, buttons);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
        layout.setPadding(new Insets(50, 50, 50, 50));
        
        scene = new Scene(layout, 300, 300);
        this.setScene(scene);
    }
    /**
     * Method that displays a user-specified prompt and title.
     * 
     * @param title The user-specified title for this dialog.
     * 
     * @param text The user-specified prompt for this dialog.
     */
    public void showMessage(String title, String text) {
        this.setTitle(title);
        this.prompt.setText(text);
        this.showAndWait();
    }
}