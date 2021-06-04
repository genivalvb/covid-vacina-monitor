package dio.vacina.services;

import dio.vacina.dto.mapper.VacinaMapper;
import dio.vacina.dto.request.VacinaDTO;
import dio.vacina.dto.response.MessageResponseDTO;
import dio.vacina.entities.Vacina;
import dio.vacina.repositories.VacinaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static dio.vacina.vacinaapi.utils.VacinaUtils.createFakeDTO;
import static dio.vacina.vacinaapi.utils.VacinaUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VacinaServiceTest {

    @Mock
    private VacinaRepository vacinaRepository;

    @Mock
    private VacinaMapper vacinaMapper;

    @InjectMocks
    private VacinaService vacinaService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        VacinaDTO vacinaDTO = createFakeDTO();
        Vacina expectedSavedVacina = createFakeEntity();

        when(vacinaMapper.toModel(vacinaDTO)).thenReturn(expectedSavedVacina);
        when(vacinaRepository.save(any(Vacina.class))).thenReturn(expectedSavedVacina);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedVacina.getId());
        MessageResponseDTO successMessage = vacinaService.create(vacinaDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedVacinaId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + savedVacinaId)
                .build();
    }

}
