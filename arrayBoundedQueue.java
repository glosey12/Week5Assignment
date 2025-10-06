public class arrayBoundedQueue<T> {
    private T[] elements;
    private int front=0;
    private int rear=0;
    private int count=0;
    private int capacity =3;

    public arrayBoundedQueue(int capacity){
        this.capacity= capacity;
        elements =(T[]) new Object[capacity];

       // rear=capacity-1;
    }
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        T temp = elements[front];
        front =(front+1)% capacity;
        count--;
        return temp;
    }
    public void enqueue(T item){
        if(isFull()){
            return;
        }
        elements[rear]=item;
        rear=(rear+1)% capacity;
        count++;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public boolean isFull(){
        return count==capacity;
    }
    public Integer length(){
        return count;
    }
    
}
