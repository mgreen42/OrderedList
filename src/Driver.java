/**
 * DoubleOrderedList testing area.
 *
 * @author Madison Green, Acuna
 * @version 1,0
 */
public class Driver {
    public static void main(String [] args) {
        try{
            DoubleOrderedList<Integer> list = new DoubleOrderedList<>();

            list.add(2);
            list.add(1);

            //Basic operations
            System.out.println("\n");
            System.out.println("First List: " + list);
            System.out.println("First: " + list.first());
            System.out.println("Last: " + list.last());
            System.out.println("Contains 3: " + list.contains(3));
            System.out.println("Is empty: " + list.isEmpty());
            System.out.println("Size: " + list.size());
            System.out.println("\n");

            // Check for head = tail = null when removing last item
            list.remove(1);
            System.out.println("Second list: " + list);
            System.out.println("First: " + list.first());
            System.out.println("Last: " + list.last());
            list.removeFirst();
            System.out.println("Empty list: " + list);
            System.out.println("First: " + list.first());
            System.out.println("Last element: " + list.last());
            System.out.println("\n");

            //Catch illegal options
            //list.remove(1);
            //list.contains(null);
            //list.add(null);

            // Check adding to middle and removing from middle
            list.add(3);
            list.add(5);
            list.add(2);
            list.add(7);
            System.out.println("Third list: " + list);
            System.out.println("Size: " + list.size());
            list.remove(5);
            System.out.println("List w/o 5:  " + list);
            System.out.println("New size: " + list.size());
        }
        // Catching all exceptions
        catch(EmptyCollectionException| NullPointerException | ElementNotFoundException | NonComparableElementException ex){
            System.out.println("Catching all exceptions.");
        }

    }

}