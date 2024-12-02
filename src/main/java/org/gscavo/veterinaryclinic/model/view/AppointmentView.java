package org.gscavo.veterinaryclinic.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentView {
    private float price;
    private String date;
    private String time;
    private String veterinarianName;
    private String tutorName;
    private String animalName;
}
