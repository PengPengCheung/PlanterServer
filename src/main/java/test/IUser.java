package test;

import java.util.List;

/**
 * Created by peng on 2017/3/10.
 */
public interface IUser {
    User selectUserById(int id);
    List<User> selectUsers(String name);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
