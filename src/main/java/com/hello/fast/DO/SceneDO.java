package com.hello.fast.DO;

import java.sql.Timestamp;

/**
 * @author renyunyi
 * 业务场景信息表实体对象
 *
 */
public class SceneDO {

    /**
     * 数据表自增id,场景id
     */
    private int id;

    /**
     * 场景名称
     */
    private String name;

    /**
     * 部门id
     */
    private int bid;

    /**
     * 执行模式id
     */
    private int eid;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }


    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
