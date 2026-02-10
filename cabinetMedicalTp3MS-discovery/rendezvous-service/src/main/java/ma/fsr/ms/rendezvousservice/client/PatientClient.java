package ma.fsr.ms.rendezvousservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientClient {

    private final RestTemplate restTemplate;

    public PatientClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void checkPatientExists(Long patientId) {
        try {
            restTemplate.getForObject(
                    "http://API-GATEWAY/api/patients/" + patientId,
                    Object.class
            );
        } catch (Exception e) {
            throw new RuntimeException("Patient introuvable.");
        }
    }

}
