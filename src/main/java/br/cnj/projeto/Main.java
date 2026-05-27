package br.cnj.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.cnj.projeto.util.CasoJudicial;

@SpringBootApplication
public class Main implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		System.out.println(caso.finalizarCusto(100, "RJ", 2024));
	}

}
