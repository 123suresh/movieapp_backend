package movie.com.example.movie.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import movie.com.example.movie.dto.UserReq;
import movie.com.example.movie.dto.UserRes;
import movie.com.example.movie.entity.User;
import movie.com.example.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> saveUser(@Valid @RequestBody UserReq userReq){
        return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(userReq));
    }

    @GetMapping
    public ResponseEntity<List<UserRes>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PutMapping("{userName}")
    public ResponseEntity<UserRes> updateUserByUserName(@PathVariable String userName, @Valid @RequestBody UserReq userReq){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserByUserName(userName, userReq));
    }
}
