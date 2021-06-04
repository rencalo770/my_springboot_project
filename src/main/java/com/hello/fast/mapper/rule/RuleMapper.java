package com.hello.fast.mapper.rule;

import com.hello.fast.DO.BuDO;
import com.hello.fast.DO.RuleDO;
import com.hello.fast.DO.SceneDO;
import com.hello.fast.VO.RuleVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author renyunyi
 *
 */

@Repository
public interface RuleMapper {
    /**
     * 获取部门信息
     * @return 部门列表
     */
    List<BuDO> getBus();


    /**
     * 通过部门名称获取部门id
     * @param name 部门名称
     * @return 部门id
     */
    Integer getBid(String name);


    /**
     * 获取场景信息
     * @param bid 部门id
     * @return 对应部门下的列表
     */
    List<SceneDO> getScenes(@Param("bid") Integer bid);


    /**
     * 通过场景名称获取场景id
     * @param name 场景名称
     * @return 场景id
     */
    Integer getSid(String name);

    /**
     * 获取规则列表
     * @param bid 部门id
     * @param sid 场景id
     * @param status 离线或在线状态位
     * @return 规则列表
     */
    List<RuleDO> getRules(@Param("bid")Integer bid, @Param("sid")Integer sid, @Param("status") Integer status);

    /**
     * 改变执行模式
     * @param sceneDO
     * @return
     */
    int changeEM(SceneDO sceneDO);

    /**
     * 增加一个部门
     *
     * @return
     */
    int addBu(BuDO buDO);

    /**
     * 增加一个场景
     * @param sceneDO
     * @return
     */
    int addScene(SceneDO sceneDO);

    /**
     * 新增规则
     * @param ruleVO
     * @return
     */
    int addRule(RuleVO ruleVO);

    /**
     * 改变规则状态
     * @return
     */
    int changeStatus(RuleVO ruleVO);

    /**
     * 更新规则
     * @param ruleVO
     * @return
     */
    int updateRule(RuleVO ruleVO);
}
