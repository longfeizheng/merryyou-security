package cn.merryyou.security.core.properties;

import lombok.Data;

/**
 * Created on 2017/12/31 0031.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class OAuth2Properties {

    private String jwtSigningKey = "merryyou";

    private OAuth2ClietnProperties[] clients = {};

}
