package org.gscavo.veterinaryclinic.test.dao;

import org.gscavo.veterinaryclinic.model.Procedure;
import org.gscavo.veterinaryclinic.utils.enums.ProcedureType;

public class ProcedureDAOTest {

    public static Procedure getTestProcedureFullFilled() {
        return Procedure.builder()
                .name("Vacina")
                .description("Vacina de antiviral")
                .price(100.0f)
                .type(ProcedureType.TREATMENT)
                .build();
    }
}
