package cl.tingeso.estudianteservice.services;

import cl.tingeso.estudianteservice.entities.EstudianteEntity;
import cl.tingeso.estudianteservice.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public void guardarEstudiante(String rut, String apellidos, String nombres, String nacimiento,
                                  String tipo_colegio, String nombre_colegio, String egreso){

        EstudianteEntity estudianteEntity = new EstudianteEntity();

        estudianteEntity.setRut(rut);
        estudianteEntity.setApellidos(apellidos);
        estudianteEntity.setNombres(nombres);
        estudianteEntity.setNacimiento(nacimiento);
        estudianteEntity.setTipo_colegio(tipo_colegio);
        estudianteEntity.setNombre_colegio(nombre_colegio);
        estudianteEntity.setEgreso(egreso);

        estudianteRepository.save(estudianteEntity);
    }

    public void borrarEstudiantes(){ estudianteRepository.deleteAll(); }

    public List<EstudianteEntity> obtenerEstudiantes(){
        return estudianteRepository.findAll();
    }

    public EstudianteEntity obtenerEstudiantePorRut(String rut){
        return this.estudianteRepository.findEstudianteByRut(rut);
    }

}
