/*
package com.grich.share.controller.user;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grich.share.core.Result;
import com.grich.share.core.ResultGenerator;
import com.grich.share.model.user.SysRole;
import com.grich.share.service.user.SysRoleService;
import com.grich.share.utils.MyUUID;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

*/
/**
 * SysRole相关API。Created on 2020-05-11。
 *
 * @author William
 *//*

@Api(value="系统角色管理",tags={"系统角色管理"})
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    @PostMapping
    public Result<SysRole> add(@RequestBody SysRole sysRole) {
        Date now =new Date();
        sysRole.setId(MyUUID.randomUUID());
        sysRole.setOperateTime(now);
        sysRoleService.save(sysRole);
        return ResultGenerator.genSuccessResult(sysRole);
    }

    @DeleteMapping("/{id}")
    public Result<SysRole> delete(@PathVariable String id) {
        sysRoleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result<SysRole> update(@RequestBody SysRole sysRole) {
        Date now =new Date();
        sysRole.setOperateTime(now);
        sysRoleService.update(sysRole);
        return ResultGenerator.genSuccessResult(sysRole);
    }

    @GetMapping("/{id}")
    public Result<SysRole> detail(@PathVariable String id) {
        SysRole sysRole = sysRoleService.findById(id);
        return ResultGenerator.genSuccessResult(sysRole);
    }

    @GetMapping
    public Result<PageInfo<SysRole>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRole> list = sysRoleService.findAll();
        PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
*/
