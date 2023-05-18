package com.microservice.movieratingservice.domain;

import java.util.List;

public class UserRatings {
    private List<Rating> ratingList;

    public UserRatings(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public UserRatings() {

    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
