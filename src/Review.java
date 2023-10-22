// class for the review object that users can leave on meals
public class Review {
    // reference to the user that left the review
    private final String reviewerUserName;
    // rating out of 10
    private final int rating;
    // the text of the review
    private final String text;

    // constructor
    public Review(String reviewerUserName, int rating, String text) {
        this.reviewerUserName = reviewerUserName;
        this.rating = rating;
        this.text = text;
    }

    // getters
    public String getReviewerUserName() {
        return reviewerUserName;
    }

    public int getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }
}
