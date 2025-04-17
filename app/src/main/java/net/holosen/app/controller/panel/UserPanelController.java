package net.holosen.app.controller.panel;

import jakarta.servlet.http.HttpServletRequest;
import net.holosen.app.anotation.CheckPermission;
import net.holosen.app.filter.JwtFilter;
import net.holosen.app.model.APIResponse;
import net.holosen.app.model.enums.APIStatus;
import net.holosen.dto.user.PermissionDto;
import net.holosen.dto.user.UserDto;
import net.holosen.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/panel/user")
public class UserPanelController {

    private final UserService userService;

    @Autowired
    public UserPanelController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    @CheckPermission("info_user")
    public APIResponse<UserDto> getById(@PathVariable("id") Long id, HttpServletRequest request) {
        return APIResponse.<UserDto>builder()
                .status(APIStatus.Success)
                .data(userService.getById(id))
                .build();
    }
}
