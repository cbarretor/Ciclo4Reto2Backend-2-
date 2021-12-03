/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader2.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.ElMercader2.modelo.User;
import usa.ElMercader2.servicios.UserService;


/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    //GET 200
    //POST y PUT 201
    //DELETE 204
    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }
    
    // CONSULTA EMAIL-PASSWORD
    @GetMapping("/{email}/{password}")
    private User getByEmail(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.getByEmailAndPassword(email, password);
    }
    
    // CONSULTA EMAIL
    @GetMapping("/emailexist/{email}")
    private boolean getByEmail(@PathVariable("email") String email) {
        return service.getByEmail(email);
    }      

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> save(@RequestBody User usuario) {
        return new ResponseEntity(service.save(usuario), HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> update(@RequestBody User usuario){
        return new ResponseEntity(service.update(usuario), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
