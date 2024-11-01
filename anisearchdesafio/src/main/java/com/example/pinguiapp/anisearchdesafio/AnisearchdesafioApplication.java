package com.example.pinguiapp.anisearchdesafio;

import com.example.pinguiapp.anisearchdesafio.servicios.ConsumoApi;
import com.example.pinguiapp.anisearchdesafio.servicios.Metodos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnisearchdesafioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AnisearchdesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Metodos metodo = new Metodos();
		metodo.mostrarMenu();
	}
}

