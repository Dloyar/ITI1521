/**
 * Interface for Queue
 * @author Rayold Rakotonomenjanahary(rrako090@uottawa.ca)
 * @author Sydroy Rakotonomenjanahary(srako102@uottawa.ca)
 */
public interface Queue<E> {
	boolean isFull();
    boolean isEmpty();
    void enqueue(E o);
    E dequeue();
}