package cn.kanshipin.test;

import cn.kanshipin.domain.Account;
import cn.kanshipin.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    @org.junit.Test
    public void run(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        AccountService as = (AccountService) ac.getBean("accountService");

        List<Account> all = as.findAll();
        for (Account account:all
             ) {
            System.out.println(account);
        }

    }
}
