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

        EstudianteEntity estudiante = new EstudianteEntity();

        estudiante.setRut(rut);
        estudiante.setApellidos(apellidos);
        estudiante.setNombres(nombres);
        estudiante.setNacimiento(nacimiento);
        estudiante.setTipo_colegio(tipo_colegio);
        estudiante.setNombre_colegio(nombre_colegio);
        estudiante.setEgreso(egreso);

        estudianteRepository.save(estudiante);
    }

    public void borrarEstudiantes(){ estudianteRepository.deleteAll(); }

    public List<EstudianteEntity> obtenerEstudiantes(){
        return estudianteRepository.findAll();
    }

    public EstudianteEntity obtenerEstudiantePorRut(String rut){
        return this.estudianteRepository.findEstudianteByRut(rut);
    }

}
