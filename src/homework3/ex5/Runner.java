package homework3.ex5;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {
    private static final int COMPARE_EQUALS_VALUE = 0;

    public static void main(String[] args) {
        
        Comparator<Review> reviewComparator = (review1, review2) -> {
            int compareByLikes;
            int compareByTime;
            int compareByID;
            compareByLikes = review2.getLikeQuantity().compareTo(review1.getLikeQuantity());
            compareByTime = review2.getTimeOfReview().compareTo(review1.getTimeOfReview());
            compareByID = review2.getReviewID().compareTo(review1.getReviewID());

            if (compareByLikes == COMPARE_EQUALS_VALUE && compareByTime == COMPARE_EQUALS_VALUE) {
                return compareByID;
            } else if (compareByLikes == COMPARE_EQUALS_VALUE) {
                return compareByTime;
            }
            return compareByLikes;
        };

        ArrayList<Review> reviews = getReviews();
        System.out.println(reviews);
        System.out.println("-----------------");
        reviews.sort(reviewComparator);
        System.out.println(reviews);
    }

    /**
     * добавление тестовых отзывов в лист
     */
    private static ArrayList<Review> getReviews() {
        Review firstReview = new Review(1, "отличный товар", 200, LocalDateTime.of(
            2024, Month.JANUARY, 25, 13, 34));
        Review secondReview = new Review(2, "так себе товар", 100, LocalDateTime.of(
                2024, Month.JANUARY, 25, 16, 37));
        Review thirdReview = new Review(3, "плохой товар", 100, LocalDateTime.of(
                2024, Month.JANUARY, 25, 13, 37));
        Review fourthReview = new Review(4, "плохой товар", 100, LocalDateTime.of(
                2024, Month.JANUARY, 25, 13, 37));

        return new ArrayList<>(List.of(firstReview, secondReview, thirdReview, fourthReview));
    }
}
