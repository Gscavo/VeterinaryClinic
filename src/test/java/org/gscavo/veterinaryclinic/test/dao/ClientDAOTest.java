package org.gscavo.veterinaryclinic.test.dao;

import org.gscavo.veterinaryclinic.dao.ClientDAO;
import org.gscavo.veterinaryclinic.model.Client;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ClientDAOTest {

    private static final String EMAIL = "john.doe@gmail.com";
    private static final String PASSWORD = "teste123";

    public static ClientDAO clientDAO = new ClientDAO();

    public static Client getTestClientFullFilled() {
        return Client.builder()
                .cpf("12345678921")
                .name("John Does")
                .password(PASSWORD)
                .email(EMAIL)
                .phoneNumber("19900001234")
                .build();
    }

    @BeforeAll
    public static void setup() {
//        clientDAO.insertOne(ClientDAOTest.getTestClientFullFilled());
//        clientDAO.dropCollection();
    }

    @AfterAll
    public static void destruct() {
//        clientDAO.dropCollection();
    }

    @Test
    public void findEmailAndPasswordTest() {
//        Client client = clientDAO.findByEmailAndPassword(EMAIL, PASSWORD);

    }

    @Test
    public void insertOneSucessTest() {
        clientDAO.insertOne(ClientDAOTest.getTestClientFullFilled());
    }


    @Test
    public void findAllClientInDatabase() {
        ArrayList<Client> allClients = clientDAO.findAll();

        for (Client client : allClients) {
            System.out.println(client.getCpf());
            System.out.println(client.getName());
            System.out.println(client.getEmail());
            System.out.println(client.getPassword());
        }


    }
}
