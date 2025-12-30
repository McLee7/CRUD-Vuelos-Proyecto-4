package com.turnero.vuelos.models;

import java.time.LocalDate;

public class Vuelo {

    private Integer id;
    private String nombreVuelo;
    private String empresa;
    private String lugarSalida;
    private String lugarLlegada;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;

    public Vuelo() {}

    public Vuelo(Integer id, String nombreVuelo, String empresa,
                 String lugarSalida, String lugarLlegada,
                 LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.id = id;
        this.nombreVuelo = nombreVuelo;
        this.empresa = empresa;
        this.lugarSalida = lugarSalida;
        this.lugarLlegada = lugarLlegada;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombreVuelo() { return nombreVuelo; }
    public void setNombreVuelo(String nombreVuelo) { this.nombreVuelo = nombreVuelo; }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public String getLugarSalida() { return lugarSalida; }
    public void setLugarSalida(String lugarSalida) { this.lugarSalida = lugarSalida; }

    public String getLugarLlegada() { return lugarLlegada; }
    public void setLugarLlegada(String lugarLlegada) { this.lugarLlegada = lugarLlegada; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }

    public LocalDate getFechaLlegada() { return fechaLlegada; }
    public void setFechaLlegada(LocalDate fechaLlegada) { this.fechaLlegada = fechaLlegada; }
}
