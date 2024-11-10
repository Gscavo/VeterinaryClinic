package org.gscavo.veterinaryclinic.dao;

import org.gscavo.veterinaryclinic.model.Procedure;
import org.gscavo.veterinaryclinic.utils.enums.ProcedureType;

public class ProcedureDAO extends BaseDAO<Procedure> {
    public ProcedureDAO() {
        super("procedure", Procedure.class);
    }

    @Override
    public Procedure getFullFilledObject() {
        return Procedure.builder()
                .name("Vacina")
                .description("Vacina de antiviral")
                .price(100.0f)
                .type(ProcedureType.TREATMENT)
                .build();
    }
}
