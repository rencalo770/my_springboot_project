package com.hello.fast.VO;

import com.hello.fast.DO.RuleDO;

public class RuleVO extends RuleDO {

    /**
     * 部门名称
     */
    private String bu;

    /**
     * 场景名称
     */
    private String scene;

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }
}
