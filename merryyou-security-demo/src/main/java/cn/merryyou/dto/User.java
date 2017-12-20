package cn.merryyou.dto;

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

    private String username;

    @NotBlank
    private String password;

    private Date birthday;

    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};

}
