package angular;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import angular.model.Stylo;
import angular.repository.StyloRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Repository {
	
	@Autowired
	private StyloRepository stylos;
	
	@Before
	public void reset() {
		stylos.deleteAll();
	}
	
	@Test
	public void addStylo() {
		Stylo blue = new Stylo("bleu", 10);
		stylos.save(blue);
		
		assertEquals(stylos.count(), 1);
	}
	
	@Test
	public void restrictedColor() {
		Stylo black = new Stylo ("123456789123456789123", 50);
		stylos.save(black);
		
		assertEquals(stylos.count(), 0);
	}
	
	@Test
	public void restrictedNumber() {
		Stylo black = new Stylo ("black", 101);
		stylos.save(black);
		
		assertEquals(stylos.count(), 0);
	}
	
	@Test
	public void deleteStylo() {
		Stylo blue = new Stylo("bleu", 10);
		stylos.save(blue);
		stylos.delete(blue);
		
		assertEquals(stylos.count(), 0);
	}
	
	@Test
	public void updateStylo() {
		Stylo blue = new Stylo("bleu", 10);
		stylos.save(blue);
		blue.setColor("red");
		
		assertTrue("ok", blue.getColor() == "red");
	}

}
