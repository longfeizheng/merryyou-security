package cn.merryyou.dto;

import lombok.Data;

/**
 * Created on 2017/12/20 0020.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class FileInfo {
    public FileInfo() {
    }

    public FileInfo(String path) {
        this.path = path;
    }

    private String path;


}
