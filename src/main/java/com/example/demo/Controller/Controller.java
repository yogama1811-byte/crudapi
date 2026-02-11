package com.example.demo.Controller;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Model;


@RestController
@RequestMapping("/product")
public class Controller {
	
    private List<Model> productlist = new ArrayList<>();
    
    //AddProduct
    @PostMapping("/add")
    public String addproduct(@RequestBody Model product) {
    	productlist.add(product);
    	return "Product add successfully";
    }
    
    //list product
    @GetMapping("/list")
    public List<Model> getProducts(){
    	return productlist;
    }
    
    
    //Update product
    @PutMapping("/update/{id}")
    public String updateproduct(@PathVariable int id, @RequestBody Model newproduct) {
    	for(Model product : productlist) {
    		if(product.getId()==id) {
    			product.setName(newproduct.getName());
    			product.setPrice(newproduct.getPrice());
    			product.setQty(newproduct.getQty());
    			return "Product updated successfully";
    		}
    	}
    	return "Product not found";
    }
	
    //delete product 
    
    @DeleteMapping("/delete/{id}")
    
    public String deleteProduct(@PathVariable int id) {
    	
    	for(Model product : productlist) {
    		if(product.getId()==id) {
    			productlist.remove(product);
    			return "Product Deleteed";
    		}
    	}
    	return "Product not found";
    }

  
	
}
