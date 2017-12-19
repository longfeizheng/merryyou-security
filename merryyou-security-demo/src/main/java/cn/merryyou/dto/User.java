package cn.merryyou.dto;

import cn.merryyou.validator.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created on 2017/12/19 0019.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class User {

    private Integer id;

    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "测试")
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank
    private String password;

    @JsonView(UserSimpleView.class)
    private Date birthday;

    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};

}
