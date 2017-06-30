package pl.mmprogr.Models.Review;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mmprogr.Models.Comment.Comment;
import pl.mmprogr.Models.User.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ggere on 22.06.2017.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "backgroundImage", nullable = false)
    private String backgroundImage;

    @Column(name = "content", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name="date", nullable=false)
    private Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = User.class)
    private User user;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Comment.class)
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "review")
    private Set<Comment> comments = new HashSet<>();

}
