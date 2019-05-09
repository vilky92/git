package angular.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import angular.dto.MessageDTO;
import angular.dto.PatchStylo;
import angular.model.Stylo;
import angular.service.StyloService;

@RestController
@RequestMapping("/stylo")
@CrossOrigin(value = "*")
public class StyloController {
	
	@Autowired
	private StyloService stylos;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getStylo(@PathVariable long id) {
		if (id == 0) {
			return new ResponseEntity<String>("vous n'avez pas de stylo", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Stylo>>(stylos.getStylo(id), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllStylo() {

		return new ResponseEntity<List<Stylo>>(stylos.getAllStylo(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> postStylo(@RequestBody Stylo stylo) {
		if (stylo.getColor().isEmpty()) {
			return new ResponseEntity<String>("Veuillez renseigner le champ \"couleur\"", HttpStatus.NOT_FOUND);
		}
		
		if (stylo.getNumber() == 0) {
			return new ResponseEntity<String>("Veuillez renseigner le champ \"nombre\"", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Stylo>(stylos.createStylo(stylo), HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/color/{id}")
	public ResponseEntity<?> patchColorStylo(@PathVariable long id, @RequestBody PatchStylo stylo) {
		if (stylo.getColor().isEmpty()) {
			return new ResponseEntity<String>("Veuillez remplir le champ \"couleur\"", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Stylo>(stylos.patchColor(id, stylo), HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/number/{id}")
	public ResponseEntity<?> patchNumberStylo(@PathVariable long id, @RequestBody PatchStylo stylo) {
		if (stylo.getNumber() == 0) {
			return new ResponseEntity<String>("Veuillez remplir le champ \"nombre\"", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Stylo>(stylos.patchNumber(id, stylo), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<?> putStylo(@PathVariable long id, @RequestBody Stylo stylo) {
		if (stylo.getColor().isEmpty()) {
			return new ResponseEntity<String>("Veuillez renseigner le champ \"couleur\"", HttpStatus.NOT_FOUND);
		}
		
		if (stylo.getNumber() == 0) {
			return new ResponseEntity<String>("Veuillez renseigner le champ \"nombre\"", HttpStatus.NOT_FOUND);
		}
		if (id == 0) {
			return new ResponseEntity<String>("Votre stylo n'éxiste pas", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Stylo>(stylos.putStylo(stylo), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStylo(@PathVariable long id) {
		return new ResponseEntity<MessageDTO>(stylos.deleteStylo(id), HttpStatus.ACCEPTED);
	}
}
