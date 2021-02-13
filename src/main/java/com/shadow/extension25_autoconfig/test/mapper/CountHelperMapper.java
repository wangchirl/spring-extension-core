package com.shadow.extension25_autoconfig.test.mapper;

import com.shadow.extension25_autoconfig.test.entity.CountHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Mapper
public interface CountHelperMapper {

    void batchSave(@Param("list") List<CountHelper> list);

    void deleteAll();

    List<CountHelper> queryAll();

}
