package org.gscavo.veterinaryclinic.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalView {
    private String animalName;
    private String race;
    private String speciesName;
    private String tutorName;
}
