package dio.vacina.controllers;

import lombok.AllArgsConstructor;
import dio.vacina.dto.request.VacinaDTO;
import dio.vacina.dto.response.MessageResponseDTO;
import dio.vacina.exception.VacinaNotFoundException;
import dio.vacina.services.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vacinas")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VacinaController {

    private final VacinaService vacinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid VacinaDTO vacinaDTO) {
        return vacinaService.create(vacinaDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VacinaDTO findById(@PathVariable Long id) throws VacinaNotFoundException {
        return vacinaService.findById(id);
    }

    @GetMapping
    public List<VacinaDTO> listAll() {
        return vacinaService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid VacinaDTO vacinaDTO) throws VacinaNotFoundException {
        return vacinaService.update(id, vacinaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws VacinaNotFoundException {
        vacinaService.delete(id);
    }
}
