package com.tmgreyhat.blog;

import com.tmgreyhat.blog.Repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDataBase(UserRepository repository){

        return  args -> {

            /*User user = new User();

            user.setPassword("pass");
            user.setLast_name("tambo");
            user.setFirst_name("shingi");
            user.setEmail("email@org.com");
            user.setAddress("102 Simon maz");
            user.setUser_name("tango101");

            log.info(" Preloading Data" + repository.save(user));*/
        };
    }


}
