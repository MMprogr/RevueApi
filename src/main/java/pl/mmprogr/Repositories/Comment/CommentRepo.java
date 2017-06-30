package pl.mmprogr.Repositories.Comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mmprogr.Models.Comment.Comment;

/**
 * Created by ggere on 27.06.2017.
 */
@Repository
public interface CommentRepo extends CrudRepository<Comment, Integer> {
}