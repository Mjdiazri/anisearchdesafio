package com.example.pinguiapp.anisearchdesafio.servicios;

import com.example.pinguiapp.anisearchdesafio.modelos.DatosAnimes;
import com.example.pinguiapp.anisearchdesafio.modelos.DatosGenerales;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Metodos {
    private Scanner respuestaUsuario = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private final String URL_BASE = "https://api.jikan.moe/v4/anime";

    public void mostrarMenu() {
        System.out.println("Bienvenidos a AniSearch");
        var json = consumoApi.obtenerDatos(URL_BASE);
        //System.out.println(json);
        var datos = convierteDatos.obtenerDatos(json, DatosGenerales.class);
        System.out.println(datos);

        //Animes mejor calificadas
        System.out.println("Los 3 animes mejor calificados son: ");
        datos.animes().stream()
                .sorted(Comparator.comparing(DatosAnimes::calificacion).reversed())
                .limit(3)
                .forEach(System.out::println);
        //Animes peor calificados
        System.out.println("Los animes peor calificados son: ");
        datos.animes().stream()
                .sorted(Comparator.comparing(DatosAnimes::calificacion))
                .limit(3)
                .map(a -> a.titulo().toUpperCase())
                .forEach(System.out::println);


        //Buscar anime por nombre
        System.out.println("Busca tu anime!!! Escribe el nombre del anime que deseas validar");
        var usuarioAnime = respuestaUsuario.nextLine();
        json = consumoApi.obtenerDatos(URL_BASE + "?q=" + usuarioAnime.replace(" ", "+"));
        var datosBusqueda = convierteDatos.obtenerDatos(json, DatosGenerales.class);
        Optional<DatosAnimes> animeBuscado = datosBusqueda.animes().stream()
                .filter(a -> a.titulo().toUpperCase().contains(usuarioAnime.toUpperCase()))
                .findFirst();
        if(animeBuscado.isPresent()){
            System.out.println("Anime encontrado");
            System.out.println(animeBuscado.get());
        } else {
            System.out.println("Anime no encontrado");
        }


        //Generar estadisticas
        DoubleSummaryStatistics est = datos.animes().stream()
                .collect(Collectors.summarizingDouble(DatosAnimes::calificacion));
        System.out.println("Promedio calificaciones: " + est.getAverage());
        System.out.println("Calificacion mas alta: " + est.getMax());
        System.out.println("Calificacion mas baja: " + est.getMin());
        System.out.println("Total animes calificados: " + est.getCount() );
    }
}
