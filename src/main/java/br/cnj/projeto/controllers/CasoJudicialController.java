package br.cnj.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.cnj.projeto.exceptions.CasoDuplicadoException;
import br.cnj.projeto.services.CasoJudicialService;
import br.cnj.projeto.util.CasoJudicial;

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {

	private final CasoJudicialService service;
	
	@Autowired
	public CasoJudicialController(CasoJudicialService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<CasoJudicial>> consultaTodosOsCasos(){
		List<CasoJudicial> casos = service.consultaTodosOsCasos();
		return ResponseEntity.ok(casos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CasoJudicial> pegarCasoPorId(@PathVariable int id){
		CasoJudicial caso = service.pegarCasoPorId(id);
		return ResponseEntity.ok(caso);
	}
	
	@PostMapping
	public ResponseEntity<CasoJudicial> criarNovoCaso(@RequestBody CasoJudicial novoCaso) throws CasoDuplicadoException{
		if(service.existe(novoCaso)) {
			throw new CasoDuplicadoException("Caso duplicado!");
		}
		CasoJudicial caso = service.criarNovoCaso(novoCaso);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(caso);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CasoJudicial> atualizarCaso(@PathVariable int id, @RequestBody CasoJudicial casoAtualizado)
	{
		CasoJudicial caso = service.atualizarCaso(id, casoAtualizado);
		return ResponseEntity.ok(caso);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCaso(@PathVariable int id){
		service.deletarCaso(id);
		return ResponseEntity.noContent().build();
	}
}
