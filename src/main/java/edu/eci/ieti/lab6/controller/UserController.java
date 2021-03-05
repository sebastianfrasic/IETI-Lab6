package edu.eci.ieti.lab6.controller;

import edu.eci.ieti.lab6.entities.Task;
import edu.eci.ieti.lab6.entities.User;
import edu.eci.ieti.lab6.services.ServiceException;
import edu.eci.ieti.lab6.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    @Qualifier("userServiceStub")
    private UserService userService;


    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        try {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable String id) {
        try {
            return new ResponseEntity<>(userService.getById(id), HttpStatus.ACCEPTED);
        } catch (ServiceException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            userService.create(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServiceException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.update(id, user), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> removeUser(@PathVariable String id) {
        try {
            userService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/users/{id}/tasks")
    public ResponseEntity<?> addTask(@PathVariable String id, @RequestBody Task task) {
        try {
            userService.addTask(id, task);
            return new ResponseEntity<>("Task added succesfully", HttpStatus.CREATED);
        } catch (ServiceException e) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
