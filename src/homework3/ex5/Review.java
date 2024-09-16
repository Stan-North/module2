package homework3.ex5;

import java.time.LocalDateTime;

public class Review {
    private Integer reviewID;
    private String reviewText;
    private Integer likeQuantity;
    private LocalDateTime timeOfReview;

    public Review(Integer reviewID, String reviewText, Integer likeQuantity, LocalDateTime timeOfReview) {
        this.reviewID = reviewID;
        this.reviewText = reviewText;
        this.likeQuantity = likeQuantity;
        this.timeOfReview = timeOfReview;
    }

    public Integer getReviewID() {
        return reviewID;
    }

    public String getReviewText() {
        return reviewText;
    }

    public Integer getLikeQuantity() {
        return likeQuantity;
    }

    public LocalDateTime getTimeOfReview() {
        return timeOfReview;
    }

    @Override
    public String toString() {
        return "\n Review{" +
                "reviewID=" + reviewID +
                ", reviewText='" + reviewText + '\'' +
                ", likeQuantity=" + likeQuantity +
                ", timeOfReview=" + timeOfReview +
                '}';
    }
}
