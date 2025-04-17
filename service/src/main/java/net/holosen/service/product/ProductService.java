package net.holosen.service.product;

import net.holosen.dataaccess.entity.product.Product;
import net.holosen.dataaccess.repository.product.ColorRepository;
import net.holosen.dataaccess.repository.product.ProductColorRepository;
import net.holosen.dataaccess.repository.product.ProductRepository;
import net.holosen.dto.product.ProductDto;
import net.holosen.dto.product.mapping.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ColorRepository colorRepository;
    private final ProductColorRepository productColorRepository;
    private final ProductMapper mapper;

    @Autowired
    public ProductService(ProductRepository repository,
                          ColorRepository colorRepository,
                          ProductColorRepository productColorRepository,
                          ProductMapper mapper) {
        this.repository = repository;
        this.colorRepository = colorRepository;
        this.productColorRepository = productColorRepository;
        this.mapper = mapper;
    }

    public List<ProductDto> readAll() {
        List<Product> all = repository.findAll();
        return all.stream().map(mapper::map).toList();
    }

    public ProductDto read(Long id) {
        Product product = repository.findById(id).orElseThrow();
        return mapper.map(product);
    }


    public ProductDto readBySKU(String sku) {
        Product product = repository.findBySKUEqualsIgnoreCase(sku).orElseThrow();
        return mapper.map(product);
    }

    public List<ProductDto> readByBrand(String brand) {
        return repository.findByBrandLike(brand).stream().map(mapper::map).toList();
    }

    public ProductDto create(ProductDto dto) throws Exception {
        modelValidation(dto);
        dto.setId(null);
        Product save = repository.save(mapper.map(dto));
        return mapper.map(save);
    }

    public ProductDto update(ProductDto product) throws Exception {
        modelValidation(product);
        if (product.getId() == null || product.getId() <= 0) {
            throw new Exception("Please enter id");
        }
        ProductDto oldData = read(product.getId());
        oldData.setBrand(product.getBrand());
        oldData.setModel(product.getModel());
        oldData.setSKU(product.getSKU());
        oldData.setPrice(product.getPrice());
        Product save = repository.save(mapper.map(oldData));
        return mapper.map(save);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    //region private methods
    private static void modelValidation(ProductDto product) throws Exception {
        if (product == null) {
            throw new Exception("Product is null");
        }

        if (product.getBrand() == null || product.getBrand().isEmpty()) {
            throw new Exception("Please enter brand");
        }

        if (product.getModel() == null || product.getModel().isEmpty()) {
            throw new Exception("Please enter model");
        }

        if (product.getSKU() == null || product.getSKU().isEmpty()) {
            throw new Exception("Please enter SKU");
        }

        if (product.getPrice() == null || product.getPrice() < 0) {
            throw new Exception("Please enter price");
        }
    }

    //endregion
}
