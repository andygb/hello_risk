package com.juqitech.risk.po.base;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michael.Zhong on 2018/2/1.
 */
public class BasePO implements Serializable {

    /**
     * 主表 id
     */
    protected String id;

    /**
     * 创建时间
     */
    protected Date create_time;

    /**
     * 更新时间
     */
    protected Date update_time;

    /**
     * 逻辑删除标
     */
    protected Boolean is_deleted;

    public BasePO() {
    }

    public BasePO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Boolean is_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
}
