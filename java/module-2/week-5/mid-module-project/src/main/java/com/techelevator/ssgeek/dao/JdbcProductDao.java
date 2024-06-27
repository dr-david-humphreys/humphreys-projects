package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Product getProductById(int productId) {
        String sql = "SELECT name product_id, name, description, price, image_name FROM product WHERE product_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
        if (results.next()) {
            return mapRowToProduct(results);
        }
        return null;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT product_id, name, description, price, image_name FROM product ORDER BY product_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            products.add(mapRowToProduct(results));
        }
        return products;
    }

    @Override
    public List<Product> getProductsWithNoSales() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.product_id, p.name, p.description, p.price, p.image_name " +
                "FROM product p " +
                "JOIN line_item l ON p.product_id = l.product_id " +
                "JOIN sale s ON l.sale_id = s.sale_id " +
                "WHERE l.product_id IS NULL " +
                "ORDER BY p.product_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            products.add(mapRowToProduct(results));
        }
        return products;
    }

    @Override
    public Product createProduct(Product newProduct) {
        String sql = "INSERT INTO product (name, description, price, image_name) VALUES (?, ?, ?, ?) RETURNING product_id";
        int newId = jdbcTemplate.queryForObject(sql, int.class, newProduct.getName(), newProduct.getDescription(), newProduct.getPrice(), newProduct.getImageName());
        newProduct.setProductId(newId);
        return newProduct;
    }

    @Override
    public Product updateProduct(Product updatedProduct) {
        String sql = "UPDATE product SET name = ?, description = ?, price = ?, image_name = ? WHERE product_id = ?";
        jdbcTemplate.update(sql, updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getPrice(), updatedProduct.getImageName(), updatedProduct.getProductId());
        return updatedProduct;
    }

    @Override
    public int deleteProductById(int productId) {
        String sql = "DELETE FROM product WHERE product_id = ?";
        return jdbcTemplate.update(sql, productId);
    }

    private Product mapRowToProduct(SqlRowSet rs) {
        Product product = new Product();
        product.setProductId(rs.getInt("product_id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setImageName(rs.getString("image_name"));
        return product;
    }
}
