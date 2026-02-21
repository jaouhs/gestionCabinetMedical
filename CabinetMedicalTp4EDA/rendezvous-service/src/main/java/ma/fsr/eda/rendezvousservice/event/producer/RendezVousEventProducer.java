package ma.fsr.eda.rendezvousservice.event.producer;

import lombok.RequiredArgsConstructor;
import ma.fsr.eda.rendezvousservice.event.dto.RendezVousCreatedEvent;
import ma.fsr.eda.rendezvousservice.model.RendezVous;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RendezVousEventProducer {
    private final KafkaTemplate<String, RendezVousCreatedEvent> kafkaTemplate;
    public void publishRendezVousCreated(RendezVous rdv) {
        RendezVousCreatedEvent event = new RendezVousCreatedEvent(
                UUID.randomUUID().toString(),
                rdv.getId(),
                rdv.getPatientId(),
                rdv.getMedecinId(),
                rdv.getDateRdv(),
                rdv.getStatut(),
                rdv.getDateCreation()
        );
        kafkaTemplate.send("rendezvous.created", rdv.getId().toString(), event);
    }
}

