import java.util.Iterator;
import java.util.ListIterator;
/** 
   A demo program that demonstrates the class ArrayListWithListIterator.
   
*/
public class Demo 
{
	public static void main(String[] args) 
	{
		testIteratorOperations();
		testAddAndSet();
		testIllegalOps();
		System.out.println("\n\nDone.");
	}  // end main

	public static void testIteratorOperations()
	{
      System.out.println("Testing add to end to create the list Jess, Jim, Josh");
		ListWithListIteratorInterface<String> nameList = new ArrayListWithListIterator<>();
      nameList.add("Jess");
		nameList.add("Jim");
		nameList.add("Josh");
      displayList(nameList);
      System.out.println("\n------------------------\n");

		System.out.println("Testing ListIterator's methods hasNext, next, nextIndex, hasPrevious, previous, and previousIndex:");
		ListIterator<String> traverse = nameList.getIterator();

		System.out.println("nextIndex     " + traverse.nextIndex()     + "    " + "should be 0");
		System.out.println("hasNext       " + traverse.hasNext()       + " "    + "should be true");
		System.out.println("previousIndex " + traverse.previousIndex() + " "    + "should be -1");
		System.out.println("hasPrevious   " + traverse.hasPrevious()   + "  "   + "should be false");
		System.out.println();
		
		System.out.println("next      " + traverse.next()      + "      " + "should be Jess");
		System.out.println("nextIndex " + traverse.nextIndex() + " " + "should be 1");
		System.out.println("hasNext   " + traverse.hasNext()   + "   " + "should be true");
		System.out.println();

		System.out.println("previousIndex " + traverse.previousIndex() + " "          + "should be 0");
		System.out.println("hasPrevious   " + traverse.hasPrevious()   + "   "        + "should be true");
		System.out.println("previous      " + traverse.previous()      + "      "     + "should be Jess");
		System.out.println("nextIndex     " + traverse.nextIndex()     + "     "      + "should be 0");
		System.out.println("hasNext       " + traverse.hasNext()       + "       "    + "should be true");
		System.out.println("next          " + traverse.next()          + "          " + "should be Jess");
		System.out.println();
      System.out.println("\n------------------------\n");
// ---------------------------------------------------------------------------------------
		
      System.out.println("Testing add to end to create the list 15, 25, 35, 45, 55, 65, 75, 85, 95");
		ListWithListIteratorInterface<String> myList = new ArrayListWithListIterator<>();
		
      myList.add("15");
      myList.add("25");
      myList.add("35");
      myList.add("45");
		myList.add("55");
		myList.add("65");
		myList.add("75");
		myList.add("85");
		myList.add("95");
      displayList(myList);
      System.out.println("\n------------------------\n");
		System.out.println("Testing ListIterator's hasNext and next methods:");
		
		System.out.println("\n\nList should contain\n15 25 35 45 55 65 75 85 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
      System.out.println("\n------------------------\n");
		
		System.out.println("\n\nUsing ListIterator methods, the list contains");
		ListIterator<String> myIterator = myList.getIterator();

		while (myIterator.hasNext())
			System.out.print(myIterator.next() + " ");
		System.out.println();
      System.out.println("\n------------------------\n");
      System.out.println();
		
      myIterator = myList.getIterator();
		System.out.println("Removing current entry : " + myIterator.next() + " should be 15");
		myIterator.remove();  // Remove entry 1
      
		System.out.println("List should contain\n25 35 45 55 65 75 85 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
      System.out.println("\n------------------------\n");
		
		System.out.println("Removing current entry: " + myIterator.next() + " should be 25");
		myIterator.remove();
      
		System.out.println("List should contain\n35 45 55 65 75 85 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
      System.out.println("\n------------------------\n");
		
		// Advance twice
		System.out.println("Skipping over " + myIterator.next() + " should be 35");
		
		System.out.println("Removing current entry: " + myIterator.next() + " should be 45");
		myIterator.remove();
      
		System.out.println("List should contain\n35 55 65 75 85 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
      System.out.println("\n------------------------\n");

		// Advance 3 times
		System.out.println("Skipping over " + myIterator.next() + " should be 55");
		System.out.println("Skipping over " + myIterator.next() + " should be 65");
		System.out.println("Skipping over " + myIterator.next() + " should be 75");
      
		System.out.println("Removing current entry: " + myIterator.next() + " should be 85");
		myIterator.remove();
      
		System.out.println("List should contain\n35 55 65 75 95");
		System.out.println("\n\nUsing ADT list operations, the list contains ");
		displayList(myList);
      System.out.println("\n------------------------\n");
		
		System.out.println("next() should return 95 : " + myIterator.next());
		System.out.println("hasNext() should return false : " + myIterator.hasNext());
		System.out.println("----------------------\n\n");

		System.out.println("The iterator is at the end of the list.\n" +
		                   "Testing ListIterator's hasPrevious and previous methods\n" +
		                   "by traversing backward:\n");
		while (myIterator.hasPrevious())
			System.out.print(myIterator.previous() + " ");
		System.out.println("\n");

		System.out.println("The iterator is at the beginning of the list.\n" +
		                   "Testing ListIterator's hasNext and next methods\n" +
		                   "by traversing forward:\n");
		while (myIterator.hasNext())
			System.out.print(myIterator.next() + " ");
		System.out.println("\n");

		System.out.println("----------------------\n\n");
     
      System.out.println("\n\nUsing Iterator methods, the list contains");
		ListIterator<String> yourIterator = myList.getIterator();
      
		while (yourIterator.hasNext())
			System.out.print(yourIterator.next() + " ");
		System.out.println();
		System.out.println();
		System.out.println("\n\nTesting ListIterator's remove() method:");
		System.out.println("\n\nReturn iterator to beginning of list\n");
		myIterator = myList.getIterator(); // Reset iterator to beginning
      System.out.println("\n------------------------\n");
	} // end testIteratorOperations

	public static void testAddAndSet()
	{
		System.out.println("Testing ListIterator's add, hasNext, nextIndex, hasPrevious, and previousIndex methods:\n");
		ListWithListIteratorInterface<String> myList = new ArrayListWithListIterator<String>();
		ListIterator<String> traverse = myList.getIterator();

		myList.add("Jamie");
		myList.add("Doug");
		myList.add("Jill");

		System.out.println("List should contain\nJamie Doug Jill \n ");
		System.out.println("List actually contains");
		displayList(myList);
      System.out.println("\n------------------------\n");
		
		System.out.println();

		System.out.println("nextIndex = " + traverse.nextIndex() + "; should be 0");
		System.out.println("hasNext = " + traverse.hasNext() + "; should be true");
		System.out.println("previousIndex = " + traverse.previousIndex() + "; should be -1");
		System.out.println("hasPrevious = " + traverse.hasPrevious() + "; should be false");

		System.out.println();

		System.out.println("next = " + traverse.next() + "; should be Jamie");
		System.out.println("nextIndex = " + traverse.nextIndex() + "; should be 1");
		System.out.println("hasNext = " + traverse.hasNext() + "; should be true");
		
		System.out.println();

		System.out.println("previousIndex " + traverse.previousIndex() + "; should be 0");
		System.out.println("hasPrevious   " + traverse.hasPrevious() + "; should be true");
		System.out.println("previous      " + traverse.previous() + "; should be Jamie");
		System.out.println("nextIndex     " + traverse.nextIndex() + "; should be 0");
		System.out.println("hasNext       " + traverse.hasNext() + "; should be true");
		System.out.println("next          " + traverse.next() + "; should be Jamie");
      System.out.println("\n------------------------\n");
		
// Test set
      System.out.println("Testing ListIterator's set method:\n");
      System.out.println("\n\nReplace entry that next() just returned with Bob:");
		traverse.set("Bob");
		displayList(myList);
      
		System.out.println("previousIndex " + traverse.previousIndex() + "    " + "should be 0");
		System.out.println("hasPrevious   " + traverse.hasPrevious()   + " "    + "should be true");;

		System.out.println("nextIndex     " + traverse.nextIndex()     + "    " + "should be 1");
		System.out.println("hasNext       " + traverse.hasNext()       + " "    + "should be true");
		displayList(myList);

// Test add
      System.out.println("Testing ListIterator's add method:\n");
		System.out.println("Before add");

		System.out.println("nextIndex     " + traverse.nextIndex()     + " should be 1");
		System.out.println("previousIndex " + traverse.previousIndex() + " should be 0");

		System.out.println("add Kerry before (or at) position " + (1+traverse.nextIndex()));
		traverse.add("Kerry");
		displayList(myList);
		
		System.out.println("After add");
		System.out.println("nextIndex     " + traverse.nextIndex() + " should be 2");
		System.out.println("previousIndex " + traverse.previousIndex() + " should be 1");
      
		System.out.println("======================================================");
		System.out.println("======================================================");
		
// Choose 1 of the following groups:
		System.out.println("next          " + traverse.next() + " should be Doug");
		traverse.remove();
		System.out.println("After removing Doug");
		displayList(myList);

/*
		System.out.println("previous      " + traverse.previous() + " should be Kerry");
		traverse.remove();
		System.out.println("After removing Kerry");
		displayList(myList);
*/
		System.out.println("======================================================");
		System.out.println("======================================================");
		myList.clear();

		myList.add("Bob");
		myList.add("Kerry");
		myList.add("Doug");
		myList.add("Jill");
		displayList(myList);
		traverse = myList.getIterator();
		System.out.println(traverse.next());
		System.out.println(traverse.next());
// Current is Doug
		traverse.previous(); // Move back to Kerry
		traverse.remove();   // Remove Kerry
		displayList(myList);

	} // end testAddAndSet
	
	public static void testIllegalOps()
	{
		System.out.println("\nTesting sequences of operations on a new list:\n");

		ListWithListIteratorInterface<String> myList = new ArrayListWithListIterator<>();
		ListIterator<String> traverse = myList.getIterator();

		myList.add("Jamie");
		myList.add("Doug");
		myList.add("Jill");

		System.out.println("List should contain\nJamie Doug Jill \n ");
		System.out.println("List actually contains");
		displayList(myList);
		
		System.out.println();

		System.out.println("The sequence next, set, set, remove is legal.");
		traverse.next();
		traverse.set("XX");
		traverse.set("XX");
		traverse.remove();

		System.out.print("\nThe following sequence is illegal and causes an exception:");

// Choose one sequence to test; disable the others
/*
// 1
		System.out.println(" next, remove, remove\n");
		traverse.next();
		traverse.remove();
		traverse.remove();

// 2
		System.out.println(" previous, remove, remove\n");
		traverse.previous();
		traverse.remove();
		traverse.remove();

// 3
		System.out.println(" previous, set, remove\n");
		traverse.previous();
		traverse.set("XX");
		traverse.remove();

// 4
		System.out.println(" previous, add, remove\n");
		traverse.previous();
		traverse.add("YY");
		traverse.remove();

// 5
		System.out.println(" next, set, add, remove\n");
		traverse.next();
		traverse.set("XX");
		traverse.add("XX");
		traverse.remove();
*/
// 6
		System.out.println(" next, set, add, set\n");
		traverse.next();
		traverse.set("XX");
		traverse.add("XX");
		traverse.set("ZZ");

	} // end testIllegalOps
	
	public static void displayList(ListInterface<String> aList)
	{
      int numberOfEntries = aList.getLength();
      System.out.println();
      for (int position = 1; position <= numberOfEntries; ++position)
         System.out.print(aList.getEntry(position) + " ");
      System.out.println();
	}  // end displayList
}  // end Demo

