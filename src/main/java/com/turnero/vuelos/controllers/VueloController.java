package com.turnero.vuelos.controllers;

import com.turnero.vuelos.dtos.VueloDTO;
import com.turnero.vuelos.models.Vuelo;
import com.turnero.vuelos.services.VueloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService service;

    public VueloController(VueloService service) {
        this.service = service;
    }

    @GetMapping
    public List<VueloDTO> obtenerVuelos(
            @RequestParam(required = false) String empresa,
            @RequestParam(required = false) String lugarLlegada,
            @RequestParam(required = false) String fechaSalida
    ) {
        return service.filtrarVuelos(empresa, lugarLlegada, fechaSalida)
                .stream()
                .map(v -> new VueloDTO(
                        v.getId(), v.getNombreVuelo(), v.getEmpresa(),
                        v.getLugarSalida(), v.getLugarLlegada(),
                        v.getFechaSalida(), v.getFechaLlegada()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Vuelo crear(@RequestBody Vuelo vuelo) {
        return service.crearVuelo(vuelo);
    }

    @PutMapping("/{id}")
    public Vuelo actualizar(@PathVariable int id, @RequestBody Vuelo vuelo) {
        return service.actualizarVuelo(id, vuelo);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return service.eliminarVuelo(id);
    }
}
