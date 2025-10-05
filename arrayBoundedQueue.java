public class arrayBoundedQueue<T> {
    private T[] elements;
    private int front;
    private int rear;
    private int count;
    private int DEFCAP =3;

    public arrayBoundedQueue(){
        elements =(T[]) new Object[DEFCAP];
        rear=DEFCAP-1;
    }
    public T dequeue(){
        T temp = elements[front];
        if(front==DEFCAP-1){
            front=0;
            return temp;
         }
         front ++;
         return temp;
    }
    public void enqueue(T item){
        if(rear==DEFCAP-1){
            rear=0;
            elements[rear]=item;
            return;
        }
        rear++;
        elements[rear]=item;
        return;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public boolean isFull(){
        return count==DEFCAP;
    }
    public Integer length(){
        return count;
    }
    
}
