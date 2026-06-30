package com.example.cont.demo.Controller;

import com.example.cont.demo.apipath.ApiPath;
import com.example.cont.demo.model.User;
import com.example.cont.demo.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserControllerImpl implements IUserController{

    private final IUserService userService;

    public UserControllerImpl(IUserService userService){
        this.userService = userService;
    }

    @Override
    @GetMapping(ApiPath.GET_ALL)
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping(ApiPath.CREATE_USER)
    @Override
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(newUser));
    }

    @DeleteMapping(ApiPath.DELETE_BY_ID)
    @Override
    public ResponseEntity<Boolean> deleteUserById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }

    @GetMapping(ApiPath.FIND_BY_ID)
    @Override
    public ResponseEntity<User> userFindById(@PathVariable("id") Integer id) throws Exception{
        return ResponseEntity.ok().body(userService.userFindById(id));
    }

    @PutMapping(ApiPath.UPDATE_BY_ID)
    @Override
    public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable("id") Integer id) throws Exception{
        return ResponseEntity.ok().body(userService.updateUserById(user, id));
    }

}
