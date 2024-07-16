package dhm.account.service;

import dhm.account.model.Transactions;
import dhm.account.repository.IFeignTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    IFeignTransactionsRepository feignTransaction;

    public List<Transactions> getListTransactionUser(Integer id){
        return feignTransaction.getTransaction(id);
    }

}
