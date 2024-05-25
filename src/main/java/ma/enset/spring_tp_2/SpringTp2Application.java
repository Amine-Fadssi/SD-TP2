package ma.enset.spring_tp_2;

import ma.enset.spring_tp_2.entities.*;
import ma.enset.spring_tp_2.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringTp2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringTp2Application.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService iHospitalService){
        return args -> {
            // Ajouter des patients
            Stream.of("Amine","Mohammed","Youssef")
                    .forEach(name ->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patient.setScore((int) (Math.random() * (5000 - 1200 + 1) + 1200));
                        iHospitalService.savePatient(patient);
                    });
            // Ajouter des medecin
            Stream.of("Yassine","Younes","Ali")
                    .forEach(name ->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentist");
                        iHospitalService.saveMedecin(medecin);
                    });

            // Ajouter rendez-vous
            Patient patient = iHospitalService.findPatientById(1L);
            Medecin medecin = iHospitalService.findMedecinByNom("Yassine");

            RenderVous renderVous = new RenderVous();
            renderVous.setStatus(StatusRDV.PENDING);
            renderVous.setDate(new Date());
            renderVous.setMedecin(medecin);
            renderVous.setPatient(patient);

            iHospitalService.saveRenderVous(renderVous);

            // Ajouter consultation
            RenderVous renderVous1 = iHospitalService.findRenderVousById(1L);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRenderVous(renderVous1);
            consultation.setRapport("Simple rapport for consultation...");

            iHospitalService.saveConsultation(consultation);

        };
    }



        // Ajouter des patients
//        patientRepository.save(
//                new Patient(null, "Amine",
//                        new Date(), false, 2300));
//        patientRepository.save(
//                new Patient(null, "Mohammed",
//                        new Date(), false, 1205));
//        patientRepository.save(
//                new Patient(null, "Youssef",
//                        new Date(), false, 4110));
//        patientRepository.save(
//                new Patient(null, "Ibrahim",
//                        new Date(), true, 5021));

//        // Consulter tous les patients
//        patientRepository.findAll().forEach(patient -> {
//            System.out.println(patient.toString());
//        });
//
//        // Consulter un patient
//        System.out.println("____________________");
//        Patient patient = patientRepository.findById(Long.valueOf(1)).get();
//        System.out.println("patient : "+patient.getNom());
//
//        // Chercher des patients
//        System.out.println("____________________");
//        List<Patient> patients = patientRepository.findByNomContains("m");
//        patients.forEach(p -> {
//            System.out.println(p.getId()+" : "+p.getNom());
//        });
//        System.out.println("____________________");
//        List<Patient> patientList = patientRepository.search("%o%");
//        patientList.forEach(p -> {
//            System.out.println(p.toString());
//        });
//        System.out.println("____________________");
//        List<Patient> malade = patientRepository.findByMalade(true);
//        malade.forEach(p -> {
//            System.out.println(p.getId()+" : "+p.getNom());
//        });
//        System.out.println("____________________");
//        List<Patient> patients1 = patientRepository.searchByScore(2500);
//        patients1.forEach(p -> {
//            System.out.println(p.getId()+" : "+p.getNom());
//        });

}
