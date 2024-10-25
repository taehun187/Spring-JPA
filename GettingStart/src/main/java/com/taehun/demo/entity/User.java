package com.taehun.demo.entity;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.taehun.demo.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastname;
    private String email; 

    // UserDTO로 변환하는 메서드
    public UserDTO toDTO() {
        UserDTO dto = new UserDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setLastname(this.lastname);
        dto.setEmail(this.email); 
        dto.setCreationDate(this.creationDate);
        dto.setLastModifiedDate(this.lastModifiedDate);
        return dto;
    }

    // UserDTO에서 User로 변환하는 메서드
    public static User fromDTO(UserDTO userDTO) {
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
