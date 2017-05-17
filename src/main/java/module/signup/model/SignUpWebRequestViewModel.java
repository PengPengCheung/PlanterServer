package module.signup.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/4/2.
 */

//{"userName":"20131003723","userPassword":"12345678","Rank":1}
public class SignUpWebRequestViewModel {


    @JsonProperty(Resource.KEY.KEY_NAME)
    private String userName;

    @JsonProperty(Resource.KEY.KEY_PASSWORD)
    private String userPassword;

    @JsonProperty(Resource.KEY.KEY_ROLE)
    private int role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
