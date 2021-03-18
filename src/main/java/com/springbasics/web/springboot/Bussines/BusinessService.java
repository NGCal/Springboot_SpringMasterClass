package com.springbasics.web.springboot.Bussines;

import com.springbasics.web.springboot.Data.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    @Autowired
    DataService dAO;

    public String getDAO() {
        return dAO.retrieveData();
    }
}
