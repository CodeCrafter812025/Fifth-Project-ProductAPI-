package net.holosen.dataaccess.repository.product;

import net.holosen.dataaccess.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySKUEqualsIgnoreCase(String sku);

    //@Query(value = "select * from products as p where p.brand like CONCAT('%', :brand, '%')", nativeQuery = true)
    @Query("from Product where brand like CONCAT('%', :brand, '%')")
    List<Product> findByBrandLike(@Param("brand") String brand);

}
