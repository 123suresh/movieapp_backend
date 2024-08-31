package movie.com.example.movie.service;

import movie.com.example.movie.dto.UserReq;
import movie.com.example.movie.dto.UserRes;
import movie.com.example.movie.entity.User;

import java.util.List;

public interface UserService {
    public String saveUser(UserReq userReq);
    public List<UserRes> getAllUsers();
    public UserRes updateUserByUserName(String userName, UserReq userReq);
}
