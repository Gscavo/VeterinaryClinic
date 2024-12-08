package org.gscavo.veterinaryclinic.controller;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.dao.AnimalDAO;
import org.gscavo.veterinaryclinic.model.Animal;

import org.gscavo.veterinaryclinic.model.Client;
import org.gscavo.veterinaryclinic.model.Species;
import org.gscavo.veterinaryclinic.model.view.AnimalView;
import org.gscavo.veterinaryclinic.utils.enums.Controllers;

public class AnimalController extends BaseController {

    private ClientController clientController;
    private SpeciesController speciesController;

    public AnimalController() {
        super(Animal.class);
    }

    @Override
    public ArrayList<AnimalView> getAllForDatabaseTable() {
        initAdditionalControllers();
        ArrayList<AnimalView> finalViews = new ArrayList<>();
        ArrayList<Animal> animals = this.dao.findAll();

        for (Animal animal : animals) {

            Client client = clientController.getById(animal.getTutor());
            Species species = speciesController.getById(animal.getSpecies());

            AnimalView animalView = AnimalView
                    .builder()
                    .id(animal.getId())
                    .name(animal.getName())
                    .race(animal.getRace())
                    .species(species == null ? "Espécie não encontrada" : species.getName())
                    .tutorName(client == null ? "Cliente não encontrado" : client.getName())
                    .build();

            finalViews.add(animalView);
        }

        return finalViews;
    }

    public ArrayList<Animal> getAllByClientId(ObjectId clientId) {
        return ((AnimalDAO) this.dao).findByClientId(clientId);
    };

    private void initAdditionalControllers() {
        clientController =  (ClientController) Controllers.CLIENT.getController();
        speciesController = (SpeciesController) Controllers.SPECIES.getController();
    }
}
