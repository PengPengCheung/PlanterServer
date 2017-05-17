package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by peng on 2017/3/23.
 */
public class SimpleResponse {

    @JsonProperty()
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
