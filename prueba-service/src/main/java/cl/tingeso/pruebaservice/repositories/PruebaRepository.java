package cl.tingeso.pruebaservice.repositories;

import cl.tingeso.pruebaservice.entities.PruebaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PruebaRepository extends JpaRepository<PruebaEntity, Long> {
    //encontrar pruebas por rut
    @Query("SELECT p FROM PruebaEntity p WHERE p.rut = :rut")
    List<PruebaEntity> findPruebasByRut(@Param("rut") String rut);

    //encontrar pruebas por fecha
    @Query("SELECT p FROM PruebaEntity p WHERE p.fecha = :fecha")
    List<PruebaEntity> findPruebasByFecha(@Param("fecha") String fecha);

    //encontrar prueba por rut y fecha
    @Query("SELECT p FROM PruebaEntity p WHERE p.rut = :rut AND p.fecha = :fecha")
    List<PruebaEntity> findPruebaByRutFecha(@Param("rut") String rut, @Param("fecha") String fecha);
}
