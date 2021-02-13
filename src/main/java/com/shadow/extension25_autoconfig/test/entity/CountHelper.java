package com.shadow.extension25_autoconfig.test.entity;

import com.shadow.extension25_autoconfig.ex.mybatis.AutoSetDate;
import com.shadow.extension25_autoconfig.ex.mybatis.AutoSetOperator;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Data
@Accessors(chain = true)
public class CountHelper {

    private long id;

    private int type;

    private String fnAccount;

    private int count;

    private int year;

    private int month;

    private int date;

    @AutoSetDate(value = "20220101", format = "yyyyMMdd")
    private LocalDateTime createTime;

    @AutoSetDate(value = "19700101", format = "yyyyMMdd")
    private LocalDateTime updateTime;

    @AutoSetOperator(value = "shadow")
    private String createBy;

    private String updateBy;
}
