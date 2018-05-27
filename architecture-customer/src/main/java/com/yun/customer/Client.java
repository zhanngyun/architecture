package com.yun.customer;

import com.yun.customer.dao.CustomerDAO;
import com.yun.customer.vo.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author yzhang
 * @date 2018/5/27 19:12
 * @desc
 */
@Service
public class Client {

    @Autowired
    private CustomerDAO customerDAO;


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Client client = (Client)context.getBean("client");
        CustomerModel cm = new CustomerModel();
        cm.setUuid(1);
        cm.setCustomerId("1");
        cm.setPwd("pwd12356");
        cm.setShowName("updateName");
        cm.setTrueName("zhangyun");
        cm.setRegisterTime(new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
        /*client.customerDAO.create(cm);*/

       /* CustomerModel byUuid = client.customerDAO.getByUuid(1);
        System.out.println(byUuid);*/
//        CustomerQueryModel queryModel = new CustomerQueryModel();
        /*queryModel.setUuid(1);
        List<CustomerModel> byCondition = client.customerDAO.getByCondition(queryModel);
        System.out.println(byCondition.get(0).toString());*/
        client.customerDAO.delete(1);



    }

}
