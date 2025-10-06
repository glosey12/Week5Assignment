public class arrayBoundedQueue<T> {
    private T[] elements;
    private int front=0;
    private int rear=0;
    private int count=0;
    private int capactiy =3;

    public arrayBoundedQueue(int capacity){
        this.capactiy= capacity;
        elements =(T[]) new Object[capactiy];
       // rear=capactiy-1;
    }
    public T dequeue(){
        T temp = elements[front];
        if(front==capactiy-1){
            front=0;
            count --;
            return temp;
         }
         front ++;
         return temp;
    }
    public void enqueue(T item){
        if(rear==capactiy-1){
            rear=0;
            elements[rear]=item;
            return;
        }
        rear++;
        elements[rear]=item;
        count++;
        return;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public boolean isFull(){
        return count==capactiy;
    }
    public Integer length(){
        return count;
    }
    
}
