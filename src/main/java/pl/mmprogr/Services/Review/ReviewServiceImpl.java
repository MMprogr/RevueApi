package pl.mmprogr.Services.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmprogr.Models.Review.Review;
import pl.mmprogr.Repositories.Review.ReviewRepo;

import java.util.List;

/**
 * Created by ggere on 22.06.2017.
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public Review findById(Integer id) {
        return reviewRepo.findOne(id);
    }

    @Override
    public List<Review> findAll() {
        return (List<Review>) reviewRepo.findAll();
    }

    @Override
    public void add(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void delete(Integer id) {
        reviewRepo.delete(id);
    }
}