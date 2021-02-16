package com.fastdevelop.db.mapper;

import cn.hutool.json.JSONUtil;
import com.fastdevelop.db.model.ProjectDO;
import com.fastdevelop.db.model.ProjectDOExample;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
public class ProjectDOMapperTest {
    private static ProjectDOMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(ProjectDOMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/ProjectDOMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(ProjectDOMapper.class, builder.openSession(true));
    }

    @Test
    public void testSelectByExample() throws FileNotFoundException {
        ProjectDOExample example = new ProjectDOExample();
        ProjectDOExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("id asc limit 10");
        List<ProjectDO> projectDOList = mapper.selectByExample(example);
        log.info(JSONUtil.toJsonPrettyStr(projectDOList));
        //joining
//        String ids = projectDOList.stream().map(ProjectDO::getId).collect(Collectors.joining(",","[","]"));
//        ids = projectDOList.stream().map(ProjectDO::getId).collect(Collectors.joining(","));
//        log.info(ids);
        //counting
        long count = projectDOList.stream().collect(Collectors.counting());
        log.info("元素个数=== " + count);

        List<String> idList = projectDOList.stream().collect(Collectors.mapping(ProjectDO::getId, Collectors.toList()));
        log.info(JSONUtil.toJsonPrettyStr(idList));
        ArrayList<ProjectDO> projectDOArrayList = projectDOList.stream().collect(Collectors.toCollection(ArrayList::new));
        Map<String, String> idTitleMap = projectDOList.stream().collect(Collectors.toMap(ProjectDO::getId, ProjectDO::getTitle));
        log.info(JSONUtil.toJsonPrettyStr(idTitleMap));

    }


    @Test
    public void test1() {

        List<Integer> integerList = Lists.newArrayList(1, 2, 4, 99);
        integerList.stream().collect(Collectors.minBy(Integer::compareTo)).ifPresent(System.err::print);
        IntSummaryStatistics ss = integerList.stream().collect(Collectors.summarizingInt(value -> value));
        log.info(JSONUtil.toJsonPrettyStr(ss));
        Integer sum = integerList.stream().collect(Collectors.summingInt(value -> value));
        System.out.println(sum);

        Optional<Integer> integerOptional = integerList.stream().collect(Collectors.reducing(Integer::sum));
        if (integerOptional.isPresent())
            System.out.println(integerOptional.get());


    }

}
