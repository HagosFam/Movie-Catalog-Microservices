package com.microservice.moviecatelogservice.domain;

import java.util.List;
import java.util.PriorityQueue;

public class UserRatings {
    private List<Rating> ratingList;

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
