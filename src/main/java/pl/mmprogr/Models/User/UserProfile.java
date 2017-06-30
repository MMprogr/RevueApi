package pl.mmprogr.Models.User;

/**
 * Created by ggere on 28.03.2017.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.mmprogr.UserProfile.UserRole;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", length = 15, unique = true, nullable = false)
    private String type = UserRole.USER.getUserRole();
}
