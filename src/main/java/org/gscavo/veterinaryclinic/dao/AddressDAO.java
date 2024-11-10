package org.gscavo.veterinaryclinic.dao;

import org.gscavo.veterinaryclinic.model.Address;

public class AddressDAO extends BaseDAO<Address> {

    public AddressDAO() {
        super("address", Address.class);
    }

    @Override
    public Address getFullFilledObject() {
        return Address.builder()
                .number(0)
                .street("Rua dos Bobos")
                .neighborhood("Jardim das plantas")
                .zipCode("12345678")
                .city("Limeira")
                .state("SP")
                .build();
    }
}
