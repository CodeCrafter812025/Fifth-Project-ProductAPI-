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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String SKU;

    @Column(nullable = false, length = 1000)
    private String brand;

    @Column(length = 1200)
    private String model;

    @Column(name = "amount")
    private Long price;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductColor> productColors;
}
