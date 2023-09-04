package ec.sasf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.sasf.model.LoggersRoles;
import ec.sasf.model.LoggersRolesId;

@Repository
public interface LoggersRolesRepository extends JpaRepository<LoggersRoles, LoggersRolesId> {
    
}
