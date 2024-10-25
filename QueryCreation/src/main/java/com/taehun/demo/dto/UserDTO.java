package com.taehun.demo.dto;

import com.taehun.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String status;
    private Boolean active;
        
    
    // User 엔티티를 UserDTO로 변환하는 정적 메서드
    public static UserDTO fromEntity(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getStatus(),
                user.getActive()  // active 필드 추가
        );
    }

    // UserDTO를 User 엔티티로 변환하는 메서드
    public User toEntity() {
        User user = new User();
        user.setFirstname(this.firstname);
        user.setLastname(this.lastname);
        user.setEmail(this.email);
        user.setStatus(this.status);
        user.setActive(this.active);  // active 필드 추가
        return user;
    }
}
