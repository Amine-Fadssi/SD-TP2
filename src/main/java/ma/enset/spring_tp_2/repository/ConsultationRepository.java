package ma.enset.spring_tp_2.repository;

import ma.enset.spring_tp_2.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
