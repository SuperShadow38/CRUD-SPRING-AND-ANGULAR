package ec.sasf.repository;

import org.springframework.data.repository.CrudRepository;

import ec.sasf.model.Loggers;

public interface UserSecurityRepository extends CrudRepository<Loggers, String> {
    
}
