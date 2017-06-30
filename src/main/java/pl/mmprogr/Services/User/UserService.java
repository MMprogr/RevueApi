package pl.mmprogr.Services.User;

import org.springframework.stereotype.Service;
import pl.mmprogr.Models.User.User;

import java.util.List;

/**
 * Created by ggere on 27.03.2017.
 */
@Service
public interface UserService {
    List<User> findAll();
    User findByUsername(String u);
    User findById(Integer id);
}
