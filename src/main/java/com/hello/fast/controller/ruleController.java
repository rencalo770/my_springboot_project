package com.hello.fast.controller;

import com.hello.fast.DO.BuDO;
import com.hello.fast.DO.RuleDO;
import com.hello.fast.DO.SceneDO;
import com.hello.fast.VO.Result;
import com.hello.fast.VO.RuleVO;
import com.hello.fast.service.RuleService;
import com.hello.fast.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ruleController {

    @Autowired
    private RuleService ruleService;

    //获取部门
    @RequestMapping(path = "/bu")
    public Result getBus(){
        Result result = new Result();

        List<BuDO> bus = ruleService.getBus();
        if (bus == null || bus.size() == 0){
            result.setCode(Constant.FAILED);
            result.setMessage("没有部门数据.");
            return result;
        }

        result.setCode(Constant.SUCCESS);
        result.setMessage("获取部门数据成功.");
        result.setData(bus);
        return result;
    }

    //获取场景
    @RequestMapping(path = "/scenes")
    public Result getScenes(@RequestParam("bid")Integer bid){
        Result result = new Result();
        List<SceneDO> scenes = ruleService.getScenes(bid);
        if (scenes == null || scenes.size() == 0){
            result.setCode(Constant.FAILED);
            result.setMessage("部门下没有场景!");
            return result;
        }

        result.setCode(Constant.SUCCESS);
        result.setMessage("获取场景成功!");
        result.setData(scenes);
        return result;
    }

    //获取规则
    @RequestMapping(path = "/rules")
    public Result getRules(@RequestParam("bid")Integer bid, @RequestParam("sid")Integer sid, @RequestParam("status")Integer status){
        Result result = new Result();
        List<RuleDO> rules = ruleService.getRules(bid, sid, status);
        if (rules == null || rules.size() == 0){
            System.out.println(rules);
            result.setCode(Constant.FAILED);
            result.setMessage("没有获取到指定状态的规则.");
            return result;
        }

        result.setCode(Constant.SUCCESS);
        result.setMessage("获取到规则");
        result.setData(rules);
        System.out.println("getRules-->"+ rules);
        return result;
    }

    //改变场景的执行模式
    @RequestMapping(path = "/change/em")
    public Result changeExecuteModel(SceneDO sceneDO){
        Result result = new Result();

        if (ruleService.changeEM(sceneDO) > 0){
            result.setCode(Constant.SUCCESS);
            result.setMessage("改变执行模式成功!");
            result.setData(true);
        }else {
            result.setCode(Constant.FAILED);
            result.setMessage("改变执行模式失败!");
            result.setData(false);
        }
        return result;
    }

    //新增部门
    @RequestMapping(path = "/add/bu")
    public Result addBu(@RequestParam("bu")String name){
        Result result =new Result();
        BuDO buDO= new BuDO();
        buDO.setName(name);
        int i = ruleService.addBu(buDO);
        System.out.println("addBu i-->"+ i);
        if (i == 1){
            result.setCode(Constant.SUCCESS);
            result.setMessage("创建部门成功");
        }else {
            result.setCode(Constant.FAILED);
            result.setMessage("创建部门失败");
        }
        return result;

    }

    //新增场景
    @RequestMapping(path = "/add/scene")
    public Result addScene(@RequestParam("bu")String bu, @RequestParam("scene")String name, @RequestParam("eid")Integer eid) throws Exception {
        Result result =new Result();
        Integer bid = ruleService.getBid(bu);
        if (bid == null){
            result.setCode(Constant.FAILED);
            result.setMessage("不存在的部门:" + bu);
            return result;
        }

        SceneDO sceneDO = new SceneDO();
        sceneDO.setBid(bid);
        sceneDO.setName(name);
        sceneDO.setEid(eid);
        int i = ruleService.addScene(sceneDO);
        System.out.println("addScene i-->"+ i);

        if (i == 1){
            result.setCode(Constant.SUCCESS);
            result.setMessage("创建场景成功");
        }else {
            result.setCode(Constant.FAILED);
            result.setMessage("创建场景失败");
        }
        return  result;
    }

    //新增规则
    @RequestMapping(path = "/add/rule")
    public Result addRule(@RequestBody RuleVO ruleVO) throws Exception {
        Result result =new Result();
        if (ruleVO.getName() == null || "".equals(ruleVO.getName().trim())
                || ruleVO.getDescription() == null || "".equals(ruleVO.getDescription().trim())
                || ruleVO.getSalience() == null
                || ruleVO.getContent() == null || "".equals(ruleVO.getContent().trim())
                || ruleVO.getUsername() == null  || "".equals(ruleVO.getUsername().trim())){
            result.setCode(Constant.FAILED);
            result.setMessage("有参数为空!");
            return result;
        }


        Integer bid = ruleService.getBid(ruleVO.getBu());
        Integer sid = ruleService.getSid(ruleVO.getScene());

        if (bid == null || bid < 0){
            result.setCode(Constant.FAILED);
            result.setMessage("不存在的部门名称!");
            return result;
        }

        if (sid == null || sid < 0){
            result.setCode(Constant.FAILED);
            result.setMessage("不存在的场景名称!");
            return result;
        }

        ruleVO.setBid(bid);
        ruleVO.setSid(sid);
        int i = ruleService.addRule(ruleVO);
        if (i == 1){
            result.setCode(Constant.SUCCESS);
            result.setMessage("创建规则成功");
        }else {
            result.setCode(Constant.FAILED);
            result.setMessage("创建规则失败");
        }
        return  result;
    }


    //更新规则的描述、优先级或、规则体
    @RequestMapping(path = "/update/rule")
    public Result updateRule(@RequestBody RuleVO ruleVO){
        String username = ruleVO.getUsername();
        Integer bid = ruleVO.getBid();
        Integer sid = ruleVO.getSid();
        String name = ruleVO.getName();
        String description = ruleVO.getDescription();
        Integer salience = ruleVO.getSalience();
        String content = ruleVO.getContent();

        Result result = new Result();
        if (username == null || "".equals(username.trim())
                || bid == null
                || sid == null
                || name == null || "".equals(name.trim())
                || description == null || "".equals(description.trim())
                || salience == null
                || content == null || "".equals(content.trim())){

            result.setCode(Constant.FAILED);
            result.setMessage("更新规则的参数异常");
            return result;
        }

        int i = ruleService.updateRule(ruleVO);
        System.out.println("updateRule i ==>"+ i + "---> "+ content);
        if (i > 0) {
            result.setCode(Constant.SUCCESS);
            result.setMessage("更新规则成功");
        }else {
            result.setCode(Constant.FAILED);
            result.setMessage("更新规则失败");
        }
        return result;
    }

    //单规则上下线
    @RequestMapping(path="/change/status")
    public Result changeStatus(@RequestBody RuleVO ruleVO) {

        Result result = new Result();
        if ( ruleVO.getUsername() == null ||
                ruleVO.getName() == null ||
                ruleVO.getBid() == null ||
                ruleVO.getSid() == null ||
                ruleVO.getStatus() == null){
            result.setCode(Constant.FAILED);
            result.setMessage("改变规则状态参数异常");
            return result;
        }


        int i = ruleService.changeStatus(ruleVO);
        if (i > 0){
            result.setCode(Constant.SUCCESS);
            result.setMessage("更新规则状态成功");
        }else {
            result.setCode(Constant.FAILED);
            result.setMessage("更新规则状态失败");
        }
        return result;

    }
}
