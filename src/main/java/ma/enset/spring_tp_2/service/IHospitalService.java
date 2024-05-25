package ma.enset.spring_tp_2.service;

import ma.enset.spring_tp_2.entities.Consultation;
import ma.enset.spring_tp_2.entities.Medecin;
import ma.enset.spring_tp_2.entities.Patient;
import ma.enset.spring_tp_2.entities.RenderVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RenderVous saveRenderVous(RenderVous renderVous);
    Consultation saveConsultation(Consultation consultation);
    Patient findPatientById(long id);
    Medecin findMedecinByNom(String nom);
    Medecin findMedecinById(long id);
    RenderVous findRenderVousById(long id);
}
