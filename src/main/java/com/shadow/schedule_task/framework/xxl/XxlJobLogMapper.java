package com.shadow.schedule_task.framework.xxl;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface XxlJobLogMapper {

    XxlJobLog load(@Param("id") long id);

    int updateHandleInfo(XxlJobLog xxlJobLog);

}
