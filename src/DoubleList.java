/**
 * DoubleList represents a doubly linked implementation of a list.
 *
 * @author Madison Green, Lewis and Chase
 * @version 1.0
 */

public class DoubleList<T> implements ListADT<T>{

    protected int count;
    protected DoubleNode<T> head;
    protected DoubleNode<T> tail;

    public DoubleList(){
        head = null;
        tail = null;
        count = 0;
    }
    /**
     * Removes and returns the first element from this list.
     *
     * @throws EmptyCollectionException if the list is empty
     *
     * @return the first element from this list
     */
    public T removeFirst() throws EmptyCollectionException, NullPointerException{
        if(isEmpty())
            throw new EmptyCollectionException("Double Ordered List");

        T result = head.getElement();
        count--;

        if(head.getNext() == null){
            head = tail = null;
            return result;
        }

        head = head.getNext();
        head.setPrevious(null);
        return result;
    }

    /**
     * Removes and returns the last element from this list.
     * @throws EmptyCollectionException if list is empty
     *
     * @return the last element from this list
     */
    public T removeLast() throws EmptyCollectionException, NullPointerException{
        if(isEmpty())
            throw new EmptyCollectionException("Doubly Linked List");

        T result = tail.getElement();
        count--;

        if(tail.getPrevious() == null){
            head = tail = null;
            return result;
        }

        tail = tail.getPrevious();
        tail.setNext(null);
        return result;
    }

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     */
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException, NullPointerException{
        if(isEmpty())
            throw new EmptyCollectionException("Doubly Linked List");
        if(element == null){
            throw new NullPointerException();
        }

        DoubleNode<T> current = head;
        DoubleNode<T> previous = null;
        boolean found = false;

        while(current != null && !found){
            if(current.getElement().equals(element)){
                found = true;
            }
            else{
                previous = current;
                current = current.getNext();
            }
        }
        if(!found)
            throw new ElementNotFoundException("Doubly Linked List");
        if(size() == 1){
            System.out.println(1);
            head = tail = null;
        }
        else if(current.equals(head)){
            head = current.getNext();
            head.setPrevious(null);
        }
        else if(current.equals(tail)){
            tail = previous;
            tail.setNext(null);
        }
        else{
            previous.setNext(current.getNext());
            current.getNext().setPrevious(previous);
        }

        count--;
        return current.getElement();
    }

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    public T first(){
        if(head == null){
            return null;
        }
        DoubleNode<T> result = head;
        return result.getElement();
    }

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    public T last(){
        if(tail == null){
            return null;
        }
        DoubleNode<T> result = tail;
        return result.getElement();
    };

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @throws EmptyCollectionException if list if empty
     * @return true if the list contains this element
     */
    public boolean contains(T target) throws EmptyCollectionException, ElementNotFoundException, NullPointerException{
        if(isEmpty())
            throw new EmptyCollectionException("Doubly Linked List");
        if(target == null)
            throw new NullPointerException();
        DoubleNode<T> current = head;

        while(current != null){
            if(current.getElement().equals(target)){
                return true;
            }
            else{
                current = current.getNext();
            }
        }
            return false;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty(){
        if(count == 0)
            return true;
        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    public int size(){
        return count;
    }


    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    public String toString() throws EmptyCollectionException{
        String result = "";
        if(isEmpty())
            return "List is Empty";

        DoubleNode<T> current = head;

        while(current != null){
            result += current.getElement() + " ";
            current = current.getNext();
        }
        return result;
    }
}
