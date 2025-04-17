package net.holosen.app.controller;

import jakarta.transaction.Transactional;
import net.holosen.app.model.APIResponse;
import net.holosen.app.model.enums.APIStatus;
import net.holosen.dto.product.ProductDto;
import net.holosen.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//url : http://127.0.0.1:8080/api/product
//url : http://127.0.0.1:8080/api/product/1
//url : http://127.0.0.1:8080/api/product/2

// CRUD => Create, Read, Update, Delete
// Create => POST
// Read   => GET
// Update => PUT
// Delete => Delete

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    //@RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping("")
    public APIResponse<List<ProductDto>> getAll() {
        return APIResponse.<List<ProductDto>>builder()
                .data(service.readAll())
                .status(APIStatus.Success)
                .build();
    }

    @GetMapping("{id}")
    public APIResponse<ProductDto> getById(
            @PathVariable(value = "id") Long id,
            @RequestParam(required = false) Integer page) {
        return APIResponse.<ProductDto>builder()
                .data(service.read(id))
                .status(APIStatus.Success)
                .build();
    }

    @Transactional
    @PostMapping("")
    public APIResponse<ProductDto> add(@RequestBody ProductDto product) {
        try {
            return APIResponse.<ProductDto>builder()
                    .data(service.create(product))
                    .status(APIStatus.Success)
                    .build();
        } catch (Exception e) {
            return APIResponse.<ProductDto>builder()
                    .data(null)
                    .message(e.getMessage())
                    .status(APIStatus.Error)
                    .build();
        }
    }


    //url : http://127.0.0.1:8080/api/product/sku/AI16

    @GetMapping("sku/{sku}")
    public APIResponse<ProductDto> getBySKU(
            @PathVariable(value = "sku") String sku) {
        return APIResponse.<ProductDto>builder()
                .data(service.readBySKU(sku))
                .status(APIStatus.Success)
                .build();
    }

    @GetMapping("brand")
    public APIResponse<List<ProductDto>> getByBrand(
            @RequestParam("s") String brand) {
        return APIResponse.<List<ProductDto>>builder()
                .data(service.readByBrand(brand))
                .status(APIStatus.Success)
                .build();
    }
}
