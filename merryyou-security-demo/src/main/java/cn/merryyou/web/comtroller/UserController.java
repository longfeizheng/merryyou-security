package cn.merryyou.web.comtroller;

import cn.merryyou.dto.User;
import cn.merryyou.dto.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/12/19 0019.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @GetMapping("/me")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }
    @GetMapping("/meuser")
    public Object getCurrentUser1(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> get(UserQueryCondition condition, @PageableDefault(page = 0, size = 10, sort = "username,asc") Pageable pageable) {

        log.info("condition={}", condition);
        log.info("pageable={}", pageable);
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User get(@PathVariable("id") Integer id) {
//        throw new UserNotExistException(id);
        log.info("id={}", id);
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().stream().forEach(objectError -> log.info(objectError.getDefaultMessage()));
        }

        user.setId(1);
        log.info("user={}", user);
        return user;
    }

    @PutMapping(value = "/{id:\\d+}")
    public User update(@PathVariable("id") Integer id, @RequestBody User user) {

        user.setId(1);
        log.info("user={}", user);
        return user;
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable("id") Integer id) {
        log.info(id.toString());
    }
}
