package net.holosen.dto.product;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ColorDto {
    private Long id;
    private String name;
    private String hex;
}
