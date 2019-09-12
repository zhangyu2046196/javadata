package com.youyuan.haxi;

import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 哈希表测试bean
 * @date 2018/11/6 19:33
 */
public class Info implements Serializable {
    private static final long serialVersionUID = -3806898109387736977L;
    /**
     * 英文名
     */
    private String eName;
    /**
     * 中文名
     */
    private String zName;

    public Info(String eName, String zName) {
        this.eName = eName;
        this.zName = zName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getzName() {
        return zName;
    }

    public void setzName(String zName) {
        this.zName = zName;
    }

    @Override
    public String toString() {
        return "Info{" +
                "eName='" + eName + '\'' +
                ", zName='" + zName + '\'' +
                '}';
    }
}
