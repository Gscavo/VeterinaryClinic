package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Veterinarian;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import java.util.ArrayList;
import java.util.Collections;

import static org.gscavo.veterinaryclinic.utils.ConversionUtils.documentsListToTypeList;

public class VeterinarianDAO extends PersonDAO<Veterinarian> {
    public VeterinarianDAO() {
        super(Veterinarian.class);
    }

    @Override
    public ArrayList<Veterinarian> findAll() {
        Bson filters = Filters.eq("type", PersonType.VETERINARIAN);

        return documentsListToTypeList(
                collection.find(filters),
                classType
        );
    }

    @Override
    public Veterinarian getFullFilledObject() {
        return Veterinarian.builder()
                .name("Dr. Pera")
                .password("12345678")
                .cpf("09190128931")
                .crmv("123455")
                .email("pera.dr@gmail.com")
                .phoneNumber("18901233214")
                .build();
    }
}
