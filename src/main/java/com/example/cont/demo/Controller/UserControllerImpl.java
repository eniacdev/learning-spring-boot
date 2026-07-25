package com.example.cont.demo.Controller;

import com.example.cont.demo.apipath.ApiPath;
import com.example.cont.demo.dto.UserRequest;
import com.example.cont.demo.dto.UserResponse;
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
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping(ApiPath.CREATE_USER)
    @Override
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest newUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(newUser));
    }

    @DeleteMapping(ApiPath.DELETE_BY_ID)
    @Override
    public ResponseEntity<Boolean> deleteUserById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }

    @GetMapping(ApiPath.FIND_BY_ID)
    @Override
    public ResponseEntity<UserResponse> userFindById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(userService.userFindById(id));
    }

    @PutMapping(ApiPath.UPDATE_BY_ID)
    @Override
    public ResponseEntity<UserResponse> updateUserById(@RequestBody UserRequest user, @PathVariable("id") Integer id){
        return ResponseEntity.ok().body(userService.updateUserById(user, id));
    }

    @GetMapping(ApiPath.FIND_BY_NAME)
    @Override
    public ResponseEntity<List<UserResponse>> findByUserName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(userService.findByUserName(name));
    }

    @GetMapping(ApiPath.FIND_BY_ID_GREATER_THAN)
    @Override
    public ResponseEntity<List<UserResponse>> findByIdGreaterThan(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(userService.findByIdGreaterThan(id));
    }

    @GetMapping(ApiPath.FIND_ALL_BY_ORDER_BY_NAME)
    @Override
    public ResponseEntity<List<UserResponse>> findByOrderByName() {
        return ResponseEntity.ok().body(userService.findByOrderByName());
    }

    @GetMapping(ApiPath.FIND_ALL)
    @Override
    public ResponseEntity<List<UserResponse>> findAllUser() {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.findAllUser());
    }

    @GetMapping(ApiPath.FIND_ALL_USERNAME)
    @Override
    public ResponseEntity<List<String>> findAllUserName() {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.findAllUserName());
    }

}
