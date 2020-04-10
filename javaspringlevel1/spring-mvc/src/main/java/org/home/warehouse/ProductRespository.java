package org.home.warehouse;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRespository {

    private final AtomicInteger identity = new AtomicInteger(0);

    private final List<Product> products =  new ArrayList<>();

    public ProductRespository() {
        insert(new Product(1,"Appl", 75));
        insert(new Product(2,"Orange",130));
    }

    public void insert(Product product){
        products.add(product);
        product.setId(identity.incrementAndGet());
    }

    public List<Product> getAllProducts(){
        return Collections.unmodifiableList(products);
    }

//    public Product getProductByID(int id){
//        products.
//    }
//
//    public  Product getProductByName(String title){
//
//    }

}
