package cn.merryyou.security.browser.validate.code.impl;

import cn.merryyou.security.core.validate.code.ValidateCode;
import cn.merryyou.security.core.validate.code.ValidateCodeRepository;
import cn.merryyou.security.core.validate.code.ValidateCodeType;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created on 2017/12/31 0031.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
public class SessionValidateCodeRepository implements ValidateCodeRepository {
    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /* (non-Javadoc)
     * @see com.imooc.security.core.validate.code.ValidateCodeRepository#save(org.springframework.web.context.request.ServletWebRequest, com.imooc.security.core.validate.code.ValidateCode, com.imooc.security.core.validate.code.ValidateCodeType)
     */
    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
        sessionStrategy.setAttribute(request, getSessionKey(request, validateCodeType), code);
    }

    /**
     * 构建验证码放入session时的key
     *
     * @param request
     * @return
     */
    private String getSessionKey(ServletWebRequest request, ValidateCodeType validateCodeType) {
        return SESSION_KEY_PREFIX + validateCodeType.toString().toUpperCase();
    }

    /* (non-Javadoc)
     * @see com.imooc.security.core.validate.code.ValidateCodeRepository#get(org.springframework.web.context.request.ServletWebRequest, com.imooc.security.core.validate.code.ValidateCodeType)
     */
    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
        return (ValidateCode) sessionStrategy.getAttribute(request, getSessionKey(request, validateCodeType));
    }

    /* (non-Javadoc)
     * @see com.imooc.security.core.validate.code.ValidateCodeRepository#remove(org.springframework.web.context.request.ServletWebRequest, com.imooc.security.core.validate.code.ValidateCodeType)
     */
    @Override
    public void remove(ServletWebRequest request, ValidateCodeType codeType) {
        sessionStrategy.removeAttribute(request, getSessionKey(request, codeType));
    }

}
