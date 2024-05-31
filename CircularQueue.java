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
}
