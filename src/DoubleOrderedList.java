


/**
 * LinkedOrderedList represents a singly linked implementation of an
 * ordered list.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class DoubleOrderedList<T> extends DoubleList<T> implements OrderedListADT<T>
{
    /**
     * Creates an empty list.
     */
    public DoubleOrderedList()
    {
        super();
    }

    /**
     * Adds the specified element to this list at the location determined by
     * the element's natural ordering. Throws a NonComparableElementException
     * if the element is not comparable.
     *
     * @param element the element to be added to this list
     * @throws NonComparableElementException if the element is not comparable
     */
    public void add(T element) throws NonComparableElementException
    {
        if(!(element instanceof Comparable))
            throw new NonComparableElementException("Double Ordered List");

        Comparable<T> comparableElement = (Comparable<T>) element;
        DoubleNode<T> newElement = new DoubleNode<T>(element);

        if(isEmpty()) {
            head = tail = newElement;
        }
        else{
            T currentComparable = head.getElement();
            DoubleNode<T> current = head;

            while(current.getNext() != null && comparableElement.compareTo(currentComparable) > 0){
                current = current.getNext();
                currentComparable = current.getElement();
            }
            if(comparableElement.compareTo(currentComparable) < 0){
                if(current != head){
                    current.getPrevious().setNext(newElement);
                    newElement.setPrevious(current.getPrevious());
                }
                else{
                    head = newElement;
                }
                current.setPrevious(newElement);
                newElement.setNext(current);
            }
            else{
                if(current == tail)
                    tail = newElement;
                current.setNext(newElement);
                newElement.setPrevious(current);
            }
        }
        count++;
    }
}