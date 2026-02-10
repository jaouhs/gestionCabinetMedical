package ma.fsr.ms.rendezvousservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MedecinClient {

    private final RestTemplate restTemplate;

    public MedecinClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void checkMedecinExists(Long medecinId) {
        try {
            restTemplate.getForObject(
                    "http://API-GATEWAY" + "/api/medecins/" + medecinId,
                    Object.class
            );
        } catch (Exception e) {
            throw new RuntimeException("Médecin introuvable.");
        }
    }
}

