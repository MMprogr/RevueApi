package pl.mmprogr.Repositories.Review;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mmprogr.Models.Review.Review;

/**
 * Created by ggere on 22.06.2017.
 */
@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
}

