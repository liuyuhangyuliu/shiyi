package service;

import pojo.User;

public interface UserService {
    User SelectUser(String username, String password);
    boolean SelectUserByUsername(String username);
    int InsertUser(String username,String password);

    User SelectUserByUid(String uid);

    void UpdateCover(String coverSrc,String uid);

}
