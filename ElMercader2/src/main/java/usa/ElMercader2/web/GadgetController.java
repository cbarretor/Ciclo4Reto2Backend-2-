/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader2.web;

import usa.ElMercader2.modelo.Gadget;
import usa.ElMercader2.servicios.GadgetService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api/gadget")
@CrossOrigin
public class GadgetController {

    @Autowired
    private GadgetService service;

    @GetMapping("/all")
    public List<Gadget> getAll() {
        return service.getAll();
    }

    @PostMapping("/new")
    public ResponseEntity<Gadget> save(@RequestBody Gadget prod) {
        return new ResponseEntity(service.save(prod), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Gadget> update(@RequestBody Gadget prod) {
        return new ResponseEntity(service.update(prod), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
