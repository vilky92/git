package angular.service;

import java.util.List;
import java.util.Optional;

import angular.dto.MessageDTO;
import angular.dto.PatchStylo;
import angular.model.Stylo;


public interface StyloService {
	
	public Optional<Stylo> getStylo(long id);
	public Stylo createStylo(Stylo stylo);
	public Stylo updateStylo(Stylo stylo);
	public MessageDTO deleteStylo(long id);
	public Stylo patchColor (long id, PatchStylo stylo);
	public Stylo patchNumber (long id, PatchStylo stylo);
	public Stylo putStylo (Stylo stylo);
	public List<Stylo> getAllStylo();
	
}
