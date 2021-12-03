/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader2.repositorios;

import usa.ElMercader2.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ElMercader2.repositorios.crud.CrudUserRepository;

/**
 *
 * @author DELL
 */
@Repository
public class UserRepository {

    @Autowired
    private CrudUserRepository repo;

    public List<User> getAll() {
        return repo.findAll();
    }

    public Optional<User> getById(Integer id) {
        return repo.getById(id);
    }

    public User save(User usuario) {
        return repo.save(usuario);
    }
    
    public void delete(User usuario){
        repo.delete(usuario);
    }
    
    // Metodo para consulta de email puntual
    public Optional<User> getByEmail(String email){
        return repo.findByEmail(email);
    }       

    // Metodo para consulta de combinacion email-password
    public Optional<User> getByEmailAndPassword(String email, String password){
        return repo.findByEmailandPassword(email, password);
    }   
    
}
