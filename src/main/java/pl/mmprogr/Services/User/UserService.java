package pl.mmprogr.Services.User;

import org.springframework.stereotype.Service;
import pl.mmprogr.Models.User.User;

/**
 * Created by ggere on 27.03.2017.
 */
@Service
public interface UserService {
    User findByUsername(String u);
}
