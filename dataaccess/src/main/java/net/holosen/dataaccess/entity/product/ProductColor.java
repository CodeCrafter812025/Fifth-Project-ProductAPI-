package net.holosen.dataaccess.entity.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_color")
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Color color;

    @ManyToOne
    private Product product;

    @Column(columnDefinition = "TEXT")
    private String description;
}
