package com.siit.class22project.repository;

import com.siit.class22project.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductJdbcRepository {

    public List<Product> getAllProducts() {
    List<Product> productList = new ArrayList<>();
        Connection connection = getConnection();
        String selectSql = "SELECT * FROM products";

        try  {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            // TBD map result set to a list of products

        }
        catch (Exception e) {

        }
        return productList;
    }

    private Connection getConnection() {
        try (Connection con = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/myshop", "postgres", "mypassword")) {
            return con;
        }
        catch (Exception e) {
            System.out.println("connection error");
        }
        return null;
    }

}
