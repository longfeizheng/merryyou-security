package cn.merryyou.security.core.properties;

import lombok.Data;

/**
 * Created on 2017/12/21 0021.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class BrowserProperties {

    private String loginPage = "/merryyou-signIn.html";

    private String signUpUrl = "/merryyou-signUp.html";

    private String signOutUrl = "/merryyou-signOut.html";

    private SessionProperties session = new SessionProperties();

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSeconds = 3600;
}
