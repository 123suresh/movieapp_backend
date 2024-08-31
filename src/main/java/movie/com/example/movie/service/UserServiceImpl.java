package movie.com.example.movie.service;

import lombok.extern.slf4j.Slf4j;
import movie.com.example.movie.dto.UserReq;
import movie.com.example.movie.dto.UserRes;
import movie.com.example.movie.entity.User;
import movie.com.example.movie.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public String saveUser(UserReq userReq){
        Optional<User> checkUserExist = userRepository.findByUserName(userReq.getUserName().toLowerCase());
        if(checkUserExist.isPresent()){
            return "User name "+userReq.getUserName()+" already exist";
        }
        User user = User.builder()
                .userName(userReq.getUserName())
                .password(userReq.getPassword())
                .build();
        userRepository.save(user);
        return "User saved successfully";
    }

    public List<UserRes> getAllUsers(){
        List<UserRes> allUsers = userRepository.findAll().stream().map(user->UserRes.builder()
                .userName(user.getUserName())
                .movieList(user.getMovieList())
                .build()
        ).toList();
        return allUsers;
    }

    public UserRes updateUserByUserName(String userName,UserReq userReq){
        Optional<User> user = userRepository.findByUserName(userName);
        if(user.isEmpty()){
            log.error("User not found with username as "+ userReq.getUserName());
        }
        User updateUser = user.get();
        updateUser.setUserName(userReq.getUserName()!=null?userReq.getUserName():updateUser.getUserName());
        updateUser.setPassword(userReq.getPassword()!=null?userReq.getPassword():updateUser.getPassword());
        User newUpdatedUser = userRepository.save(updateUser);
        UserRes userResponse = UserRes.builder()
                .userName(newUpdatedUser.getUserName())
                .build();
        return userResponse;
    }

}
