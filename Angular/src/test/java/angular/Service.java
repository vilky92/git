package angular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import angular.model.Stylo;
import angular.repository.StyloRepository;
import angular.service.StyloService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service {
	
	@Autowired
	StyloService stylos;
	
	@Autowired
	StyloRepository stylosR;
	
	@Before
	public void deleteAll() {
		stylosR.deleteAll();
	}
	
	@Test
	public void createStylo() {
		Stylo pen = new Stylo("black", 50);
		stylos.createStylo(pen);
		
		assertEquals(stylosR.count(), 1);		
	}
	
	@Test
	public void readStylo() {
		Stylo pen = new Stylo("black", 50);
		stylosR.save(pen);
		Optional<Stylo> test = stylos.getStylo(pen.getId());

		assertEquals(test.get().getColor(), pen.getColor());
	}
	
	@Test
	public void updateStylo() {
		Stylo pen = new Stylo("black", 50);
		stylos.createStylo(pen);
		pen.setColor("yellow");
		stylos.updateStylo(pen);

		assertTrue(pen.getColor() == "yellow");
	}
	
	@Test
	public void deleteStylo() {
		Stylo pen = new Stylo("black", 50);
		stylosR.save(pen);
		stylos.deleteStylo(pen.getId());
		
		assertEquals(stylosR.count(), 0);
	}

}
