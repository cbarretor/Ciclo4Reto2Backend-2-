package usa.ElMercader2;

import usa.ElMercader2.modelo.User;
import usa.ElMercader2.repositorios.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackages={"usa.ElMercader2"})

public class ElMercader2Application {
    
    @Autowired
    private UserRepository repoUser; 

	public static void main(String[] args) {
		SpringApplication.run(ElMercader2Application.class, args);
	}
        
    @Bean
    ApplicationRunner applicationRunner(){
        return args -> {
            System.out.println("APLICACIÓN INICIADA!.");
            List<User> ur = repoUser.getAll();
            System.out.println("Usuarios: " + ur.size());
        };
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

}

