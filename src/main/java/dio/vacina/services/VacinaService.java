package dio.vacina.services;

import lombok.AllArgsConstructor;
import dio.vacina.dto.mapper.VacinaMapper;
import dio.vacina.dto.request.VacinaDTO;
import dio.vacina.dto.response.MessageResponseDTO;
import dio.vacina.entities.Vacina;
import dio.vacina.exception.VacinaNotFoundException;
import dio.vacina.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    private final VacinaMapper vacinaMapper;

    public MessageResponseDTO create(VacinaDTO vacinaDTO) {
        Vacina vacina = vacinaMapper.toModel(vacinaDTO);
        Vacina savedVacina = vacinaRepository.save(vacina);

        MessageResponseDTO messageResponse = createMessageResponse("Vacina successfully created with ID ", savedVacina.getId());

        return messageResponse;
    }

    public VacinaDTO findById(Long id) throws VacinaNotFoundException {
        Vacina vacina = vacinaRepository.findById(id)
                .orElseThrow(() -> new VacinaNotFoundException(id));

        return vacinaMapper.toDTO(vacina);
    }

    public List<VacinaDTO> listAll() {
        List<Vacina> vacinas = vacinaRepository.findAll();
        return vacinas.stream()
                .map(vacinaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, VacinaDTO vacinaDTO) throws VacinaNotFoundException {
        vacinaRepository.findById(id)
                .orElseThrow(() -> new VacinaNotFoundException(id));

        Vacina updatedVacina = vacinaMapper.toModel(vacinaDTO);
        Vacina savedVacina = vacinaRepository.save(updatedVacina);

        MessageResponseDTO messageResponse = createMessageResponse("Vacina successfully updated with ID ", savedVacina.getId());

        return messageResponse;
    }

    public void delete(Long id) throws VacinaNotFoundException {
        vacinaRepository.findById(id)
                .orElseThrow(() -> new VacinaNotFoundException(id));

        vacinaRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
