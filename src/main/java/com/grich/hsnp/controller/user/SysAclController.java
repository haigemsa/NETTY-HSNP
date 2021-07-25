/*
package com.grich.share.controller.user;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.grich.share.core.Result;
import com.grich.share.core.ResultGenerator;
import com.grich.share.model.user.SysAcl;
import com.grich.share.service.user.SysAclService;
import com.grich.share.utils.MyUUID;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

*/
/**
 * SysAcl相关API。Created on 2020-05-11。
 *
 * @author William
 *//*

@Api(value="系统权限管理",tags={"系统权限管理"})
@RestController
@RequestMapping("/sys/acl")
public class SysAclController {
    @Resource
    private SysAclService sysAclService;

    @PostMapping
    public Result<SysAcl> add(@RequestBody SysAcl sysAcl) {
        Date now =new Date();
        sysAcl.setId(MyUUID.randomUUID());
        sysAcl.setOperateTime(now);
        sysAclService.save(sysAcl);
        return ResultGenerator.genSuccessResult(sysAcl);
    }

    @DeleteMapping("/{id}")
    public Result<SysAcl> delete(@PathVariable String id) {
        sysAclService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result<SysAcl> update(@RequestBody SysAcl sysAcl) {
        Date now =new Date();
        sysAcl.setOperateTime(now);
        sysAclService.update(sysAcl);
        return ResultGenerator.genSuccessResult(sysAcl);
    }

    @GetMapping("/{id}")
    public Result<SysAcl> detail(@PathVariable String id) {
        SysAcl sysAcl = sysAclService.findById(id);
        return ResultGenerator.genSuccessResult(sysAcl);
    }

    @GetMapping
    public Result<PageInfo<SysAcl>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysAcl> list = sysAclService.findAll();
        PageInfo<SysAcl> pageInfo = new PageInfo<SysAcl>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
*/
