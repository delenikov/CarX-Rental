package project.carxrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND )
public class LokacijaNotFoundException extends RuntimeException{
    public LokacijaNotFoundException(Integer idlokacija) {
        super(String.format("Lokacijata so %d id ne e pronajdeno!", idlokacija));
    }
}
