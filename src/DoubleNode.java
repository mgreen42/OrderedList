public class DoubleNode<T> {

    private DoubleNode<T> previous;
    private DoubleNode<T> next;
    private T element;

    public DoubleNode(){
        previous = null;
        next = null;
        element = null;
    }

    public DoubleNode(T elem){
        previous = null;
        next = null;
        element = elem;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public T getElement() {
        return element;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public void setElement(T elem) {
        this.element = elem;
    }
}
