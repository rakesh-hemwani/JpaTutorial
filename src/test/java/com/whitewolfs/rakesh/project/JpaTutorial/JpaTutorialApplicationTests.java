package com.whitewolfs.rakesh.project.JpaTutorial;

import com.whitewolfs.rakesh.project.JpaTutorial.entities.ProductEntity;
import com.whitewolfs.rakesh.project.JpaTutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(23.45))
				.quantity(4)
				.build();

		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
		List<ProductEntity> productEntities = productRepository.findAll();
		System.out.println(productEntities);
	}
	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("Nestle",BigDecimal.valueOf(12.4));
		productEntity.ifPresent(System.out::println);
	}
}
