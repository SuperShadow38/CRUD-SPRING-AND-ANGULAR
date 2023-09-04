package ec.sasf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.sasf.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.nombre_de_usuario LIKE CONCAT('%',:keyword,'%') OR u.apellido_de_usuario LIKE CONCAT('%',:keyword,'%') OR u.email_usuarios LIKE CONCAT('%',:keyword,'%')")
List<User> searchByKeyword(@Param("keyword") String keyword);

}
