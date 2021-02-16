package com.fastdevelop.db.mapper;

import com.fastdevelop.db.model.OauthClientDetailDO;
import com.fastdevelop.db.model.OauthClientDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OauthClientDetailDOMapper {
    long countByExample(OauthClientDetailDOExample example);

    int deleteByExample(OauthClientDetailDOExample example);

    int insert(OauthClientDetailDO record);

    int insertSelective(OauthClientDetailDO record);

    List<OauthClientDetailDO> selectByExample(OauthClientDetailDOExample example);

    int updateByExampleSelective(@Param("record") OauthClientDetailDO record, @Param("example") OauthClientDetailDOExample example);

    int updateByExample(@Param("record") OauthClientDetailDO record, @Param("example") OauthClientDetailDOExample example);

    OauthClientDetailDO selectOneByClientId(@Param("clientId")String clientId);




}