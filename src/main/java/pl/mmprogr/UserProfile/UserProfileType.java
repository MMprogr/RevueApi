package pl.mmprogr.UserProfile;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by ggere on 28.03.2017.
 */
@Getter
@AllArgsConstructor
public enum UserProfileType {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String userProfileType;

}
