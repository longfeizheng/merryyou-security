package cn.merryyou.exception;

import lombok.Data;

/**
 * Created on 2017/12/20 0020.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class UserNotExistException extends RuntimeException{

    private Integer id;

    private static final long serialVersionUID = 2789664930897736742L;

    public UserNotExistException(Integer id){
        super("user not exception");
        this.id = id;
    }
}
