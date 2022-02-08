/**
 * The class <b>GenericArrayStack</b> provides the current view of the entire Game. It extends
 * @author Rayold Rakotonomenjanahary(rrako090@uottawa.ca)
 * @author Sydroy Rakotonomenjanahary(srako102@uottawa.ca)
 */
public class GenericArrayStack<E> implements Stack<E> {
   
   private E[] elems;
    private int top;

   // Constructor
    public GenericArrayStack( int capacity ) {
		elems = (E[]) new Object[ capacity ];
        top = 0;



    }

    // Returns true if this ArrayStack is empty
    public boolean isEmpty() {
        
     return ( top == 0 );


    }

    public void push( E elem ) {
        
		if (top == elems.length) {
			E[] newArray;
			newArray = (E[]) new Object[ elems.length * 2 ];
			for (int i=0; i<top; i++) {
				newArray[i] = elems[i];
			}
			elems = newArray;
		}
	
        elems[ top++ ] = elem;


    }
    public E pop() {
        
		E saved = elems[ --top ];
        elems[ top ] = null;
        return saved;


    }

    public E peek() {
        
		return elems[ top-1 ];

    }
}
