package project.carxrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND )

public class VoziloNotFoundException extends RuntimeException{
    public VoziloNotFoundException(String registracija) {
        super(String.format("Voziloto so %s registracija ne e pronajdeno!", registracija));
    }
}