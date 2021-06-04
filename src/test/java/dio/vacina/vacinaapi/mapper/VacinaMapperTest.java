package dio.vacina.vacinaapi.mapper;

import dio.vacina.dto.mapper.VacinaMapper;
import dio.vacina.dto.request.VacinaDTO;
import dio.vacina.dto.request.PhoneDTO;
import dio.vacina.entities.Vacina;
import dio.vacina.entities.Phone;
import dio.vacina.vacinaapi.utils.VacinaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VacinaMapperTest {

    @Autowired
    private VacinaMapper vacinaMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        VacinaDTO vacinaDTO = VacinaUtils.createFakeDTO();
        Vacina vacina = vacinaMapper.toModel(vacinaDTO);

        assertEquals(vacinaDTO.getCodigoVacina(), vacina.getCodigoVacina());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Vacina vacina = VacinaUtils.createFakeEntity();
        VacinaDTO vacinaDTO = vacinaMapper.toDTO(vacina);

        assertEquals(vacina.getCodigoVacina(), vacinaDTO.getCodigoVacina());

    }
}
