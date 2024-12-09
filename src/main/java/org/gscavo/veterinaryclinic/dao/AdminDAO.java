package org.gscavo.veterinaryclinic.dao;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Admin;
import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.utils.enums.PersonType;

import java.util.ArrayList;

public class AdminDAO extends PersonDAO<Admin> {
    public AdminDAO() {
        super(Admin.class);
    }

    @Override
    public ArrayList<Admin> findAll() {
        Bson filter = Filters.eq("type", PersonType.ADMIN);

        ArrayList<Admin> allAdmins = new ArrayList<>();

        for (Document document : this.collection.find(filter)) {
            Admin admin = new Admin(document);

            allAdmins.add(admin);
        }

        return allAdmins;
    }

    @Override
    public Admin getFullFilledObject() {
        return Admin.builder()
                .name("Admin")
                .password("admin")
                .cpf("11111111199")
                .email("admin@admin.com")
                .phoneNumber("9990011223344")
                .build();
    }
}
