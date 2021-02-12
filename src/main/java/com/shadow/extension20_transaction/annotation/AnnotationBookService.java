package com.shadow.extension20_transaction.annotation;

import com.shadow.extension20_transaction.xml.XmlBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shadow
 * @create 2021-02-12
 * @description
 */
@Service
public class AnnotationBookService {

    @Autowired
    private AnnotationBookDao annotationBookDao;

    /**
     * 结账：传入用户，哪本书
     * @param userName 用户名称
     * @param id 书 id
     */
    public void checkout(String userName, int id) {
        annotationBookDao.updateStock(id);
        int price = annotationBookDao.getPrice(id);
        annotationBookDao.updateBalance(price, userName);
    }

}
