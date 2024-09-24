package com.siit.class22project.repository;

import com.siit.class22project.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductJdbcRepository {

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String selectSql = "SELECT * FROM products";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSql)) {

            while (resultSet.next()) {
                Product product = mapToProduct(resultSet);
                productList.add(product);
            }
        } catch (Exception e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }

        return productList;
    }

    public Product getProductById(int id) {
        String selectSql = "SELECT * FROM products WHERE id = ?";
        Product product = null;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(selectSql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = mapToProduct(resultSet);
            }

        } catch (Exception e) {
            System.out.println("Error fetching product by ID: " + e.getMessage());
        }

        return product;
    }

    public boolean addProduct(Product product) {
        String insertSql = "INSERT INTO products (name, price, profit) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSql)) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setDouble(3, product.getProfit());
            statement.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        String updateSql = "UPDATE products SET name = ?, price = ?, profit = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(updateSql)) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setDouble(3, product.getProfit());
            statement.setLong(4, product.getId());
            statement.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteProduct(int id) {
        String deleteSql = "DELETE FROM products WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteSql)) {

            statement.setInt(1, id);
            statement.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error deleting product: " + e.getMessage());
            return false;
        }
    }

    private Product mapToProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getDouble("price"));
        product.setProfit(resultSet.getDouble("profit"));
        return product;
    }

    private Connection getConnection() {
        try {
            return DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/myshop", "postgres", "mypassword");
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            return null;
        }
    }
}
