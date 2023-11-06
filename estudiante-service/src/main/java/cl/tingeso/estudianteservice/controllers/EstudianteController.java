package cl.tingeso.estudianteservice.controllers;

import cl.tingeso.estudianteservice.entities.EstudianteEntity;
import cl.tingeso.estudianteservice.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<EstudianteEntity>> getAllEstudiantes(){
        List<EstudianteEntity> estudiantes = estudianteService.obtenerEstudiantes();

        if(estudiantes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<EstudianteEntity> getEstudiante(@PathVariable("rut") String rut){
        EstudianteEntity estudiante = estudianteService.obtenerEstudiantePorRut(rut);

        if(estudiante == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiante);
    }

    @PostMapping("/new")
    public String createEmpleado(@RequestParam("rut") String rut, @RequestParam("apellidos") String apellidos,
                               @RequestParam("nombres") String nombres, @RequestParam("nacimiento") String nacimiento,
                               @RequestParam("tipo_colegio") String tipo_colegio, @RequestParam("nombre_colegio") String nombre_colegio,
                               @RequestParam("egreso") String egreso){

        estudianteService.guardarEstudiante(rut, apellidos, nombres, nacimiento, tipo_colegio, nombre_colegio, egreso);
        return "redirect:/estudiantes/new";
    }

    @GetMapping("/delete")
    public void deleteEmpleados(){
        estudianteService.borrarEstudiantes();
    }
}
