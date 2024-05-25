package ma.enset.spring_tp_2.service;

import jakarta.transaction.Transactional;
import ma.enset.spring_tp_2.entities.Consultation;
import ma.enset.spring_tp_2.entities.Medecin;
import ma.enset.spring_tp_2.entities.Patient;
import ma.enset.spring_tp_2.entities.RenderVous;
import ma.enset.spring_tp_2.repository.ConsultationRepository;
import ma.enset.spring_tp_2.repository.MedecinRepository;
import ma.enset.spring_tp_2.repository.PatientRepository;
import ma.enset.spring_tp_2.repository.RenderVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RenderVousRepository renderVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RenderVousRepository renderVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.renderVousRepository = renderVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RenderVous saveRenderVous(RenderVous renderVous) {
        return renderVousRepository.save(renderVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient findPatientById(long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Medecin findMedecinByNom(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public Medecin findMedecinById(long id) {
        return medecinRepository.findById(id).orElse(null);
    }

    @Override
    public RenderVous findRenderVousById(long id) {
        return renderVousRepository.findById(id).orElse(null);
    }
}
