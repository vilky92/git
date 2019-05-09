package angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import angular.model.Stylo;

public interface StyloRepository extends JpaRepository<Stylo, Long>{

	Stylo findByColor(String string);

}
