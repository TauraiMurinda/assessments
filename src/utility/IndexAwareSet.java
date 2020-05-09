package utility;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import model.Card;

public class IndexAwareSet<T> implements Set {
	   private   Set<T> set;
	   public IndexAwareSet(Set<Card> cardsofDeck2) {
	     this.set = (Set<T>) cardsofDeck2;
	   }

	   // ... implement all methods from Set and delegate to the internal Set

	   public  int getIndex(Set<T> set, Object value) {
		   int result = 0;
	     for (T entry:set) {
	       if (entry.equals(value)) return result;
	       result++;
	     }
	     return -1;
	   }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	 }