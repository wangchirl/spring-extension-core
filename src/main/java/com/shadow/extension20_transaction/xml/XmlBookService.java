package com.shadow.extension20_transaction.xml;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Data
@Accessors(chain = true)
public class XmlBookService {

    XmlBookDao xmlBookDao;

    /**
     * 结账：传入用户，哪本书
     * @param userName 用户名称
     * @param id 书 id
     */
    public void checkout(String userName, int id) {
        xmlBookDao.updateStock(id);
        int price = xmlBookDao.getPrice(id);
        xmlBookDao.updateBalance(price, userName);
    }

}
