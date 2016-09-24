package learning4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {

	private Queue queue;

	@Before
	public void setup() {
		queue = new BaseQueue();
	}
	
	@Test
	public void empty() {
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void enqueue() {
		queue.enqueue("golf");
		
		assertFalse(queue.isEmpty());
		
		queue.enqueue(1);
		
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void peek() {
		queue.enqueue("golf");
		queue.enqueue(1);
		
		assertEquals("golf", queue.peek());
		assertEquals("golf", queue.peek());
	}

	@Test
	public void peekEmpty() {
		assertEquals(null, queue.peek());
	}
	
	@Test
	public void dequeue() {
		queue.enqueue("golf");
		queue.enqueue(1);
		
		queue.dequeue();
		
		assertEquals(1, queue.peek());
	}
	
	@Test
	public void dequeueEmpty() {
		queue.dequeue();
		
		assertEquals(null, queue.peek());
	}
	
	@Test
	public void alwaysFull() {
		assertFalse(queue.isFull());
		
		queue.enqueue("mini");
		
		assertFalse(queue.isFull());
		
		for (int i = 0; i < 10000; i++) {
			queue.enqueue(i);
		}
		
		assertFalse(queue.isFull());
	}
	
	@Test
	public void monitor(){
		MonitorQueue monitor = new MonitorQueue();
		monitor.enqueue("golf");
		monitor.enqueue(1);
		
		monitor.dequeue();
		
		assertEquals(2, monitor.waterMark());
		
		monitor.enqueue("yaris");
		
		assertEquals(2, monitor.waterMark());
	}
}
