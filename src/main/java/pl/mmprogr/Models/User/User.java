package pl.mmprogr.Models.User;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mmprogr.Models.Comment.Comment;
import pl.mmprogr.Models.Review.Review;
import pl.mmprogr.UserProfile.State;
import pl.mmprogr.UserProfile.UserRole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by ggere on 25.03.2017.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "state", nullable = false)
    private String state = State.ACTIVE.getState();

    @Column(name = "role")
    private UserRole role = UserRole.USER;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Review.class)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Review> reviews = new HashSet<Review>();

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Comment.class)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Review> comments = new HashSet<Review>();
}
