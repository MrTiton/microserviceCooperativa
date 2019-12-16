package com.titon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.titon.entities.Cooperativa;
import com.titon.entities.ResponseModel;
import com.titon.repository.CooperativaRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cooperativas")
public class CooperativaService {
	
	@Autowired
	private CooperativaRepository cooperativaRepository;
	
	@PostMapping
	public @ResponseBody ResponseModel save (@RequestBody Cooperativa cooperativa) {
		try {
			this.cooperativaRepository.save(cooperativa);
			return new ResponseModel(1, "Registrada com sucesso");
			
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	@PutMapping
	public @ResponseBody ResponseModel update (@RequestBody Cooperativa cooperativa) {
		try {
			
			this.cooperativaRepository.save(cooperativa);
			return new ResponseModel(1, "Registrada com sucesso");
			
		} catch (Exception e) {
			return new ResponseModel(0, "Registrada com sucesso");
		}
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseModel delete (@PathVariable("id") Long id) {
		try {
			this.cooperativaRepository.deleteById(id);
			return new ResponseModel(1, "Registro excluido com sucesso");
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
    @GetMapping
    public @ResponseBody
    List<Cooperativa> findAll(){
        return this.cooperativaRepository.findAll();
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Cooperativa> findById (@PathVariable("id") Long id){
		Optional<Cooperativa> cooperativa = this.cooperativaRepository.findById(id);
		
		if(cooperativa == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(cooperativa.get());
		}
	}
	
}
