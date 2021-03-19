package com.springbasics.web.springboot.Bussines;

import com.springbasics.web.springboot.Data.DataService;
import com.springbasics.web.springboot.Data.DataService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService2 {
    @Autowired
    DataService2 dAO;

    public String getDAO() {
        return dAO.retrieveData();
    }

    public int getDAOLength() {

        return dAO.retrieveData().length();
    }
}
