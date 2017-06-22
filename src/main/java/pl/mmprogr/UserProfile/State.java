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

    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");

    private String state;



}
