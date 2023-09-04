package ec.sasf.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ec.sasf.model.Loggers;
import ec.sasf.model.LoggersRoles;
import ec.sasf.model.User;
import ec.sasf.repository.LoggersRepository;
import ec.sasf.repository.LoggersRolesRepository;
import ec.sasf.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final LoggersRepository loggersRepository;
    private final LoggersRolesRepository loggersRolesRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, LoggersRepository loggersRepository, LoggersRolesRepository loggersRolesRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loggersRepository = loggersRepository;
        this.loggersRolesRepository = loggersRolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User saveUser(User user) {
        // Aplicar el cifrado a la contraseña antes de guardarla
        user.setClave(passwordEncoder.encode(user.getClave()));
    
        // Guardar el usuario en la tabla users
        User savedUser = userRepository.save(user);
    
        // Crear el objeto Loggers
        Loggers loggers = new Loggers();
        loggers.setUsuario(user.getUsuario());
        loggers.setEmail_usuarios(user.getEmail_usuarios());
        loggers.setClave(user.getClave());
        loggers.setNombre_de_usuario(user.getNombre_de_usuario());
        loggers.setApellido_de_usuario(user.getApellido_de_usuario());
        
        loggersRepository.save(loggers);
    
        // Asignar el rol por defecto "CLIENTE"
        LoggersRoles loggersRoles = new LoggersRoles();
        loggersRoles.setUsuario(user.getUsuario());
        loggersRoles.setRol("CLIENTE");  // Rol por defecto
        loggersRoles.setGrantedDate(LocalDateTime.now());
        loggersRoles.setUser(loggers);
        loggersRolesRepository.save(loggersRoles);
    
        return savedUser;
    }
    

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> searchUsersByKeyword(String keyword) {
        return userRepository.searchByKeyword(keyword);
    }
}
