package pl.mmprogr.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mmprogr.Models.Comment.Comment;
import pl.mmprogr.Services.Comment.CommentService;

import java.util.List;

/**
 * Created by ggere on 27.06.2017.
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getComment(@PathVariable Integer id) {
        Comment Comment = commentService.findById(id);
        if (Comment != null) {
            return new ResponseEntity<>(Comment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("can not found comment with id = " + id, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity addComment(@RequestBody Comment Comment) {
        commentService.add(Comment);
        return new ResponseEntity<>("created comment", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteComment(@PathVariable Integer id) {
        Comment Comment = commentService.findById(id);
        if (Comment != null) {
            commentService.delete(id);
            return new ResponseEntity<>("deleted comment", HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>("not found comment with id = " + id, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllComments() {
        List<Comment> comments = commentService.findAll();
        if (comments != null) {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("can not found comments", HttpStatus.NOT_FOUND);
        }
    }
}

