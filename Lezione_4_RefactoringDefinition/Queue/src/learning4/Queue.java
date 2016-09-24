package learning4;

public interface Queue {
	boolean isEmpty();
	int enqueue(Object value);
	Object peek();
	void dequeue();
	boolean isFull();
}