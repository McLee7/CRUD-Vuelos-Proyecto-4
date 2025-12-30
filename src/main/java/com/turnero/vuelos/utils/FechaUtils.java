package com.turnero.vuelos.utils;

import java.time.LocalDate;

public class FechaUtils {

    public static boolean fechasValidas(LocalDate salida, LocalDate llegada) {
        return !salida.isAfter(llegada);
    }
}
