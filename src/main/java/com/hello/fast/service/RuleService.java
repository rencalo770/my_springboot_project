package com.hello.fast.service;

import com.hello.fast.DO.BuDO;
import com.hello.fast.DO.RuleDO;
import com.hello.fast.DO.SceneDO;
import com.hello.fast.VO.RuleVO;
import com.hello.fast.mapper.rule.RuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {

    @Autowired
    RuleMapper ruleMapper;


    public List<BuDO> getBus() {
        return ruleMapper.getBus();
    }

    public List<SceneDO> getScenes(Integer bid){
        return ruleMapper.getScenes(bid);
    }

    public List<RuleDO> getRules(Integer bid, Integer sid, Integer status){
        return ruleMapper.getRules(bid,sid,status);
    }


    public int changeEM(SceneDO sceneDO){
        return ruleMapper.changeEM(sceneDO);
    }

    public Integer getBid(String name){
        return ruleMapper.getBid(name);
    }

    public Integer getSid(String name){
        return ruleMapper.getSid(name);
    }

    public int addBu(BuDO buDO){
        return ruleMapper.addBu(buDO);
    }

    public int addScene(SceneDO sceneDO){
        return ruleMapper.addScene(sceneDO);
    }

    public int addRule(RuleVO ruleVO){
        return ruleMapper.addRule(ruleVO);
    }

    public int changeStatus(RuleVO ruleVO){
        return ruleMapper.changeStatus(ruleVO);
    }

    public int updateRule(RuleVO ruleVO){
        return ruleMapper.updateRule(ruleVO);
    }
}
