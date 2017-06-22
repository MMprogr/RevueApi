package pl.mmprogr.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mmprogr.Models.User.User;
import pl.mmprogr.Services.User.UserService;

/**
 * Created by ggere on 10.05.2017.
 */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
