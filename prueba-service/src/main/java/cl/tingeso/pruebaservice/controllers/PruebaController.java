package cl.tingeso.pruebaservice.controllers;

import cl.tingeso.pruebaservice.entities.PruebaEntity;
import cl.tingeso.pruebaservice.services.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pruebas")
public class PruebaController {
    @Autowired
    PruebaService pruebaService;

    @GetMapping
    public ResponseEntity<List<PruebaEntity>> getAllPruebas(){
        List<PruebaEntity> pruebas = pruebaService.obtenerPruebas();

        if(pruebas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pruebas);
    }

    @GetMapping("/por-rut/{rut}")
    public ResponseEntity<List<PruebaEntity>> getPruebasByRut(@PathVariable("rut") String rut){
        List<PruebaEntity> pruebas = pruebaService.obtenerPruebasPorRut(rut);

        if(pruebas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pruebas);
    }

    @GetMapping("/por-fecha/{fecha}")
    public ResponseEntity<List<PruebaEntity>> getPruebasByFecha(@PathVariable("fecha") String fecha){
        List<PruebaEntity> pruebas = pruebaService.obtenerPruebasPorFecha(fecha);

        if(pruebas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pruebas);
    }

    @GetMapping("/buscar/{rut}/{fecha}")
    public ResponseEntity<PruebaEntity> getPruebaEspecifica(@PathVariable("rut") String rut, @PathVariable("fecha") String fecha){
        PruebaEntity prueba = pruebaService.obtenerPruebaEspecifica(rut, fecha);

        if(prueba == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prueba);
    }

    @PostMapping("/new")
    public String createPrueba(@RequestParam("rut") String rut, @RequestParam("fecha") String fecha, @RequestParam("puntaje") String puntaje){
        pruebaService.guardarPrueba(rut, fecha, puntaje);
        return "redirect:/pruebas/new";
    }

    @GetMapping("/delete")
    public void deletePruebas(){
        pruebaService.borrarPruebas();
    }
}
