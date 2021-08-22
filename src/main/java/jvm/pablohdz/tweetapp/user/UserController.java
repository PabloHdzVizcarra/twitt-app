package jvm.pablohdz.tweetapp.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    private User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
