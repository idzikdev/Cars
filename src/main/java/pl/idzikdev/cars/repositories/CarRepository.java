package pl.idzikdev.cars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.idzikdev.cars.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {
    String BETWEEN_POWER="SELECT * FROM car " +
            "where power between ?1 and ?2";
    List<Car> findByYear(String year);
    @Query(value = BETWEEN_POWER, nativeQuery = true)
    List<Car> findByBetweenPower(String from,String to);
}
