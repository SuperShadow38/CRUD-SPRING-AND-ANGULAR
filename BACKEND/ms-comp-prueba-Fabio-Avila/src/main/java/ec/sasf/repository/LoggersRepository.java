package ec.sasf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.sasf.model.Loggers;

@Repository
public interface LoggersRepository extends JpaRepository<Loggers, String> {
    
}
