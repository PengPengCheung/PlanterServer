package test;

import java.util.List;

/**
 * Created by peng on 2017/3/18.
 */
public class Info<T> {

    List<T> data;

    public void setData(List<T> d){
        data = d;
    }

    public List<T> getData(){
        return data;
    }
}
