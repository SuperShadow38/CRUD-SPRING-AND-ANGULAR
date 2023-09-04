package ec.sasf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.service.UserService;
import ec.sasf.exception.BadRequestError;
import ec.sasf.model.User;


@RestController
@RequestMapping("/usuarios")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userService.getUserId(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PostMapping("/register")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        if (user == null) {
            throw new BadRequestError("User data is missing");
        }

        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> editUser(@PathVariable Long id, @RequestBody User updatedUser) {
        if (updatedUser == null) {
            throw new BadRequestError("Updated user data is missing");
        }

        User user = userService.getUserId(id);
        if (user != null) {
            updatedUser.setId(id);
            User savedUser = userService.saveUser(updatedUser);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    // @PutMapping("/{id}/desactivar")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // public ResponseEntity<?> desactivateUser(@PathVariable Long id) {
    //     User user = userService.getUserId(id);
        
    //     // if (user != null) {
    //     //     user.setEstadoUsuario(User.EstadoUsuario.INACTIVO);
    //     //     userService.saveUser(user); 
            
    //     //     return ResponseEntity.ok().build();
    //     // } else {
    //     //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    //     // }
    // }
    


    @GetMapping("/search")
    public List<User> searchUsersByKeyword(@RequestParam("keyword") String keyword) {
        return userService.searchUsersByKeyword(keyword);
    }
}

