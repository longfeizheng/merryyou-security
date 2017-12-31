package cn.merryyou.security.authentication.app;

/**
 * Created on 2017/12/31 0031.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class AppSecretException extends RuntimeException {

    public AppSecretException(String msg){
        super(msg);
    }
}
