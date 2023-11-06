package cl.tingeso.pruebaservice.services;

import cl.tingeso.pruebaservice.entities.PruebaEntity;
import cl.tingeso.pruebaservice.repositories.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaService {
    @Autowired
    PruebaRepository pruebaRepository;

    public void guardarPrueba(String rut, String fecha, String puntaje){
        PruebaEntity prueba = new PruebaEntity();

        prueba.setRut(rut);
        prueba.setFecha(fecha);
        prueba.setPuntaje(puntaje);

        pruebaRepository.save(prueba);
    }

    public void borrarPruebas(){ pruebaRepository.deleteAll(); }

    public List<PruebaEntity> obtenerPruebas(){
        return pruebaRepository.findAll();
    }

    public List<PruebaEntity> obtenerPruebasPorRut(String rut){
        return this.pruebaRepository.findPruebasByRut(rut);
    }

    public List<PruebaEntity> obtenerPruebasPorFecha(String fecha){
        return this.pruebaRepository.findPruebasByFecha(fecha);
    }

    public List<PruebaEntity> obtenerPruebaPorRutFecha(String rut, String fecha){
        return this.pruebaRepository.findPruebaByRutFecha(rut, fecha);
    }
}
