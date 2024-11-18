package org.gscavo.veterinaryclinic;


import org.gscavo.veterinaryclinic.utils.connection.MongoDBConnection;

import static org.gscavo.veterinaryclinic.utils.connection.MongoDBConnection.startConnection;
import org.gscavo.veterinaryclinic.view.MainUserFrame;


public class App {

    public static MongoDBConnection mongoDBConnection;

    public static void main(String[] args) {
        startConnection(null);

        MainUserFrame tf = new MainUserFrame();
        
        tf.setVisible(true);
    }
}