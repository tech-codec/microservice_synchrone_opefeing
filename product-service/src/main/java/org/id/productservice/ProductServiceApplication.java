package org.id.productservice;

import org.id.productservice.dao.ProductRepository;
import org.id.productservice.entities.Product;
import org.id.productservice.services.ProductServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	ArrayList<Product> listProducts = new ArrayList<Product>();
	Product p1 = new Product(null, "Iphone 9", 78900, "il est très rapide et a une très bonne camera");
	Product p2 = new Product(null, "Imprimente 3D", 98900, "il est très simple et facile a déplacée");
	Product p3 = new Product(null, "HP 7 génération", 480900, "il est très rapide et a une très bonne camera et une très bonne mémoire graphique");

	ArrayList<Product> saveProduct(){
		listProducts.add(p1);
		listProducts.add(p2);
		listProducts.add(p3);
		listProducts.stream().forEach(p->{
			productRepository.save(p);
		});

		System.out.println(listProducts);
		return listProducts;
	}

	@Override
	public void run(String... args) throws Exception {
		saveProduct();
	}
}
