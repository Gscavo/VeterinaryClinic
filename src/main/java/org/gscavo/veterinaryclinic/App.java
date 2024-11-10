package org.gscavo.veterinaryclinic;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import org.gscavo.veterinaryclinic.utils.connection.MongoDBConnection;

import static org.gscavo.veterinaryclinic.utils.connection.MongoDBConnection.startConnection;


/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;

    public static MongoDBConnection mongoDBConnection;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        startConnection(null);

        launch();

    }
}