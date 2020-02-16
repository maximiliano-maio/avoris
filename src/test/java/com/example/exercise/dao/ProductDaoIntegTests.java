package com.example.exercise.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.example.exercise.entities.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ProductDaoIntegTests {

    @Autowired
    private Dao<Product> dao;

    @Test
    public void whenFindAll_thenReturnListProducts(){
        List<Product> products = dao.findAll();
        assertThat(products).hasSize(8);
    }

    @Test
    public void whenFindByCategory_thenReturnListProducts(){
        List<Product> products = dao.findByCategory("sport");
        assertThat(products).hasSize(2);
    }

    @Test
    public void whenDelete_thenSmallerListProducts(){
        List<Product> productsInitial = dao.findAll();
        dao.deleteById(1L);
        List<Product> productsFinal = dao.findAll();
        assertThat(productsInitial.size() - productsFinal.size()).isEqualTo(1);
    }

    @Test
    public void whenSaveProduct_thenProductStored(){
        List<Product> productsInitial = dao.findAll();
        
        Product product = new Product(20L,"testProduct","test", "small", 10, "USD", "red");
        dao.save(product);
        
        List<Product> productsFinal = dao.findAll();
        assertThat(productsInitial.size() - productsFinal.size()).isEqualTo(-1);
    }

    @Test
    public void whenFindByValidId_thenReturnProduct(){
        Product product = new Product(21L,"testProduct","test", "small", 10, "USD", "red");
        int status = dao.save(product);
        if (status >= 1) {
            List<Product> storedProduct = dao.findByCategory("test");
            assertThat(storedProduct.get(0).getColor()).isEqualTo("red");
        }
    }

    
}