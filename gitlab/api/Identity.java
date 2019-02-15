package com.yanqiancloud.control.configserver.login.gitlab.api;

/**
 * @ProjectName: yqcloud
 * @Description: java类作用描述
 * @Author: lingyun.wei
 * @CreateDate: 2018/10/18 16:53
 * @Version: 1.0
 */
public class Identity {

    private String provider;

    private String extern_uid;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getExtern_uid() {
        return extern_uid;
    }

    public void setExtern_uid(String extern_uid) {
        this.extern_uid = extern_uid;
    }
}
