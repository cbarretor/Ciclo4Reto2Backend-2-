/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usa.ElMercader2.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author DELL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "gadgets")
public class Gadget {
    
    @Id
    private Integer id;
    private String brand;
    private String category;
    private String name;
    private String description;
    private Double price;
    private Boolean availability = true;
    private Integer quantity;
    private String photography;
    
}
