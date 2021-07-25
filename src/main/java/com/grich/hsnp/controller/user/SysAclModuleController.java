/*
package com.grich.share.controller.user;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grich.share.core.Result;
import com.grich.share.core.ResultGenerator;
import com.grich.share.model.user.SysAclModule;
import com.grich.share.service.user.SysAclModuleService;
import com.grich.share.utils.MyUUID;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

*/
/**
 * SysAclModule相关API。Created on 2020-05-11。
 *
 * @author William
 *//*

@Api(value="系统权限模块管理",tags={"系统权限模块管理"})
@RestController
@RequestMapping("/sys/acl/module")
public class SysAclModuleController {
    @Resource
    private SysAclModuleService sysAclModuleService;

    @PostMapping
    public Result<SysAclModule> add(@RequestBody SysAclModule sysAclModule) {
        Date now =new Date();
        sysAclModule.setId(MyUUID.randomUUID());
        sysAclModule.setOperateTime(now);
        sysAclModuleService.save(sysAclModule);
        return ResultGenerator.genSuccessResult(sysAclModule);
    }

    @DeleteMapping("/{id}")
    public Result<SysAclModule> delete(@PathVariable String id) {
        sysAclModuleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result<SysAclModule> update(@RequestBody SysAclModule sysAclModule) {
        Date now =new Date();
        sysAclModule.setOperateTime(now);
        sysAclModuleService.update(sysAclModule);
        return ResultGenerator.genSuccessResult(sysAclModule);
    }

    @GetMapping("/{id}")
    public Result<SysAclModule> detail(@PathVariable String id) {
        SysAclModule sysAclModule = sysAclModuleService.findById(id);
        return ResultGenerator.genSuccessResult(sysAclModule);
    }

    @GetMapping
    public Result<PageInfo<SysAclModule>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysAclModule> list = sysAclModuleService.findAll();
        PageInfo<SysAclModule> pageInfo = new PageInfo<SysAclModule>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
*/
