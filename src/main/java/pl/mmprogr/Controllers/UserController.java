package pl.mmprogr.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mmprogr.Models.User.User;
import pl.mmprogr.Services.User.UserService;

import java.util.List;

/**
 * Created by ggere on 10.05.2017.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUsers() {
        List<User> users = userService.findAll();
        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("not found anyone user", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUserById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("user with id = " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }


}
