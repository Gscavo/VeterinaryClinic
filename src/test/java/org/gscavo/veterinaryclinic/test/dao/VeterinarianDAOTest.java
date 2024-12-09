package org.gscavo.veterinaryclinic.test.dao;

import org.gscavo.veterinaryclinic.model.Veterinarian;


public class VeterinarianDAOTest {

    public static Veterinarian getTestVeterinarianFullFilled() {
        return Veterinarian.builder()
                .name("Dr. Pera")
                .cpf("09190128931")
                .crmv("123455")
                .email("pera.dr@gmail.com")
                .phoneNumber("18901233214")
                .build();
    }
}
