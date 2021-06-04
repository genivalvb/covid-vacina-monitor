package dio.vacina.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VacinaNotFoundException extends Exception {

    public VacinaNotFoundException(Long id) {
        super(String.format("Vacina with ID %s not found!", id));
    }
}
