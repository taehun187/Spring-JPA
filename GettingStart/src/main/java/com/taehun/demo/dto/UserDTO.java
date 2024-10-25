package com.taehun.demo.dto;

import java.time.LocalDateTime;

import com.taehun.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String lastname;
    private String email;  
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;

    // User 엔티티를 UserDTO로 변환하는 정적 메서드
    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastname(user.getLastname());
        dto.setEmail(user.getEmail());  
        dto.setCreationDate(user.getCreationDate());
        dto.setLastModifiedDate(user.getLastModifiedDate());
        return dto;
    }

    // UserDTO를 User 엔티티로 변환하는 정적 메서드
    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());  
        user.setCreationDate(userDTO.getCreationDate());
        user.setLastModifiedDate(userDTO.getLastModifiedDate());
        return user;
    }
}
