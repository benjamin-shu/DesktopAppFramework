package daf.ui;

import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Singleton class designed to prompt the user for a yes/no answer.
 * 
 * @author Benjamin Shu
 */
public class AppYesNoCancelSingleton extends Stage {
    // String constants for the three button labels.
    private static final String 
            YES = "Yes", NO = "No", CANCEL = "Cancel";
    
    // Static instance of this class to prevent creation of more than one AppYesNoCancelSingleton.
    private static AppYesNoCancelSingleton singleton;
    
    // Scene object to display the AppYesNoCancelSingleton's content.
    private static Scene scene;
    // VBox object to vertically align JavaFX scene components.
    private static VBox layout;
    // HBox object to horizontally align the dialog's three buttons.
    private static HBox buttons;
    // Text object to display String prompts.
    private static Text prompt;
    // Button objects for the user to either respond with a yes/no or close the dialog.
    private static Button yesButton, noButton, cancelButton;
    // String object to store user response.
    private static String response;
    
    /**
     * Private constructor, declared to prevent creation of multiple instances.
     */
    private AppYesNoCancelSingleton() { }
    /**
     * Public accessor method for the singleton object.
     * 
     * @return The one instance of AppYesNoCancelSingleton.
     */
    public AppYesNoCancelSingleton getSingleton() {
        if (singleton == null) {
            singleton = new AppYesNoCancelSingleton();
        }
        return singleton;
    }
    /**
     * Method that prepares the AppYesNoCancelSingleton for use.
     * 
     * @param owner The Stage with which this AppYesNoCancelSingleton will be associated.
     */
    public void init(Stage owner) {
        initModality(Modality.WINDOW_MODAL);
        initOwner(owner);
        
        layout = new VBox();
        prompt = new Text();
        
        buttons = new HBox();
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                response = ((Button) ae.getSource()).getText();
                AppYesNoCancelSingleton.this.close();
            }
        };
        yesButton = new Button(YES); yesButton.setOnAction(buttonHandler);
        noButton = new Button(NO); noButton.setOnAction(buttonHandler);
        cancelButton = new Button(CANCEL); cancelButton.setOnAction(buttonHandler);
        buttons.getChildren().addAll(yesButton, noButton, cancelButton);
        
        layout.getChildren().addAll(prompt, buttons);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
        layout.setPadding(new Insets(50, 50, 50, 50));
        
        scene = new Scene(layout, 300, 300);
        this.setScene(scene);
    }
    /**
     * Method which displays a user-specified prompt and title.
     * 
     * @param title The user-specified title for this AppYesNoCancelSingleton.
     * 
     * @param text The user-specified message for this AppYesNoCancelSingleton.
     */
    public void showMessage(String title, String text) {
        this.setTitle(title);
        prompt.setText(text);
        this.showAndWait();
    }
    /**
     * Accessor method for a String representation of the user's response.
     * 
     * @return <code>Yes</code> for the Yes button, <code>No</code> for the
     *      No button, and <code>Cancel</code> for the Cancel button.
     */
    public String getResponse() {
        return response;
    }
}