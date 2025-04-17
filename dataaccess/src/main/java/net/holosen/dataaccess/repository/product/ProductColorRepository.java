package net.holosen.dataaccess.repository.product;

import net.holosen.dataaccess.entity.product.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {
}
