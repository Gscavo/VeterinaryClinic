package org.gscavo.veterinaryclinic.test.dao;

import org.gscavo.veterinaryclinic.model.Address;

public class AddressDAOTest {

    public static Address getTestAddressFullFilled() {
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
