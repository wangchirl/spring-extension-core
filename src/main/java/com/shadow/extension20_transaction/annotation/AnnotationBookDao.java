package com.shadow.extension20_transaction.annotation;

import com.shadow.utils.ConsolePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Repository
public class AnnotationBookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 减去某个用户的余额
     * @param userName
     * @param price
     */
    @Transactional
    public void updateBalance(int price, String userName) {
        String sql = "UPDATE account SET balance=balance - ? WHERE username = ?";
        ConsolePrinter.printlnRed("sql ==> " + sql);
        ConsolePrinter.printlnRed("args ==> " + Arrays.toString(new Object[]{price, userName}));
        jdbcTemplate.update(sql, price, userName);
    }

    /**
     * 按照图书的 ID 获取图书的价格
     * @param id
     * @return
     */
    @Transactional
    public int getPrice(int id) {
        String sql = "SELECT price FROM book WHERE id = ?";
        ConsolePrinter.printlnRed("sql ==> " + sql);
        ConsolePrinter.printlnRed("args ==> " + Arrays.toString(new Object[]{id}));
        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }

    /**
     * 减去某本书的库存
     * @param id
     */
    @Transactional
    public void updateStock(int id) {
        String sql = "UPDATE book_stock SET stock=stock - 1 WHERE id = ?";
        ConsolePrinter.printlnRed("sql ==> " + sql);
        ConsolePrinter.printlnRed("args ==> " + Arrays.toString(new Object[]{id}));
        jdbcTemplate.update(sql, id);
        /*for (int i = 0; i <10; i++) {
            ConsolePrinter.printlnRed(10 / i);
        }*/
    }

}
