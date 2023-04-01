package com.tars.tm.Controller;

import java.util.Objects;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin(
    origins = {"*"},
    allowedHeaders = {"*"}
)
@RestController
@RequestMapping({"/users"})
public class UserController {
    private final UserSignUpService userSignUpService;
    private final UserLoginService userLoginService;
    private final UserValidator userValidator;
    private final UserMapper userMapper;

    public UserController(UserSignUpService userSignUpService, UserLoginService userLoginService, UserValidator userValidator, UserMapper userMapper) {
        this.userSignUpService = userSignUpService;
        this.userLoginService = userLoginService;
        this.userValidator = userValidator;
        this.userMapper = userMapper;
    }

    @PostMapping({"/signup"})
    public Mono<ResponseEntity<UserDTO>> signUp(@RequestBody UserDTO userDTO) {
        this.userValidator.validateUserSignup(userDTO);
        UserEntity user = this.userMapper.convertToUserEntity(userDTO);
        Mono var10000 = this.userSignUpService.signUp(user);
        UserMapper var10001 = this.userMapper;
        Objects.requireNonNull(var10001);
        return var10000.map(var10001::convertToUserDTO).map((savedUser) -> {
            return ResponseEntity.ok(savedUser);
        }).defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public Mono<ResponseEntity<UserDTO>> loginUser(@RequestBody UserLoginDTO userLoginDTO) {
        return this.userLoginService.loginUser(userLoginDTO).map((userEntity) -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            userDTO.setPassword((String)null);
            return new ResponseEntity(userDTO, HttpStatus.OK);
        }).onErrorResume((e) -> {
            return Mono.just(new ResponseEntity((MultiValueMap)null, HttpStatus.UNAUTHORIZED));
        });
    }
}