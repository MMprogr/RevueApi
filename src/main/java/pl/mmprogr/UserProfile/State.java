package pl.mmprogr.UserProfile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by ggere on 28.03.2017.
 */
@Getter
@AllArgsConstructor
@ToString
public enum State {

    ACTIVE("active"),
    INACTIVE("inactive");

    private String state;



}
