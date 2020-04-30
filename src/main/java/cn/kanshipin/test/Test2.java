package cn.kanshipin.test;

import cn.kanshipin.dao.AccountDao;
import cn.kanshipin.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test2 {

    public InputStream in;
    
    @Test
    public  void run2() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        AccountDao dao = session.getMapper(AccountDao.class);

        List<Account> all = dao.findAll();

        for (Account  account:all
             ) {
            System.out.println(account);
        }
        session.close();
        in.close();

    }

    @Test
    public  void run3() throws Exception {

        Account account1 = new Account();
        account1.setName("nihao");
        account1.setMoney(126d);
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        AccountDao dao = session.getMapper(AccountDao.class);

       dao.saveAccount(account1);

       session.commit();
        session.close();
        in.close();

    }
}
