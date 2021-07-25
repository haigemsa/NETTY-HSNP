package com.grich.hsnp.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 * @author william
 */
public interface Service<T> {
	/**
	 * 写入数据库
	 * @param model
	 */
    void save(T model);
    /**
     * 批量写入数据库
     * @param models
     */
    void save(List<T> models);
    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(Integer id);
    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(Long id);
    /**
     * 通过主鍵刪除
     * @param id
     */
    void deleteById(String id);
    /**
     * 批量刪除 eg：ids ： “1,2,3,4”
     * @param ids
     */
    void deleteByIds(String ids);
    /**
     * 更新一条记录
     * @param model
     */
    void update(T model);
    /**
     * 通过ID查找
     * @param id
     * @return ID对应的一条记录；如果没有找到，则返回NULL
     */
    T findById(Integer id);
    /**
     * 通过ID查找
     * @param id
     * @return ID对应的一条记录；如果没有找到，则返回NULL
     */
    T findById(Long id);
    /**
     * 通过ID查找
     * @param id
     * @return ID对应的一条记录；如果没有找到，则返回NULL
     */
    T findById(String id);
    /**
     * 通过ID查找
     * @param id
     * @return ID对应的一条记录；如果没有找到，则返回NULL
     */
    T findById(BigDecimal id);
    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException; 
    /**
     * 通过多个ID查找。eg：ids ： “1,2,3,4”
     * @param ids
     * @return
     */
    List<T> findByIds(String ids);
    /**
     * 根据条件查找
     * @param condition
     * @return
     */
    List<T> findByCondition(Condition condition);
    /**
     * 获取所有记录
     * @return
     */
    List<T> findAll();
    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param model
     * @return List<T>
     */
    List<T> findByModel(T model);


    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param model
     * @return T
     */
    T findOneByModel(T model);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param model
     * @return int
     */
    int findCountByModel(T model);

    /**
     * 根据Condition条件进行查询总数
     * @param condition
     * @return int
     */
    int findCountByCondition(Condition condition);


}
