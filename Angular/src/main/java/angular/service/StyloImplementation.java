package angular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import angular.dto.MessageDTO;
import angular.dto.PatchStylo;
import angular.model.Stylo;
import angular.repository.StyloRepository;

@Service
public class StyloImplementation implements StyloService{

	@Autowired
	private StyloRepository stylos;
	
	@Override
	public Optional<Stylo> getStylo(long id) {

		return stylos.findById(id);
	}

	@Override
	public Stylo createStylo(Stylo stylo) {
		Stylo pen = new Stylo(stylo.getColor(), stylo.getNumber());
		return stylos.save(pen);
	}

	@Override
	public Stylo updateStylo(Stylo stylo) {
		Stylo pen = new Stylo();
		if (!stylo.getColor().isEmpty()) {
			pen.setColor(stylo.getColor());
		}
		if (stylo.getNumber() != 0) {
			pen.setNumber(stylo.getNumber());
		}
		return stylos.save(pen);
	}

	@Override
	public MessageDTO deleteStylo(long id) {
		MessageDTO message = new MessageDTO();
		stylos.deleteById(id);
		message.setMessage("votre stylo a bien été suprimé");
		return message;
	}

	@Override
	public Stylo patchColor(long id, PatchStylo stylo) {
		Optional<Stylo> pen = stylos.findById(id);
		pen.get().setColor(stylo.getColor());
		return stylos.save(pen.get());
	}

	@Override
	public Stylo patchNumber(long id, PatchStylo stylo) {
		Optional<Stylo> pen = stylos.findById(id);
		pen.get().setNumber(stylo.getNumber());
		return stylos.save(pen.get());
	}

	@Override
	public Stylo putStylo(Stylo stylo) {
		Optional<Stylo> pen = stylos.findById(stylo.getId());
		pen.get().setColor(stylo.getColor());
		pen.get().setNumber(stylo.getNumber());
		return stylos.save(pen.get());
	}

	@Override
	public List<Stylo> getAllStylo() {
		
		return stylos.findAll();
	}




}
