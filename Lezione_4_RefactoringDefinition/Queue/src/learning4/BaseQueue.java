package learning4;

import java.util.ArrayList;
import java.util.List;

public class BaseQueue implements Queue {

	private List<Object> list = new ArrayList<Object>();

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int enqueue(Object value) {
		list.add(value);
		return list.size();
	}

	@Override
	public Object peek() {
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void dequeue() {
		if(list.isEmpty()) 
			return;
		list.remove(0);
	}
	
	@Override
	public boolean isFull() {
		return false;
	}
}
