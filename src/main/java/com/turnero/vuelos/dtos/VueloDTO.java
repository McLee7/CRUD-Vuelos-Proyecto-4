package com.turnero.vuelos.dtos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VueloDTO {

    private Integer id;
    private String nombreVuelo;
    private String empresa;
    private String lugarSalida;
    private String lugarLlegada;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    private long duracionDias;

    public VueloDTO(Integer id, String nombreVuelo, String empresa,
                    String lugarSalida, String lugarLlegada,
                    LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.id = id;
        this.nombreVuelo = nombreVuelo;
        this.empresa = empresa;
        this.lugarSalida = lugarSalida;
        this.lugarLlegada = lugarLlegada;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.duracionDias = ChronoUnit.DAYS.between(fechaSalida, fechaLlegada);
    }

    public Integer getId() { return id; }
    public String getNombreVuelo() { return nombreVuelo; }
    public String getEmpresa() { return empresa; }
    public String getLugarSalida() { return lugarSalida; }
    public String getLugarLlegada() { return lugarLlegada; }
    public LocalDate getFechaSalida() { return fechaSalida; }
    public LocalDate getFechaLlegada() { return fechaLlegada; }
    public long getDuracionDias() { return duracionDias; }
}
