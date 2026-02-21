package ma.fsr.eda.rendezvousservice.service;

import lombok.extern.slf4j.Slf4j;
import ma.fsr.eda.rendezvousservice.model.RendezVous;
import ma.fsr.eda.rendezvousservice.model.StatutRdv;
import ma.fsr.eda.rendezvousservice.repository.MedecinProjectionRepository;
import ma.fsr.eda.rendezvousservice.repository.PatientProjectionRepository;
import ma.fsr.eda.rendezvousservice.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class RendezVousService {

    @Autowired
    private RendezVousRepository repository;

    @Autowired
    private PatientProjectionRepository patientProjectionRepository;

    @Autowired
    private MedecinProjectionRepository medecinProjectionRepository;

    public RendezVous create(RendezVous rdv) {

        log.info("RendezVous : {}", rdv);
        if (rdv.getDateRdv() == null) {
            throw new RuntimeException("La date du rendez-vous est obligatoire.");
        }

        if (rdv.getDateRdv().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("La date du rendez-vous doit être future.");
        }

        if(!patientProjectionRepository.existsById(rdv.getPatientId())) {
            throw new RuntimeException("Patient introuvable.");
        }

        if(!medecinProjectionRepository.existsById(rdv.getMedecinId())) {
            throw new RuntimeException("Médecin introuvable.");
        }

        rdv.setDateCreation(LocalDateTime.now());

        rdv.setStatut(StatutRdv.PLANIFIE);
        return repository.save(rdv);
    }

    public List<RendezVous> list() {
        return repository.findAll();
    }

    public RendezVous getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Rendez-vous introuvable : id = " + id)
                );
    }

    public RendezVous update(Long id, RendezVous rdv) {

        RendezVous existing = getById(id);

        if (rdv.getDateRdv() != null) {
            if (rdv.getDateRdv().isBefore(LocalDateTime.now())) {
                throw new RuntimeException("La date du rendez-vous doit être future.");
            }
            existing.setDateRdv(rdv.getDateRdv());
        }

        if (rdv.getPatientId() != null) {
            //patientClient.checkPatientExists(rdv.getPatientId());
            existing.setPatientId(rdv.getPatientId());
        }

        if (rdv.getMedecinId() != null) {
            //medecinClient.checkMedecinExists(rdv.getMedecinId());
            existing.setMedecinId(rdv.getMedecinId());
        }

        return repository.save(existing);
    }

    public RendezVous updateStatut(Long id, StatutRdv statut) {

        if (statut == null) {
            throw new RuntimeException(
                    "Statut invalide. Valeurs possibles : PLANIFIE, ANNULE, TERMINE."
            );
        }

        RendezVous rdv = getById(id);
        rdv.setStatut(statut);
        return repository.save(rdv);
    }

    public void delete(Long id) {
        RendezVous rdv = getById(id);
        repository.delete(rdv);
    }
}
