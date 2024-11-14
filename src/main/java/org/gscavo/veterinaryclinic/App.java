package org.gscavo.veterinaryclinic;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.gscavo.veterinaryclinic.utils.connection.MongoDBConnection;

import static org.gscavo.veterinaryclinic.utils.connection.MongoDBConnection.startConnection;
import org.gscavo.veterinaryclinic.view.LoginFrame;
import org.gscavo.veterinaryclinic.view.TestFrame;
import org.gscavo.veterinaryclinic.view.panels.register.ProcedureRegisterPanel;


public class App {

    public static MongoDBConnection mongoDBConnection;

    public static void main(String[] args) {
        startConnection(null);

        TestFrame tf = new TestFrame();
        
        tf.setVisible(true);
    }
}