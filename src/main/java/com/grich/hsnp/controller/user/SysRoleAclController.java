/*
package com.grich.share.controller.user;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grich.share.core.Result;
import com.grich.share.core.ResultGenerator;
import com.grich.share.model.user.SysRoleAcl;
import com.grich.share.service.user.SysRoleAclService;
import com.grich.share.utils.MyUUID;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

*/
/**
 * SysRoleAcl相关API。Created on 2020-05-11。
 *
 * @author William
 *//*

@Api(value="系统角色权限管理",tags={"系统角色权限管理"})
@RestController
@RequestMapping("/sys/role/acl")
public class SysRoleAclController {
    @Resource
    private SysRoleAclService sysRoleAclService;

    @PostMapping
    public Result<SysRoleAcl> add(@RequestBody SysRoleAcl sysRoleAcl) {
        Date now =new Date();
        sysRoleAcl.setId(MyUUID.randomUUID());
        sysRoleAcl.setOperateTime(now);
        sysRoleAclService.save(sysRoleAcl);
        return ResultGenerator.genSuccessResult(sysRoleAcl);
    }

    @DeleteMapping("/{id}")
    public Result<SysRoleAcl> delete(@PathVariable String id) {
        sysRoleAclService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result<SysRoleAcl> update(@RequestBody SysRoleAcl sysRoleAcl) {
        Date now =new Date();
        sysRoleAcl.setOperateTime(now);
        sysRoleAclService.update(sysRoleAcl);
        return ResultGenerator.genSuccessResult(sysRoleAcl);
    }

    @GetMapping("/{id}")
    public Result<SysRoleAcl> detail(@PathVariable String id) {
        SysRoleAcl sysRoleAcl = sysRoleAclService.findById(id);
        return ResultGenerator.genSuccessResult(sysRoleAcl);
    }

    @GetMapping
    public Result<PageInfo<SysRoleAcl>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRoleAcl> list = sysRoleAclService.findAll();
        PageInfo<SysRoleAcl> pageInfo = new PageInfo<SysRoleAcl>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
*/
