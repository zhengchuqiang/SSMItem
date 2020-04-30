package cn.kanshipin.service;

import cn.kanshipin.domain.Account;

import java.util.List;

public interface AccountService {

        public List<Account> findAll();

        public void saveAccount(Account account);
}