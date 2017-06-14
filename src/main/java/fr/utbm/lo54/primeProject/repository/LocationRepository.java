package fr.utbm.lo54.primeProject.repository;

import fr.utbm.lo54.primeProject.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by victo on 14/06/2017.
 */
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
