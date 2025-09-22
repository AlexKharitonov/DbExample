package ak.teaching.dbexample.controller;

import ak.teaching.dbexample.dto.UserDto;
import ak.teaching.dbexample.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public Integer createUser(@RequestBody UserDto user) {
        return userService.saveUser(user);
    }
}