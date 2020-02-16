package com.example.exercise.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.example.exercise.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate template; 

    public List<Product> findAll(){
        String query = "SELECT id, product_name, category, color, size, price, currency FROM productdb.product";
        List<Product> products = template.query(query,
            (result,rowNum)->new Product(result.getLong("id") ,result.getString("product_name"),result.getString("category"), result.getString("size"), result.getInt("price"), result.getString("currency"), result.getString("color") ));
        
        return products;
    };

    public Product findById(Long id) {
        String query = "SELECT * FROM productdb.product WHERE id = ?";
        Product product = template.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
        return product;
    };

    public List<Product> findByCategory(String category) {
        return findAll().stream().filter(s -> s.getCategory().equals(category)).collect(Collectors.toList());
    }

    public void deleteById(Long id){
        String query = "DELETE FROM productdb.product WHERE id = ?";
        template.update(query, id);
    };

    public int save(Product product){
        String query = "INSERT INTO productdb.product(product_name,category, color, size, price, currency) VALUES (?,?,?, ?, ?, ?)";
        return template.update(query, product.getProductName(), product.getCategory(), product.getColor(), product.getSize(), product.getPrice(), product.getCurrency());
    };
    
}