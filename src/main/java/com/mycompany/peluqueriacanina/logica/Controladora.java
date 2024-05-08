package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascot, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMascot);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atenEsp);
        mascota.setRaza(raza);
        mascota.setObservaciones(observaciones);
        mascota.setUnDuenioM(duenio);
        
        controlPersis.guardar(duenio,mascota);
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascota();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota buscarMascota(int num_cliente) {
        return controlPersis.buscaMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco,  String nombreMascot, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        
        masco.setNombre(nombreMascot);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setRaza(raza);
        
        controlPersis.modificarMasctora(masco);
        
        //Seteo valores dueño
        Duenio duenio = this.buscarDuenio(masco.getUnDuenioM().getId_duenio());
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(nombreDuenio);
        
        //Llamar al modificar dueño
        this.modificarDuenio(duenio);
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
    
}
