package pl.mmprogr.Services.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmprogr.Models.User.User;
import pl.mmprogr.Repositories.User.UserRepo;

/**
 * Created by ggere on 27.03.2017.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
