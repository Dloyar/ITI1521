/**
 * The class <b>CircularQueue</b>
 * @author Rayold Rakotonomenjanahary
 * @author Sydroy Rakotonomenjanahary
 */
public class LinkedQueue<E> implements Queue<E> { 
    private int capacity = 1000; 
    private E[] elems; 
    private int front, rear; 
 
	/**
	*Constructor
	*/
    @SuppressWarnings("unchecked") 
    public LinkedQueue() { 

       elems = (E[])new Object[capacity]; 
       rear = -1; 
       front = 0; 

   } 

   /**
	*Constructor
	*@param capacity
	*/
    @SuppressWarnings("unchecked") 
    public LinkedQueue(int capacity) { 

       this.capacity = capacity; 
       elems = (E[])new Object[capacity]; 
       front = 0; 
	   rear = -1; 
    } 

	/**
	*verifie si la file est vide
	*@return null si la file est vide
	*/
    public boolean isEmpty() { 
        return rear == -1; 
    } 

    public boolean isFull(){ 

        return (rear != -1) && ((rear+1)%capacity == front); 

    } 

    /**
	*methode pour ajouter un elements a l'arriere d'une file
	*@param value 
	*/
    public void enqueue( E value) { 

        if(value == null) { 
            throw new NullPointerException("no null object in my queue !"); 
        } 
 
		if(isFull()){ 
            throw new IllegalStateException("Queue full!"); 
        } 

        rear = (rear + 1)% capacity; 
        elems[rear] = value; 
    } 
 
	/**
	*Method pour voir la valeur en avant de la file
	*@return l'element en avant de la file
	*/
    public E peek() { 
        if(isEmpty()){ 
            throw new IllegalStateException("Queue empty!"); 
        } 
        return elems[front]; 
    } 

	/**
	*Methode pour enlever un elements a l'avant de la pile
	*@return saved la valeur de l'element enlever
	*/
    public E dequeue() { 
        if(isEmpty()){ 
            throw new IllegalStateException("Queue empty!"); 
        } 
        E saved = elems[front]; 
        elems[front] = null; 
        if(front == rear) { 
            rear = -1; 
            front = 0; 
        } else { 
            front = (front+1)% capacity;  
        }        
        return saved; 
    } 
} 