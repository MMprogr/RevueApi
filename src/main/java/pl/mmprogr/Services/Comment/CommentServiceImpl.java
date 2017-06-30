package pl.mmprogr.Services.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmprogr.Models.Comment.Comment;
import pl.mmprogr.Repositories.Comment.CommentRepo;

import java.util.List;

/**
 * Created by ggere on 27.06.2017.
 */
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;

    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment findById(Integer id) {
        return commentRepo.findOne(id);
    }

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) commentRepo.findAll();
    }

    @Override
    public void add(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void delete(Integer id) {
        commentRepo.delete(id);
    }
}
