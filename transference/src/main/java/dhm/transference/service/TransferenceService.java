package dhm.transference.service;

import dhm.transference.model.Transference;
import dhm.transference.repository.ITransferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferenceService {

    @Autowired
    ITransferenceRepository repoTransactions;

    public List<Transference> getListTransactions(){
     return repoTransactions.findAll();
    }

    public Transference getTransaction(Integer id){
        return repoTransactions.findById(id).orElse(null);
    }

    public void saveTransaction(Transference transference){
        repoTransactions.save(transference);
    }

    public List<Transference> getAccountTransactions(Integer id){
        List<Transference> listTransfe = new ArrayList<>();
        for(Transference transference : repoTransactions.findAll()){
            if(transference.getAccount().getId().equals(id)){
                transference.setAccount(null);
                listTransfe.add(transference);
            }
        }

        return listTransfe;
    }

}
