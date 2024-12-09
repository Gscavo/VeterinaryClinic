package org.gscavo.veterinaryclinic.view.menu;

import org.gscavo.veterinaryclinic.utils.ViewUtils;
import org.gscavo.veterinaryclinic.view.MainUserFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GoToMainScreenMenu extends JMenu {

    private MainUserFrame frame;
    private JPanel mainScreen;

    public GoToMainScreenMenu(MainUserFrame frame, JPanel panel) {
        super();
        this.frame = frame;
        this.mainScreen = panel;
        myInitComponents();
        this.setIcon(
                new ImageIcon("src/main/resources/org/gscavo/veterinaryclinic/icons/home.png")
        );
    }

    private void myInitComponents() {
        this.addMouseListener(
                getMouseListener()
        );
    }

    private MouseListener getMouseListener() {
        JPanel mainPanel = frame.getMainPanel();
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Hey");

                mainPanel.removeAll();
                mainPanel.add(mainScreen);

                ViewUtils.updateScreen(frame, true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }
}
