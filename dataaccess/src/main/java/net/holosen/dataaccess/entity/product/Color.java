package net.holosen.dataaccess.entity.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colors")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String name;

    @Column(length = 8)
    private String hex;

    @OneToMany(mappedBy = "color")
    private List<ProductColor> productColors;
}
