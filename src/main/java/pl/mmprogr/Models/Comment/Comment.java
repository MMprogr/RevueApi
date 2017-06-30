package pl.mmprogr.Models.Comment;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mmprogr.Models.Review.Review;
import pl.mmprogr.Models.User.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by ggere on 27.06.2017.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "content", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String content;

    @Column(name="date", nullable=false)
    private Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "review_id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Review.class)
    private Review review;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = User.class)
    private User user;
}
