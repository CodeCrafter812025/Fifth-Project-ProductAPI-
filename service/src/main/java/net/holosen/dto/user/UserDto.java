package net.holosen.dto.user;

import jakarta.persistence.*;
import lombok.*;
import net.holosen.dataaccess.entity.user.Role;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String mobile;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private LocalDateTime registerDate;
    private Boolean enable = true;
    private Set<RoleDto> roles;
}
