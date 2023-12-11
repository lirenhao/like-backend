package cn.like.backend.project.system.controller;

import cn.like.backend.project.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cn.like.backend.common.utils.StringUtils;
import cn.like.backend.framework.security.RegisterBody;
import cn.like.backend.framework.security.service.SysRegisterService;
import cn.like.backend.framework.web.controller.BaseController;
import cn.like.backend.framework.web.domain.AjaxResult;

/**
 * 注册验证
 * 
 * @author like
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
