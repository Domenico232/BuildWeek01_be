package interfaces;

import java.util.List;

import models.Card;

public interface ICardDAO {
	public void save(Card card);
	public void saveAll(List<Card> cards);
	public Card getById(long id);
	public void update(Card card);
	public void remove(Card card);
	public List<Card> getAll();
	public void verificaValidita (long id, long idsub);
}
