package net.holosen.service.user;

import lombok.SneakyThrows;
import net.holosen.common.exceptions.ValidationException;
import net.holosen.common.utils.HashUtil;
import net.holosen.dataaccess.entity.user.User;
import net.holosen.dataaccess.repository.user.PermissionRepository;
import net.holosen.dataaccess.repository.user.RoleRepository;
import net.holosen.dataaccess.repository.user.UserRepository;
import net.holosen.dto.user.LimitedUserDto;
import net.holosen.dto.user.LoginDto;
import net.holosen.dto.user.UserDto;
import net.holosen.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.holosen.common.exceptions.NotFoundException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final ModelMapper mapper;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PermissionRepository permissionRepository,
                       ModelMapper mapper, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.mapper = mapper;
        this.jwtUtil = jwtUtil;
    }

    public LimitedUserDto login(LoginDto dto) throws Exception {
        String password = HashUtil.sha1Hash(dto.getPassword());
        User user = userRepository
                .findFirstByUsernameEqualsIgnoreCaseAndPassword(dto.getUsername(), password)
                .orElseThrow(NotFoundException::new);
        if (!user.getEnable()) {
            throw new ValidationException("Your user is disable. contact with support.");
        }
        LimitedUserDto result = mapper.map(user, LimitedUserDto.class);
        result.setToken(jwtUtil.generateToken(result.getUsername()));
        return result;
    }

    @SneakyThrows
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findFirstByUsername(username).orElseThrow(NotFoundException::new);
        return mapper.map(user, UserDto.class);
    }

    @SneakyThrows
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        return mapper.map(user, UserDto.class);
    }
}
