package model;

/**
 * Created by peng on 2017/3/18.
 */
public class DataResponse<T> {

    private int error_code;
    private String reason;
    private T data;

    public DataResponse(int error_code, String reason){
        this.error_code = error_code;
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
