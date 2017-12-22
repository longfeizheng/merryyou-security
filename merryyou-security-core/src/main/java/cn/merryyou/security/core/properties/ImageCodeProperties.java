package cn.merryyou.security.core.properties;

import lombok.Data;

/**
 * Created on 2017/12/22 0022.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {
    /**
     * 图片宽
     */
    private int width = 67;
    /**
     * 图片高
     */
    private int height = 23;
    public ImageCodeProperties() {
        setLength(4);
    }
}
