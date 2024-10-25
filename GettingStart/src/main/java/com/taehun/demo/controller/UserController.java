package com.taehun.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taehun.demo.dto.UserDTO;
import com.taehun.demo.entity.User;
import com.taehun.demo.service.UserService;

@RestController 
@RequestMapping("/test/users") 
public class UserController {

    private final UserService userService;

    // UserService를 의존성 주입합니다.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 모든 유저 목록을 가져오는 엔드포인트
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    } 

    // 특정 ID를 가진 유저를 가져오는 엔드포인트
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        try {
            UserDTO user = userService.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // 새로운 유저를 추가하는 엔드포인트
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    // 기존 유저 정보를 업데이트하는 엔드포인트
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        try { 
            UserDTO updatedUser = userService.updateUser(id, userDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (NoSuchElementException e) { 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // 특정 유저를 삭제하는 엔드포인트
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
