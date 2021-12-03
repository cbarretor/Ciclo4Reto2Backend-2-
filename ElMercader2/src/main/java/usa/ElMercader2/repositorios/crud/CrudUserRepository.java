/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader2.repositorios.crud;

import usa.ElMercader2.modelo.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author DELL
 */
public interface CrudUserRepository extends MongoRepository<User, Integer> {
    
    //@Query("{email: {&lte: ?0}}")
    //@Query(value = "Select e from Client e Where e.email = ?1)
    public Optional<User> findByEmail(String email);    
       
    @Query("{$and : [{email: {$lte: ?0}},{password: {$lte: ?1}}]}")
    public Optional<User> findByEmailandPassword(String email, String password);    
    
    @Query("{id: ?0}")
    public Optional<User> getById(Integer id);    
    
}
