/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gscavo.veterinaryclinic.view.tables;

import lombok.Getter;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.AppointmentController;
import org.gscavo.veterinaryclinic.model.Appointment;
import org.gscavo.veterinaryclinic.model.view.AppointmentSimpleView;
import org.gscavo.veterinaryclinic.utils.ViewUtils;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;
import org.gscavo.veterinaryclinic.view.panels.TodayAppointments;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 *
 * @author gscavo
 */
public class TodayAppointmentsTable extends JTable {

    private TodayAppointments parentPanel;

    private AppointmentController controller;

    private ArrayList<Appointment> rawList;
    private ArrayList<AppointmentSimpleView> viewList;

    private int selectedRow;
    private int selectedColumn;
    private ObjectId selectedId;
    private Object selectedValue;

    @Getter
    private Appointment selectedData;

    public TodayAppointmentsTable() {
        super();
        this.parentPanel = null;
        myInitComponents();
        
    }
    public TodayAppointmentsTable(TodayAppointments parentPanel) {
        super();
        this.parentPanel = parentPanel;
        myInitComponents();
    }

    private void myInitComponents() {
        myInitControllers();
        getAppointmentListsFromMongoDB();
        setModel();
        initOnMouseClicked();
    }

    private void myInitControllers() {
        this.controller = (AppointmentController) Controllers.APPOINTMENT.getController();
    }

    private void getAppointmentListsFromMongoDB() {
        this.rawList = controller.getAllToday();

        this.viewList = controller.getAllForSimpleView(rawList);
    }
    
    public void updateModel() {
        getAppointmentListsFromMongoDB();
        this.setModel(dataModel);
    }

    private void setModel() {
        TableModel model = ViewUtils.generateDataModelFromObjectList(this.viewList, AppointmentSimpleView.class);

        super.setModel(model);
    }

    public void updateSelectedRowColumn() {
        int idRow = this.getTableHeader().getColumnModel().getColumnIndex("id");

        this.selectedRow = this.getSelectedRow();
        this.selectedColumn = this.getSelectedColumn();

        this.selectedId = (ObjectId) this.getModel().getValueAt(
                selectedRow,
                idRow
        );

        this.selectedValue = this.getModel().getValueAt(
                selectedRow,
                selectedColumn
        );

        this.selectedData = this.rawList.get(selectedRow);

        System.out.println("-------- SELECTED INFORMATION --------");
        System.out.println("idRow: " + idRow);
        System.out.println("selectedRow: " + selectedRow);
        System.out.println("selectedColumn: " + selectedColumn);
        System.out.println("selectedId: " + selectedId);
        System.out.println("selectedValue: " + selectedValue);
        System.out.println("selectedData: " + selectedData);
        System.out.println("--------------------------------------");
    }

    private void initOnMouseClicked() {
        this.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        updateSelectedRowColumn();
                        parentPanel.updatedDatabaseSelection();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) { }

                    @Override
                    public void mouseReleased(MouseEvent e) { }

                    @Override
                    public void mouseEntered(MouseEvent e) { }

                    @Override
                    public void mouseExited(MouseEvent e) { }
                }
        );
    }

}
