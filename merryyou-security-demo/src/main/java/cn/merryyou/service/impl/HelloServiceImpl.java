package cn.merryyou.service.impl;

import cn.merryyou.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created on 2017/12/19 0019.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        log.info("name={}", name);
        return "hello" + name;
    }
}
