package circularArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularQueue<Item> implements Iterable<Item> {
	   private int SIZE; // Size of Circular Queue
	   private int front, rear;
	   private int capacity;
	   private Item[] items;
	   
	   
	 @SuppressWarnings("unchecked")
	 CircularQueue(int capacity){
		 if (capacity == 0) {
			 throw new IllegalArgumentException("Capacity cannot be 0");
		 }
		   this.capacity = capacity;
	       this.SIZE = 0;
	       this.front = -1;
	       this.rear = -1;
	       this.items = (Item[]) new Object[capacity]; 
	   }  
	  
	 public boolean isFull(){
	    if (front == 0 && rear == capacity - 1) {
	      return true;
	    }
	    if (front == rear + 1) {
	      return true;
	    }
	    return false;
	  }
	     
	  public boolean isEmpty(){
	    if (front == -1)
	      return true;
	    else
	      return false;
	  }
	  
	  public int size(){
	      if (isEmpty()) {
	    	  return 0;
	      }
		  return SIZE;
	  }
	  
	  public void enqueue(Item item){
	      if (isFull()) {
	      System.out.println("Queue is full");
	    } else { 
	    	if (front == -1)
	    		front = 0;
	     
	    	rear = (rear + 1) % capacity;
	    	items[rear] = item;
	    	SIZE++;
	    }
	  }
	   
	  public Item dequeue(){
	    if (isEmpty()) {
	      return null;
	    } 
	    
	    Item element = items[front];
	    if (front == rear) {
	    	front = -1;
	    	rear = -1;
	    }
	    
	    else {
	    	front = (front + 1) % capacity;
	    }
	    
	    SIZE--;
	    return element;
	  }
	   
	   public Item peek(){
	      if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        return items[front];
	   }
	   
	   @Override
	   public String toString() {
	       if (isEmpty()) {
	           return "";
	       }
	       
	       StringBuilder message = new StringBuilder();
	       int i = front;
	       
	       do {
	           message.append(items[i]).append(" ");
	           i = (i + 1) % capacity;
	       } while (i != (rear + 1) % capacity);
	       
	       return message.toString();
	   }
	
	@Override
	public Iterator<Item> iterator() {
		return new CircularQueueIterator();
	}
	
	private class CircularQueueIterator implements Iterator<Item> {
        private int current = front;
        private int count = 0;
		
        @Override
		public boolean hasNext() {
			return count < SIZE;
		}
		
        @Override
		public Item next() {
			if (!hasNext()) {
                throw new NoSuchElementException();
            }
            
			Item item = items[current];
            current = (current + 1) % capacity;
            count++;
            
            return item;
        }
	}

	public static void main(String[] args) {
	
	
	 CircularQueue<String> q1 = new CircularQueue<>(3);
	
	
	
	 // isEmpty and isFull on an empty queue
     System.out.println("Is queue empty? " + q1.isEmpty()); // true
     
     System.out.println("Is queue full? " + q1.isFull());   // false
     
     System.out.println("Size: " + q1.size());              // 0
		
		
     //  enqueue testing
     
     q1.enqueue("1");
     
     System.out.println(q1.toString()); // 1
     
     q1.enqueue("2");
     
     System.out.println(q1.toString()); // 1 2
     
     q1.enqueue("3");
     
     System.out.println(q1.toString()); // 1 2 3
     
     
     // isFull after enqueue
     
     System.out.println("Is the queue full? " + q1.isFull()); // true
 	
 	
     // enqueue on a full queue
     
     q1.enqueue("4"); // Queue is full
     
     
     
     
     // Dequeue
     
     System.out.println("Dequeued: " + q1.dequeue()); // Dequeued: 1
     
     System.out.println(q1.toString());              // 2 3
     
     System.out.println("Dequeued: " + q1.dequeue()); //Dequeued: 2
     
     System.out.println(q1.toString());              // 3
     
     // size after dequeue
     System.out.println("Size: " + q1.size()); // Size: 1
     
     // Enqueue more items
     q1.enqueue("4");
     System.out.println(q1.toString()); // 3 4
     q1.enqueue("5");
     System.out.println(q1.toString()); // 3 4 5
     
     // peek
     System.out.println("Peek: " + q1.peek()); // Peek: 3
     
     // remaining items
     System.out.println("Dequeued: " + q1.dequeue()); // Dequeued: 3
     System.out.println("Dequeued: " + q1.dequeue()); // Dequeued: 4 
     System.out.println("Dequeued: " + q1.dequeue()); // Dequeued:  5
     
     // isEmpty after dequeue
     System.out.println("Is queue empty? " + q1.isEmpty()); // "Is queue empty? true
 	
	}
}
