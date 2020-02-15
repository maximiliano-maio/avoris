package com.example.exercise.repositories;

import java.util.List;

import com.example.exercise.entities.Product;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductRepository {

    @Select("SELECT * FROM product")
    public List<Product> findAll();

    @Select("SELECT * FROM product WHERE price BETWEEN #{lowerPrice} AND #{biggerPrice}")
    public List<Product> findByPriceBiggerThan(int price);

    @Select("SELECT * FROM product WHERE price < #{price} ")
    public List<Product> findByPriceLowerThan(int price);

    @Select("SELECT * FROM product WHERE category like '%#{category}%'")
    public List<Product> findByCategory(String category);

    @Select("SELECT * FROM product WHERE id = #{id}")
    public Product findById(Long id);

    @Select("SELECT * FROM product WHERE id = #{id}")
    public Product findBy();
    



    // For Authorized users only:

    @Delete("DELETE FROM product WHERE id = #{id}")
    public void deleteById(Long id);

    @Update("UPDATE product SET product_name = #{productName}, color = #{color}, size = #{size}, price = #{price}, currency_id = {currency}")
    public int update(Product product);

    @Insert("INSERT INTO product(product_name, color, size, price, currency) VALUES (#{productName}, #{color}, #{size}, #{price}, #{currency})")
    public int insert(Product product);
    
}