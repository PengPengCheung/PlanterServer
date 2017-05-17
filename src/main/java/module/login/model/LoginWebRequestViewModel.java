package module.login.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Resource;

/**
 * Created by peng on 2017/3/28.
 */
public class LoginWebRequestViewModel {


    @JsonProperty(Resource.KEY.KEY_NAME)
    private String name = null;

    @JsonProperty(Resource.KEY.KEY_PASSWORD)
    private String password = null;

    @JsonProperty(Resource.KEY.KEY_ROLE)
    private int status = -1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
