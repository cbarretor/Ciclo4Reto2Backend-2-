/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader2.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ElMercader2.modelo.Gadget;
import java.util.List;
import java.util.Optional;
import usa.ElMercader2.repositorios.crud.CrudGadgetRepository;

/**
 *
 * @author DELL
 */
@Repository
public class GadgetRepository {
    
    @Autowired
    private CrudGadgetRepository repo;
    
    public List<Gadget> getAll(){
        return repo.findAll();
    }
    
    public Optional<Gadget> getById(Integer id){
        return repo.getById(id);
    }
    
    public Gadget save(Gadget producto){
        return repo.save(producto);
    }
    
    public void delete(Gadget producto){
        repo.delete(producto);
    }
    
}
