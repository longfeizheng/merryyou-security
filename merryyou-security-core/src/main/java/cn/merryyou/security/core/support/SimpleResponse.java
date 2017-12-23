package cn.merryyou.security.core.support;

import lombok.Data;

/**
 * Created on 2017/12/21 0021.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class SimpleResponse {
    public SimpleResponse() {
    }

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;
}
