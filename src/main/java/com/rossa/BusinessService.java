package com.rossa;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class BusinessService {

    @Scheduled(fixedDelay = 1000)
    public Integer scheduleFixedDelayTask() {
//        System.out.println(
//                "Fixed delay task - " + System.currentTimeMillis() / 3000);
        return 3;
    }

    public Integer multipleSomething(Integer value) {
        return value * 4;
    }
}
