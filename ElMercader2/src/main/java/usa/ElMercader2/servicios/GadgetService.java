/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader2.servicios;

import usa.ElMercader2.modelo.Gadget;
import usa.ElMercader2.repositorios.GadgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class GadgetService {

    @Autowired
    private GadgetRepository repo;

    public List<Gadget> getAll(){
        return repo.getAll();
    }
    
    public Gadget save(Gadget prod){
        return repo.save(prod);
    }
    
    public void delete(Integer id){
        Optional<Gadget> og = repo.getById(id);
        if (og.isPresent()){
            repo.delete(og.get());
        }
    }
    
    public Gadget update(Gadget prod){
        Optional<Gadget> og = repo.getById(prod.getId());
        if (og.isPresent()){
            Gadget act = og.get();
            //validacion para no actualizar datos nulos o vacios
            if (prod.getBrand() != null && prod.getBrand().length() > 0) {
                act.setBrand(prod.getBrand());
            }
            if (prod.getCategory() != null && prod.getCategory().length() > 0) {
                act.setCategory(prod.getCategory());
            }  
            if (prod.getName() != null && prod.getName().length() > 0) {
                act.setName(prod.getName());
            }            
            if (prod.getDescription() != null && prod.getDescription().length() > 0) {
                act.setDescription(prod.getDescription());
            }
            //aqui
            if (prod.getPrice() != null && prod.getPrice() > 0) {
                act.setPrice(prod.getPrice());
            }
            if (prod.getAvailability() != null) {
                act.setAvailability(prod.getAvailability());
            }   
            if (prod.getQuantity() != null && prod.getQuantity() > 0) {
                act.setQuantity(prod.getQuantity());
            }
            if (prod.getPhotography() != null && prod.getPhotography().length() > 0) {
                act.setPhotography(prod.getPhotography());
            }            
            
            return repo.save(act);
        }
        return prod;
    }
    
}
