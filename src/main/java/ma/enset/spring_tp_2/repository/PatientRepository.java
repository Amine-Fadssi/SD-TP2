package ma.enset.spring_tp_2.repository;

import ma.enset.spring_tp_2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findByNomContains(String name);
    public List<Patient> findByMalade(boolean b);

    @Query("select p from Patient p where p.nom like :x ")
    public List<Patient> search(@Param("x") String key);

    @Query("select p from Patient p where p.score > :x")
    public List<Patient> searchByScore(@Param("x") double score);
}
