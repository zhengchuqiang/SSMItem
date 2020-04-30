package cn.kanshipin.controller;


import cn.kanshipin.domain.Account;
import cn.kanshipin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("accountController")

@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public  String  findAll(Model model){
        System.out.println("表现成。。。");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/save")
    public  void   save(Account account, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        System.out.println("表现成。。。");
       accountService.saveAccount(account);

       httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/account/findAll");
        return;
    }
}
