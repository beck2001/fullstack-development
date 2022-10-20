package kz.iitu.insurancecrud.controller;

import kz.iitu.insurancecrud.model.User;
import kz.iitu.insurancecrud.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) throws URISyntaxException {
        User createdUser = userRepository.save(user);
        return ResponseEntity.created(new URI("/users" + createdUser.getId())).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody User user) {
        User currentUser = userRepository.findById(id).orElseThrow(RuntimeException::new);
        currentUser.setUsername(user.getUsername());
        currentUser.setFullName(user.getFullName());
        currentUser.setEmail(user.getEmail());

        return ResponseEntity.ok(currentUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
