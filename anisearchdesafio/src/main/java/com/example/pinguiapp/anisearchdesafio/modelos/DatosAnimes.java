package com.example.pinguiapp.anisearchdesafio.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAnimes(
        @JsonAlias("title") String titulo,
        @JsonAlias("type") String tipoFormato,
        @JsonAlias("episodes") Integer cantidadEpisodios,
        @JsonAlias("score") Double calificacion,
        @JsonAlias("genres") List<DatosClasificacion> clasificacion,
        @JsonAlias("year") Integer añoLanzamiento ) {
}
