package net.holosen.dto.product.mapping;

import net.holosen.dataaccess.entity.product.Product;
import net.holosen.dataaccess.entity.product.ProductColor;
import net.holosen.dto.product.ColorDto;
import net.holosen.dto.product.ProductDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {
    private final ModelMapper mapper;

    @Autowired
    public ProductMapper(ModelMapper mapper) {
        this.mapper = mapper;

        this.mapper.addMappings(new PropertyMap<Product, ProductDto>() {
            @Override
            protected void configure() {
                using(convertPCtoCDto()).map(source.getProductColors()).setColors(null);
            }
        });
    }

    public ProductDto map(Product product) {
        return this.mapper.map(product, ProductDto.class);
    }

    public Product map(ProductDto dto) {
        return this.mapper.map(dto, Product.class);
    }


    private Converter<List<ProductColor>, List<ColorDto>> convertPCtoCDto() {
        return c -> c.getSource() == null ? null :
                c.getSource().stream().map(x ->
                        mapper.map(x.getColor(), ColorDto.class)
                ).toList();
    }
}
