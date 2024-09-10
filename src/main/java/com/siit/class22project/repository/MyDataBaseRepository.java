package com.siit.class22project.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyDataBaseRepository {
    public String getDataFromRepository() {
        return "this is data from the database";
    }
}
