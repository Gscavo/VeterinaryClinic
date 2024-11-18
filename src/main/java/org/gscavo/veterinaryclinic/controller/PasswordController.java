package org.gscavo.veterinaryclinic.controller;

import org.gscavo.veterinaryclinic.controller.abstractions.BaseController;
import org.gscavo.veterinaryclinic.utils.information.SystemOperationResult;

// Implementar a questao de cadastro da senha

public class PasswordController extends BaseController<String> {
    public PasswordController() {
        super(String.class);
    }

    @Override
    public SystemOperationResult register(String object) {
        return null;
    }
}
