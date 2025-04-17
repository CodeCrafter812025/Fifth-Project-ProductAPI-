package net.holosen.dto.user;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimitedUserDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String token;

    public String fullName() {
        return firstname + " " + lastname;
    }
}
