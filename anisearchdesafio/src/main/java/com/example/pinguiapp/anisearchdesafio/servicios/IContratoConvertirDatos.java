package com.example.pinguiapp.anisearchdesafio.servicios;

public interface IContratoConvertirDatos {
     <T> T obtenerDatos(String json, Class <T> clase);
}
