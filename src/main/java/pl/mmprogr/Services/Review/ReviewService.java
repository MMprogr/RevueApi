package pl.mmprogr.Services.Review;

import org.springframework.stereotype.Service;
import pl.mmprogr.Models.Review.Review;

import java.util.List;

/**
 * Created by ggere on 22.06.2017.
 */
@Service
public interface ReviewService {
     Review findById(Integer id);
     List<Review> findAll();
     void add(Review review);
     void delete(Integer id);
}