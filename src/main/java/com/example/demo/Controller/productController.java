package com.example.demo.Controller;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.productModel;


@RestController
@RequestMapping("/product")
public class productController {
	
    private List<productModel> productList = new ArrayList<>();
    
    //AddProduct
    @PostMapping("/add")
    public String addProduct(@RequestBody productModel product) {
    	productList.add(product);
    	return "Product added successfully";
    }
    
    //list product
    @GetMapping("/list")
    public List<productModel> getProducts(){
    	return productList;
    }
    
    
    //Update product
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody productModel newProduct) {
    	for(productModel product : productList) {
    		if(product.getId()==id) {
    			product.setName(newProduct.getName());
    			product.setPrice(newProduct.getPrice());
    			product.setQty(newProduct.getQty());
    			return "Product updated successfully";
    		}
    	}
    	return "Product not found";
    }
	
    //delete product 
    
    @DeleteMapping("/delete/{id}")
    
    public String deleteProduct(@PathVariable int id) {
    	
    	for(productModel product : productList) {
    		if(product.getId()==id) {
    			productList.remove(product);
    			return "Product Deleted";
    		}
    	}
    	return "Product not found";
    }

  
	
}
