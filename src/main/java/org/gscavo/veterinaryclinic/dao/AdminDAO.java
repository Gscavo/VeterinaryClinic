package org.gscavo.veterinaryclinic.dao;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.model.Admin;

public class AdminDAO extends PersonDAO<Admin> {
    public AdminDAO() {
        super(Admin.class);
    }

    @Override
    public Admin getFullFilledObject() {
        return Admin.builder()
                .name("Admin")
                .password("admin")
                .cpf("11111111199")
                .address(new ObjectId())
                .email("admin@admin.com")
                .phoneNumber("9990011223344")
                .build();
    }
}
