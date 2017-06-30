package pl.mmprogr.Services.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmprogr.Models.User.User;
import pl.mmprogr.Repositories.User.UserRepo;

import java.util.List;

/**
 * Created by ggere on 27.03.2017.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findById(Integer id) {
        return userRepo.findOne(id);
    }

}
