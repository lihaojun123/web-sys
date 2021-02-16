package com.fastdevelop.util;

import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;

public class MyRedisUtil {

    private Jedis jedis;

    private String host;
    private String passwd;
    private String port;

    public MyRedisUtil(String host, String passwd, String port) {
        this.host = host;
        this.passwd = passwd;
        this.port = port;
    }

    public void setString(String key , String value){
        if (null == key)
        {
            throw new RuntimeException("key not allowed null");
        }
        Jedis jedis = new Jedis(this.host, Integer.parseInt(this.port));
        jedis.auth(this.passwd);
        jedis.set(key,value);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
