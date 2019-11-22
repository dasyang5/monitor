package com.nl.monitor.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

/**
 * 数据屏配置信息
 * @author Alex
 * @date 2019/11/15 10:32
 */
@Entity
@Table(name = "t_monitor")
public class Monitor implements Serializable {

    private static final long serialVersionUID = 4557939745860930761L;

    private String id;

    /**
     * 所属用户
     */
    private String userId;

    /**
     * 屏幕标题
     */
    private String title;

    /**
     * json串保存结果
     */
    private Clob result;

    private Date createTime;

    private Date updateTime;

    public Monitor(){}

    public Monitor(String userId, String title, Clob result) {
        this.userId = userId;
        this.title = title;
        this.result = result;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "user_id", nullable = false, length = 32)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "title", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "result")
    public Clob getResult() {
        return result;
    }

    public void setResult(Clob result) {
        this.result = result;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
