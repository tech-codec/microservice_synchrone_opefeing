package org.id.billingservice.services;

import org.id.billingservice.customerrest.CustomerRestClient;
import org.id.billingservice.customerrest.ProductRestClient;
import org.id.billingservice.dao.BillingRepository;
import org.id.billingservice.dao.ProductItemRepository;
import org.id.billingservice.dto.RequestBilling;
import org.id.billingservice.dto.ResponseBilling;
import org.id.billingservice.entities.Billing;
import org.id.billingservice.entities.Customer;
import org.id.billingservice.entities.Product;
import org.id.billingservice.entities.ProductItem;
import org.id.billingservice.mappers.BillingMapper;
import org.id.billingservice.mappers.ProductItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BillingServiceImpl implements BillingServiceI {
    private BillingRepository billingRepository;
    private ProductItemRepository productItemRepository;
    private ProductItemMapper productItemMapper;
    private BillingMapper billingMapper;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillingServiceImpl(BillingRepository billingRepository, ProductItemRepository productItemRepository, ProductItemMapper productItemMapper, BillingMapper billingMapper, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billingRepository = billingRepository;
        this.productItemRepository = productItemRepository;
        this.productItemMapper = productItemMapper;
        this.billingMapper = billingMapper;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @Override
    public List<ResponseBilling> allBilling() {
        List<Billing> billings = billingRepository.findAll();
        billings.forEach(billing -> {
            getCustomerAndProductByProductItem(billing);
        });
        List<ResponseBilling> responseBillings = billings.stream()
                .map(billing -> billingMapper.billingToResponseBilling(billing))
                .collect(Collectors.toList());
        return responseBillings;
    }

    @Override
    public ResponseBilling showBilling(Long billingId) {
        Billing billing = billingRepository.findById(billingId).orElse(null);
        getCustomerAndProductByProductItem(billing);
        return billingMapper.billingToResponseBilling(billing);
    }

    @Override
    public ResponseBilling createBilling(RequestBilling requestBilling)
    {
        double amout = 0;
        Customer customer = customerRestClient.getCustomer(requestBilling.getCustomerId());
        Billing billing = new Billing();
        List<ProductItem> productItems = requestBilling.getProductItems()
                .stream()
                .map(requestProductItem -> productItemMapper.requestProductItemToProductItem(requestProductItem))
                .collect(Collectors.toList());
        billing.setProductItems(productItems);
        billing.setDate(new Date());
        billing.setCustomerId(requestBilling.getCustomerId());
        for (ProductItem productItem : productItems) {
            amout += productItem.getPrice()*productItem.getQuantity();
            productItem.setBilling(billing);
            productItemRepository.save(productItem);
        }
        billing.setAmount(amout);
        Billing billingSave = billingRepository.save(billing);
        ResponseBilling responseBilling = billingMapper.billingToResponseBilling(billingSave);
        responseBilling.setCustomer(customer);
        return responseBilling;
    }

    @Override
    public void deleteBilling(Long billingId) {
        Billing billing = billingRepository.findById(billingId).orElse(null);
        billing.getProductItems().forEach(productItem -> productItemRepository.delete(productItem));
        billingRepository.delete(billing);
    }

    void getCustomerAndProductByProductItem(Billing billing){
        Customer customer = customerRestClient.getCustomer(billing.getCustomerId());
        billing.setCustomer(customer);
        List<ProductItem> productItems = billing.getProductItems();
        productItems.forEach(productItem ->{
            Product product = productRestClient.getProduct(productItem.getProductId());
            productItem.setProduct(product);
        });
    }
}
