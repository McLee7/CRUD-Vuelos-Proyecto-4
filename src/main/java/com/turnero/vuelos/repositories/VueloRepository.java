package com.turnero.vuelos.repositories;

import com.turnero.vuelos.models.Vuelo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VueloRepository {

    private final List<Vuelo> vuelos = new ArrayList<>();
    private int nextId = 1;

    public VueloRepository() {
        vuelos.add(new Vuelo(nextId++, "IB001", "Iberia", "Madrid", "Buenos Aires",
                LocalDate.of(2025,3,10), LocalDate.of(2025,3,11)));
        vuelos.add(new Vuelo(nextId++, "TK100", "Turkish", "Istanbul", "New York",
                LocalDate.of(2025,4,5), LocalDate.of(2025,4,5)));
    }

    public List<Vuelo> findAll() {
        return new ArrayList<>(vuelos);
    }

    public Optional<Vuelo> findById(int id) {
        return vuelos.stream().filter(v -> v.getId() == id).findFirst();
    }

    public Vuelo save(Vuelo vuelo) {
        vuelo.setId(nextId++);
        vuelos.add(vuelo);
        return vuelo;
    }

    public Vuelo update(int id, Vuelo vuelo) {
        return findById(id).map(v -> {
            v.setNombreVuelo(vuelo.getNombreVuelo());
            v.setEmpresa(vuelo.getEmpresa());
            v.setLugarSalida(vuelo.getLugarSalida());
            v.setLugarLlegada(vuelo.getLugarLlegada());
            v.setFechaSalida(vuelo.getFechaSalida());
            v.setFechaLlegada(vuelo.getFechaLlegada());
            return v;
        }).orElse(null);
    }

    public boolean delete(int id) {
        return vuelos.removeIf(v -> v.getId() == id);
    }
}
