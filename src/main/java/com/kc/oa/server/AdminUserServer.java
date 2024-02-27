package com.kc.oa.server;

public interface AdminUserServer {
    /**
     * 更新用户token值
     *
     * @param userName
     * @param password
     * @return
     */



    /**
     * 根据登录名和密码获取用户记录
     *
     * @return
     */
     String getNewToken(String sessionId, Long userId);


}

