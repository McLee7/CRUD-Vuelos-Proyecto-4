package com.turnero.vuelos.services;

import com.turnero.vuelos.models.Vuelo;
import com.turnero.vuelos.repositories.VueloRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VueloService {

    private final VueloRepository repo;

    public VueloService(VueloRepository repo) {
        this.repo = repo;
    }

    public List<Vuelo> filtrarVuelos(String empresa, String lugarLlegada, String fechaSalida) {
        return repo.findAll().stream()
                .filter(v -> empresa == null || v.getEmpresa().equalsIgnoreCase(empresa))
                .filter(v -> lugarLlegada == null || v.getLugarLlegada().equalsIgnoreCase(lugarLlegada))
                .filter(v -> fechaSalida == null || v.getFechaSalida().equals(LocalDate.parse(fechaSalida)))
                .collect(Collectors.toList());
    }

    public Vuelo obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public Vuelo crearVuelo(Vuelo vuelo) {
        return repo.save(vuelo);
    }

    public Vuelo actualizarVuelo(int id, Vuelo vuelo) {
        return repo.update(id, vuelo);
    }

    public boolean eliminarVuelo(int id) {
        return repo.delete(id);
    }
}
