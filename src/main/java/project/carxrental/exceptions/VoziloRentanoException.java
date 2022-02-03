package project.carxrental.exceptions;

public class VoziloRentanoException extends RuntimeException {
    public VoziloRentanoException(String registracija) {
        super(String.format("Voziloto so %s registracija e iznajmeno i ne moze da se izbrise!", registracija));
    }
}
