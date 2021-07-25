/*
package com.grich.share.controller.user;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grich.share.core.Result;
import com.grich.share.core.ResultGenerator;
import com.grich.share.model.user.SysRoleUser;
import com.grich.share.service.user.SysRoleUserService;
import com.grich.share.utils.MyUUID;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

*/
/**
 * SysRoleUser相关API。Created on 2020-05-11。
 *
 * @author William
 *//*

@Api(value="系统用户角色管理",tags={"系统用户角色管理"})
@RestController
@RequestMapping("/sys/role/user")
public class SysRoleUserController {
    @Resource
    private SysRoleUserService sysRoleUserService;

    @PostMapping
    public Result<SysRoleUser> add(@RequestBody SysRoleUser sysRoleUser) {
        Date now =new Date();
        sysRoleUser.setId(MyUUID.randomUUID());
        sysRoleUser.setOperateTime(now);
        sysRoleUserService.save(sysRoleUser);
        return ResultGenerator.genSuccessResult(sysRoleUser);
    }

    @DeleteMapping("/{id}")
    public Result<SysRoleUser> delete(@PathVariable String id) {
        sysRoleUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result<SysRoleUser> update(@RequestBody SysRoleUser sysRoleUser) {
        Date now =new Date();
        sysRoleUser.setOperateTime(now);
        sysRoleUserService.update(sysRoleUser);
        return ResultGenerator.genSuccessResult(sysRoleUser);
    }

    @GetMapping("/{id}")
    public Result<SysRoleUser> detail(@PathVariable String id) {
        SysRoleUser sysRoleUser = sysRoleUserService.findById(id);
        return ResultGenerator.genSuccessResult(sysRoleUser);
    }

    @GetMapping
    public Result<PageInfo<SysRoleUser>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRoleUser> list = sysRoleUserService.findAll();
        PageInfo<SysRoleUser> pageInfo = new PageInfo<SysRoleUser>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
*/
