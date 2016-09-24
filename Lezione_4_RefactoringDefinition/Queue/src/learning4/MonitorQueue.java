package learning4;

public class MonitorQueue implements Queue{
	private Queue queue = new BaseQueue();
	private int waterMark = 0;
	
	public int waterMark(){
		return waterMark;
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public int enqueue(Object value) {
		int size = queue.enqueue(value);
		waterMark = Math.max(size, waterMark);
		return size;
	}

	@Override
	public void dequeue() {
		queue.dequeue();
	}

	@Override
	public Object peek() {
		return queue.peek();
	}

	@Override
	public boolean isFull() {
		return queue.isFull();
	}
}
