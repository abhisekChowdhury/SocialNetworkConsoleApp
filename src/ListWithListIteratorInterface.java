import java.util.ListIterator;
/**
   An interface for the ADT list that has an iterator implementing 
   the interface ListIterator.

*/
public interface ListWithListIteratorInterface<T> extends Iterable<T>, ListInterface<T>
{
   public ListIterator<T> getIterator();
} // end ListWithListIteratorInterface
