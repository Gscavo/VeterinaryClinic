package org.gscavo.veterinaryclinic.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Getter;
import org.gscavo.veterinaryclinic.dao.AnimalDAO;
import org.gscavo.veterinaryclinic.dao.ClientDAO;
import org.gscavo.veterinaryclinic.dao.VeterinarianDAO;
import org.gscavo.veterinaryclinic.model.Animal;
import org.gscavo.veterinaryclinic.model.Appointment;
import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.model.Veterinarian;
import org.gscavo.veterinaryclinic.model.view.AppointmentView;
import org.gscavo.veterinaryclinic.utils.ConversionUtils;

import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;

@Getter
public class AppointmentController extends BaseController {

    private AnimalController animalController;
    private ClientController clientController;
    private VeterinarianController veterinarianController;

    public AppointmentController() {
        super(Appointment.class);
    }

    public ArrayList<Appointment> getAllRaw() {
        return this.dao.findAll();
    }

    @Override
    public ArrayList<AppointmentView> getAllForDatabaseTable() {
        initAdditionalControllers();
        ArrayList<AppointmentView> finalViews = new ArrayList<>();
        ArrayList<Appointment> appointments = this.dao.findAll();

        for (Appointment appointment : appointments) {
            Animal animal = (Animal) animalController.getById(appointment.getAnimalId());

            Client client = clientController.getById(appointment.getClientId());

            Veterinarian veterinarian = veterinarianController.getById(appointment.getVeterinarianId());


            ArrayList<String> dateStrings = ConversionUtils.parseDayAndHourString(appointment.getDate());
            AppointmentView appointmentView = AppointmentView
                    .builder()
                    .id(appointment.getId())
                    .price(appointment.getCostAmount())
                    .date(dateStrings.get(0))
                    .time(dateStrings.get(1))
                    .animalName(animal == null ? "Animal não encontrado" : animal.getName())
                    .tutorName(client == null ? "Tutor não encontrado" : client.getName())
                    .veterinarianName(veterinarian == null ? "Veterinário não encontrado" : veterinarian.getName())
                    .build();

            finalViews.add(appointmentView);
        }

        return finalViews;
    }
    
    public List<String> getNextDates() {
        ArrayList<String> dates = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar calendar = Calendar.getInstance();
        
        int addedDays = 0;
        while (addedDays < 15) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                dates.add(dateFormat.format(calendar.getTime())); // Add the weekday
                addedDays++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Move to the next day
        }

        return dates;
    }
    
    public ArrayList<String> getHours() {
        ArrayList<String> hours = new ArrayList<>();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        // Get today's date and set the start time to 8:00 AM
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        // Generate hours between 8:00 AM and 6:00 PM (inclusive)
        for (int i = 0; i < 15 && calendar.get(Calendar.HOUR_OF_DAY) <= 18; i++) {
            hours.add(timeFormat.format(calendar.getTime())); // Format and add the time
            calendar.add(Calendar.HOUR_OF_DAY, 1); // Move to the next hour
        }

        return hours;
    }

    private void initAdditionalControllers() {
        animalController = (AnimalController) Controllers.ANIMAL.getController();
        clientController = (ClientController) Controllers.CLIENT.getController();
        veterinarianController = (VeterinarianController) Controllers.VETERINARIAN.getController();
    }
}
