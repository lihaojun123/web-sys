package com.fastdevelop.convert;

import com.fastdevelop.db.model.BlogDO;
import com.fastdevelop.dto.BlogDTO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(BlogConvertDecorator.class)
public interface BlogConvert {
    BlogDO blogDTO2BlogDO(BlogDTO blogDTO);
    BlogDTO blogDO2BlogDTO(BlogDO blogDO);
    List<BlogDO> blogDTOList2BlogDOList(List<BlogDTO> blogDTOList);
    List<BlogDTO> blogDOList2BlogDTOList(List<BlogDO> blogDOList);
}
