package org.id.billingservice;

import org.id.billingservice.dao.BillingRepository;
import org.id.billingservice.entities.Billing;
import org.id.billingservice.entities.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication implements CommandLineRunner {
    /*@Autowired
    private BillingRepository billingRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}



	//Billing billing1 = new Billing(null, new Date(), 0, null,null,null);

    @Override
    public void run(String... args) throws Exception {
        /*billingRepository.save(billing1);*/
        System.out.println("Bonjour le mode");
    }
}
