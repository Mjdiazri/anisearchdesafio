package com.example.pinguiapp.anisearchdesafio.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosClasificacion(
        @JsonAlias("name") String tipologia ) {
}
