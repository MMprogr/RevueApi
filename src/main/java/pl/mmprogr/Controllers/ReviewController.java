package pl.mmprogr.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mmprogr.Models.Review.Review;
import pl.mmprogr.Services.Review.ReviewService;

import java.util.List;

/**
 * Created by ggere on 22.06.2017.
 */
@RestController
@RequestMapping(value = "/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getReview(@PathVariable Integer id) {
        Review review = reviewService.findById(id);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("can not found review with id = " + id, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity addReview(@RequestBody Review review) {
        reviewService.add(review);
        return new ResponseEntity<>("created review", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteReview(@PathVariable Integer id) {
        Review review = reviewService.findById(id);
        if (review != null) {
            reviewService.delete(id);
            return new ResponseEntity<>("deleted review", HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>("not found review with id = " + id, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllReviews() {
        List<Review> reviews = reviewService.findAll();
        if (reviews != null) {
            return new ResponseEntity<>(reviews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("can not found reviews", HttpStatus.NOT_FOUND);
        }
    }
}
