package dhm.account.service;

import dhm.account.model.Accounts;
import dhm.account.model.Transactions;
import dhm.account.repository.IAccountsRepository;
import dhm.account.repository.IFeignTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    IFeignTransactionsRepository feignTransaction;

    @Autowired
    IAccountsRepository repoAccount;

    public List<Transactions> getListTransactionUser(Integer id){

        return feignTransaction.getTransaction(id);
    }

    public Double getAmount (Integer id){
        Accounts account = repoAccount.findById(id).orElse(null);
        if(account == null){
            return null;
        }
        return account.getAmount();
    }

    public void saveAccount(Accounts account){
        repoAccount.save(account);
    }

}
