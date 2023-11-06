package cl.tingeso.estudianteservice.repositories;

import cl.tingeso.estudianteservice.entities.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, String> {

    //encontrar estudiante por rut
    @Query("SELECT e FROM EstudianteEntity e WHERE e.rut = :rut")
    EstudianteEntity findEstudianteByRut(@Param("rut") String rut);

}
