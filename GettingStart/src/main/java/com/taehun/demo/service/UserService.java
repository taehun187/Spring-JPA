package com.taehun.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.taehun.demo.dto.UserDTO;
import com.taehun.demo.entity.User;
import com.taehun.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional // 트랜잭션이 필요한 메서드
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserDTO.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserDTO.fromEntity(savedUser);
    }

    @Transactional // 트랜잭션이 필요한 메서드
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        existingUser.setName(userDTO.getName());
        existingUser.setLastname(userDTO.getLastname());
        existingUser.setEmail(userDTO.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return UserDTO.fromEntity(updatedUser);
    }

    @Transactional // 트랜잭션이 필요한 메서드
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        userRepository.delete(user);
    }

    @Transactional // 트랜잭션이 필요한 메서드
    public void deleteUserByEmail(String email) {
        long deletedCount = userRepository.deleteByEmail(email);
        if (deletedCount == 0) {
            throw new NoSuchElementException("No user found with email: " + email);
        }
    }

    @Transactional // 트랜잭션이 필요한 메서드
    public List<UserDTO> removeUsersByEmail(String email) {
        List<User> removedUsers = userRepository.removeByEmail(email);
        if (removedUsers.isEmpty()) {
            throw new NoSuchElementException("No users found with email: " + email);
        }
        return removedUsers.stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // 조회하는 메서드는 트랜잭션 필요 없음
    public List<UserDTO> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
        return UserDTO.fromEntity(user);
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(NoSuchElementException::new);
        return UserDTO.fromEntity(user);
    }
}