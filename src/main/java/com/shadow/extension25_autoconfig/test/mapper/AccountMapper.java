package com.shadow.extension25_autoconfig.test.mapper;

import com.shadow.extension25_autoconfig.test.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Mapper
public interface AccountMapper {

    List<Account> queryAll();

}
