package pl.mmprogr.Services.Comment;

import org.springframework.stereotype.Service;
import pl.mmprogr.Models.Comment.Comment;

import java.util.List;

/**
 * Created by ggere on 27.06.2017.
 */
@Service
public interface CommentService {
    Comment findById(Integer id);
    List<Comment> findAll();
    void add(Comment comment);
    void delete(Integer id);
}
