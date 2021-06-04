package com.hello.fast.DO;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author renyunyi
 */
public class RuleDO {

    /**
     * 规则id
     */
    private Integer id;

    /**
     * 部门id
     */
    private Integer bid;

    /**
     * 场景id
     */
    private Integer sid;


    /**
     * 规则名称
     */
    private String name;

    /**
     * 规则描述
     */
    private String description;


    /**
     * 规则优先级
     */
    private Integer salience;


    private Integer status;

    /**
     * 规则体
     */
    private String content;

    /**
     * 规则修改用户
     */
    private String username;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSalience() {
        return salience;
    }

    public void setSalience(Integer salience) {
        this.salience = salience;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return null or not null
     */
    public String getRuleString(){
        if (this.name == null || this.content == null){
            return null;
        }

        return "rule " + "\"" + this.name + "\"" +
                (this.description != null ? " \"" + this.description+ "\" " : "") +
                "salience " + this.salience + "\n" +
                "begin\n" +
                this.content +
                "end\n";
    }

}
