package dhm.card.service;

import dhm.card.model.Cards;
import dhm.card.model.Transference;
import dhm.card.repository.ICardsRepository;
import dhm.card.repository.IFeignTransferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsService {
    @Autowired
    ICardsRepository repoCards;

    @Autowired
    IFeignTransferenceRepository feignTransference;

    public List<Cards> getListCards() {
        return repoCards.findAll();
    }

    public Cards getCard(Integer id) {
        return repoCards.findById(id).orElse(null);
    }

    public Cards getCardByNumber(Integer number){
        return repoCards.findByNumber(number);
    }

    public Integer saveCards(Cards card) {
        Cards res = repoCards.findByNumber(card.getNumber());
        if (res == null) {
            repoCards.save(card);
            return 1;
        }
        return 0;

    }

    public void deleteCard(Integer numberCard) {
        Integer id = repoCards.findByNumber(numberCard).getId();
        repoCards.deleteById(id);
    }

    public String modifyCard(Integer number, Cards card) {
        Cards oldCard = getCardByNumber(number);
        if (oldCard == null) {
            return "Unsuccessful to find card";
        }
        oldCard.setCvv(card.getCvv());
        oldCard.setBank(card.getBank());
        oldCard.setEndDate(card.getEndDate());
        oldCard.setCvv(card.getCvv());

        saveCards(oldCard);

        return "Success to modify card";
    }

    public List<Cards> getUserCards(Integer idUser) {
        return repoCards.findByAccountId(idUser);
    }

    public Integer deleteCardFromAccount(Integer id) {
        Cards res = repoCards.findById(id).orElse(null);
        if (res == null) {
            return 0;
        }
        repoCards.deleteById(id);
        return 1;
    }

    public Integer saveTransference(Transference transference) {
        try {
            feignTransference.saveTransference(transference);
            return 1;
        } catch (Error e) {
            return 0;
        }
    }
}
