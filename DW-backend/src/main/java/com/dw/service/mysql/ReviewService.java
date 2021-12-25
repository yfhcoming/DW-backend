package com.dw.service.mysql;


import com.dw.dao.mysql.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    public List getreview(String id) {
        List list=reviewRepository.getreview(id);
        return list;
    }
}
