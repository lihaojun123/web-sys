package com.fastdevelop.web.config;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelop.db.mapper.OauthClientDetailDOMapper;
import com.fastdevelop.db.model.OauthClientDetailDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class MyClientDetailsService implements ClientDetailsService {

    @Resource
    private OauthClientDetailDOMapper oauthClientDetailDOMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        log.info("MyClientDetailsService loadClientByClientId , clientId = {} " , clientId);
        OauthClientDetailDO oauthClientDetailDO = oauthClientDetailDOMapper.selectOneByClientId(clientId);
        if (
                ObjectUtil.isNotEmpty(oauthClientDetailDO)
        ){
            BaseClientDetails baseClientDetails = new BaseClientDetails(
                    clientId,oauthClientDetailDO.getResourceIds(),oauthClientDetailDO.getScope(),oauthClientDetailDO.getAuthorizedGrantTypes(),oauthClientDetailDO.getAuthorities(),oauthClientDetailDO.getWebServerRedirectUri()
            );
            baseClientDetails.setClientSecret(oauthClientDetailDO.getClientSecret());
            return baseClientDetails;
        }
        else {
            return null;
        }
    }
}
