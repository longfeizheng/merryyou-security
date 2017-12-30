package cn.merryyou.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * Created on 2017/12/30 0030.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
public class DemoConnectionSignUp implements ConnectionSignUp {
    /**
     * 根据社交用户信息，默认创建用户，并返回用户唯一标识
     * @param connection
     * @return
     */
    @Override
    public String execute(Connection<?> connection) {
        return connection.getDisplayName();
    }
}
