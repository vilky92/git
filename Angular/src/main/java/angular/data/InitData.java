package angular.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import angular.model.Stylo;
import angular.repository.StyloRepository;

@Component
public class InitData implements CommandLineRunner{

	@Autowired
	private StyloRepository stylos;
	
	@Override
	public void run(String... args) throws Exception {
		if (stylos.count() == 0) {
			Stylo pen = new Stylo("blue", 10);
			stylos.save(pen);
		}
		
	}

}
