package net.holosen.app.controller.panel;

import jakarta.servlet.http.HttpServletRequest;
import net.holosen.app.anotation.CheckPermission;
import net.holosen.app.filter.JwtFilter;
import net.holosen.app.model.APIResponse;
import net.holosen.app.model.enums.APIStatus;
import net.holosen.dto.product.ProductDto;
import net.holosen.dto.user.PermissionDto;
import net.holosen.dto.user.UserDto;
import net.holosen.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/panel/product")
public class ProductPanelController {

    private final ProductService productService;

    @Autowired
    public ProductPanelController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    @CheckPermission("add_product")
    public APIResponse<ProductDto> add(@RequestBody ProductDto productDto, HttpServletRequest request) {
        try {
            return APIResponse.<ProductDto>builder()
                    .data(productService.create(productDto))
                    .status(APIStatus.Success)
                    .build();
        } catch (Exception e) {
            return APIResponse.<ProductDto>builder()
                    .message(e.getMessage())
                    .status(APIStatus.Error)
                    .build();
        }
    }
}
