package com.openbootcamp.obejercicio3;

import com.openbootcamp.obejercicio3.entity.UserEntity;
import com.openbootcamp.obejercicio3.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObEjercicio3Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObEjercicio3Application.class, args);

		UserRepository repository = context.getBean(UserRepository.class);

		UserEntity entity = new UserEntity(null, "corayako@gmail.com", "password");

		repository.save(entity);

		System.out.println(repository.findAll());
	}

}
