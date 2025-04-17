package net.holosen.app.controller;

import net.holosen.app.model.APIResponse;
import net.holosen.app.model.enums.APIStatus;
import net.holosen.common.exceptions.NotFoundException;
import net.holosen.dto.product.ProductDto;
import net.holosen.dto.user.LimitedUserDto;
import net.holosen.dto.user.LoginDto;
import net.holosen.dto.user.UserDto;
import net.holosen.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public APIResponse<LimitedUserDto> login(@RequestBody LoginDto dto) {
        try {
            return APIResponse.<LimitedUserDto>builder()
                    .data(userService.login(dto))
                    .status(APIStatus.Success)
                    .build();
        } catch (Exception e) {
            return APIResponse.<LimitedUserDto>builder()
                    .data(null)
                    .message(e.getMessage())
                    .status(APIStatus.Error)
                    .build();
        }
    }
}
