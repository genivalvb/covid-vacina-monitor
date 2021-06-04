package dio.vacina.vacinaapi.utils;

import dio.vacina.dto.request.VacinaDTO;
import dio.vacina.entities.Vacina;

import java.time.LocalDate;
import java.util.Collections;

public class VacinaUtils {

    private static final String CODIGO_VACINA = "CX-70A55B456TR";
    //private static final String LAST_NAME = "Peleias";
    //private static final String CPF_NUMBER = "369.333.878-79";
    private static final long VACINA_ID = 1L;
    public static final LocalDate DATA_ENVIO = LocalDate.of(2010, 10, 1);

    public static VacinaDTO createFakeDTO() {
        return VacinaDTO.builder()
                .codigoVacina(CODIGO_VACINA)
                //.lastName(LAST_NAME)
                //.cpf(CPF_NUMBER)
                .dataEnvio("04-04-2010")
                //.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Vacina createFakeEntity() {
        return Vacina.builder()
                .id(VACINA_ID)
                .codigoVacina(CODIGO_VACINA)
                //.lastName(LAST_NAME)
                //.cpf(CPF_NUMBER)
                .dataEnvio(DATA_ENVIO)
                //.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
