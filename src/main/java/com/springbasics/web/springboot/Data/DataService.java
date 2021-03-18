package com.springbasics.web.springboot.Data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {
    public String retrieveData() {
        return "This is Data Service 1";
    }
}
