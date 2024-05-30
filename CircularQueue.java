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
      return SIZE;
   }
   public void enqueue(Item item){
      if (isFull()) {
      System.out.println("Queue is full");
    } else {
      if (front == -1)
        front = 0;
      rear = (rear + 1) % SIZE;
      items[rear] = element;
      System.out.println("Inserted " + element);
    }
   }
   
   public Item dequeue(){
         int element;
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return (-1);
    } else {
      element = items[front];
      if (front == rear) {
        front = -1;
        rear = -1;
      } /* Q has only one element, so we reset the queue after deleting it. */
      else {
        front = (front + 1) % SIZE;
      }
      return (element);
    }
   }
   public Item peek(){

   }
   public String toString(){

   }
}
