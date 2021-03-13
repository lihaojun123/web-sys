package com.fastdevelop.web.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.fastdevelop.common.res.CommonResponseCode;
import com.fastdevelop.common.res.JsonResult;
import com.fastdevelop.dto.UserDTO;
import com.fastdevelop.service.UserService;
import com.fastdevelop.web.utils.CookieUtil;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Value("${auth.clientId}")
    String clientId;
    @Value("${auth.clientSecret}")
    String clientSecret;
    @Value("${auth.cookieDomain}")
    String cookieDomain;
    @Value("${auth.cookieMaxAge}")
    int cookieMaxAge;
    @Value("${auth.tokenValiditySeconds}")
    int tokenValiditySeconds;

    @Autowired
    private UserService userService;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/listUser")
    public List<UserDTO> listUser() {
        List<UserDTO> userDTOList = userService.listUser();
        return userDTOList;
    }

    @GetMapping("/detail")
    public UserDTO detail(String username) {
        return userService.detail(username);
    }


    @GetMapping("/userlogin")
    public JsonResult<String> userlogin(String username, String password, String clientId, String clientSecret){

        if (StringUtils.isEmpty(username)) {
            return JsonResult.<String>builder().failure("用户名不允许为空").build();
        }

        if (StringUtils.isEmpty(password)) {
            return JsonResult.<String>builder().failure("密码不允许为空").build();
        }
        if (StringUtils.isEmpty(clientId)) {
            return JsonResult.<String>builder().failure("clientId为空").build();
        }
        if (StringUtils.isEmpty(clientSecret)) {
            return JsonResult.<String>builder().failure("clientSecret为空").build();
        }

        UserDTO userDTO = userService.detail(username);

        if (ObjectUtil.isEmpty(userDTO)) {
            return JsonResult.<String>builder().failure("用户不存在").build();
        }

        String encryPassword = userDTO.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        boolean matches = bCryptPasswordEncoder.matches(password, encryPassword);

        if (!matches) {
            return JsonResult.<String>builder().failure("密码错误").build();
        }

        //链式构建请求
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("grant_type","password");
        paramMap.put("username",username);
        paramMap.put("password",password);
        String url = "http://localhost:10010/fastdevelop/oauth/token";
        String body = HttpRequest.post(url)
                .header("Authorization", httpbasic(clientId,clientSecret))//头信息，多个头信息多次调用此方法即可
                .form(paramMap)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        String access_token = jsonObject.getStr("access_token");
        String refresh_token = jsonObject.getStr("refresh_token");
        String jti = jsonObject.getStr("jti");
        if (StringUtils.isEmpty(access_token)
                ||  StringUtils.isEmpty(refresh_token)
                || StringUtils.isEmpty(jti)) {
            return JsonResult.<String>builder().failure("登录失败").build();
        }
        saveCookie(jti);
//        redisTemplate.boundValueOps("user_token:" + jti).set(JSONUtil.toJsonStr(jsonObject), tokenValiditySeconds, TimeUnit.SECONDS);
        return JsonResult.<String>builder().success(access_token).build();
    }



    @GetMapping("/userjwt")
    public JsonResult<String> userjwt(){
        CommonResponseCode cookieUidIsEmpty = CommonResponseCode.COOKIE_UID_IS_EMPTY;
        Map<String, String> cookies = CookieUtil.readCookie(request, "uid");
        String uid = cookies.get("uid");
        if (MapUtil.isEmpty(cookies) || StringUtils.isEmpty(uid)) {
            return JsonResult.<String>builder().failure(cookieUidIsEmpty).build();
        }else {
            String user_token = stringRedisTemplate.opsForValue().get("user_token:" + uid);
            if (user_token != null) {
                com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(user_token);
                return JsonResult.<String>builder().success(jsonObject.getString("access_token")).build();
            }
            else {
                return JsonResult.<String>builder().failure(cookieUidIsEmpty).build();
            }
        }
    }

    private String httpbasic(String clientId, String clientSecret) {
        String string = clientId + ":" + clientSecret;
        byte[] encode = Base64Utils.encode(string.getBytes());
        return "Basic " + new String(encode);
    }

    //将令牌保存到cookie
    private void saveCookie(String token) {
        HttpServletResponse response = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getResponse();
        //添加cookie 认证令牌，最后一个参数设置为false，表示允许浏览器获取
        CookieUtil.addCookie(response, cookieDomain, "/", "uid", token, cookieMaxAge, false);
    }

}
