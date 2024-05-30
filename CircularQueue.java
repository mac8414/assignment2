package a02;

public class CircularQueue<Item> implements Iterable<Item> {
   private int SIZE; // Size of Circular Queue
   private int front, rear;
   private int capacity;
   private Item[] items;
   
   
   CircularQueue(int capacity){
       this.capacity = capacity;
       this.SIZE = 0;
       this.front = -1;
       this.rear = -1;
       this.items = (Item[]) new Object[capacity]; 
   }  
   public boolean isFull(){
    if (front == 0 && rear == SIZE - 1) {
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
   }
   public void enqueue(Item item)
   public Item dequeue()
   public Item peek()
   public String toString()
}
