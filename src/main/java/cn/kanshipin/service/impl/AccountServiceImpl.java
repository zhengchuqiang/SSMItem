package cn.kanshipin.service.impl;

import cn.kanshipin.dao.AccountDao;
import cn.kanshipin.domain.Account;
import cn.kanshipin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {

        System.out.println("业务层查询输出。。。");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层保存。。。");
        accountDao.saveAccount(account);

    }
}
