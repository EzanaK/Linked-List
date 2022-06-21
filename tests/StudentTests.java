package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

/**
 * 
 * You need student tests if you are looking for help during office hours about
 * bugs in your code.
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	@Test
	public void testingBasicLinkedListConstructorAndGetSize() {
		BasicLinkedList<String> stringList = new BasicLinkedList<>();
		assertTrue(stringList.getSize() == 0);
		System.out.println(stringList.toString());
	}
	
	@Test
	public void testingBasicLinkedListAddToEndAndAddToFront() {
		BasicLinkedList<String> stringList = new BasicLinkedList<>();
		stringList.addToFront​("first added to front");
		stringList.addToFront​("second added to front");
		stringList.addToEnd​("first added to end");
		stringList.addToEnd​("second added to end");
		assertTrue(stringList.getSize() == 4);
		System.out.println(stringList.toString());
	}
	
	@Test
	public void testingGetFirstAndGetLast() {
		BasicLinkedList<String> stringList = new BasicLinkedList<>();
		stringList.addToFront​("first added to front");
		stringList.addToFront​("second added to front");
		stringList.addToEnd​("first added to end");
		stringList.addToEnd​("second added to end");
		assertTrue(stringList.getFirst().equals("second added to front"));
		assertTrue(stringList.getLast().equals("second added to end"));
		assertTrue(stringList.getSize() == 4);
		System.out.println(stringList.toString());
	}
	
	@Test
	public void testingRetrieveMethods() {
		BasicLinkedList<String> stringList = new BasicLinkedList<>();
		stringList.addToFront​("first added to front");
		stringList.addToFront​("second added to front");
		stringList.addToEnd​("first added to end");
		stringList.addToEnd​("second added to end");
		assertTrue(stringList.retrieveFirstElement().equals("second added to front"));
		assertTrue(stringList.retrieveLastElement().equals("second added to end"));
		assertTrue(stringList.getSize() == 2);
		System.out.println(stringList.toString());
	}
	
	@Test
	public void testingBasicLinkedListRemove() {
		BasicLinkedList<String> stringList = new BasicLinkedList<>();
		stringList.addToFront​("*");
		stringList.addToFront​("@");
		stringList.addToFront​("@");
		stringList.addToFront​("*");
		stringList.addToFront​("*");
		stringList.addToFront​("*");
		stringList.addToEnd​("@");
		stringList.addToEnd​("@");
		stringList.addToEnd​("*");
		stringList.addToEnd​("*");
		stringList.addToEnd​("*");
		System.out.println(stringList.toString() + "\n");
		Comparator<String> caseInsensitiveComparator = String.CASE_INSENSITIVE_ORDER;
		stringList.remove​("*", caseInsensitiveComparator);
		assertTrue(stringList.getSize() == 4);
		System.out.println(stringList.toString());
	}
	
	@Test
	public void testingIterator() {
		BasicLinkedList<String> stringList = new BasicLinkedList<>();
		stringList.addToFront​("first added to front");
		stringList.addToFront​("second added to front");
		stringList.addToEnd​("first added to end");
		stringList.addToEnd​("second added to end");
		StringBuffer strB = new StringBuffer();
		for (String str : stringList) {
			strB.append(str + "\n");
		}
		System.out.print(strB.toString());
		assertTrue(strB.toString().equals("second added to front\nfirst added to front\nfirst added to end\nsecond added to end\n"));
	}
	
	@Test
	public void testingGetReverseList() {
		BasicLinkedList<String> stringList = new BasicLinkedList<>();
		stringList.addToEnd​("1");
		stringList.addToEnd​("2");
		stringList.addToEnd​("3");
		stringList.addToEnd​("4");
		stringList.addToEnd​("5");
		System.out.println(stringList.toString());
		BasicLinkedList<String> newstrList = stringList.getReverseList();
		System.out.println(newstrList.toString());
		assertTrue(newstrList.toString().equals("List Size = 5\n5\n4\n3\n2\n1\n"));
	}
	
	@Test
	public void testingGetReverseArrayList() {
		BasicLinkedList<String> stringList = new BasicLinkedList<>();
		stringList.addToEnd​("1");
		stringList.addToEnd​("2");
		stringList.addToEnd​("3");
		stringList.addToEnd​("4");
		stringList.addToEnd​("5");
		System.out.println(stringList.toString());
		ArrayList<String> arrayList = stringList.getReverseArrayList();
		System.out.println(arrayList.toString());
		assertTrue(arrayList.toString().equals("[5, 4, 3, 2, 1]"));
	}
	
	@Test
	public void testingSortedLinkedListConstructor() {
		Comparator<String> caseInsensitiveComparator = String.CASE_INSENSITIVE_ORDER;
		SortedLinkedList<String> sortedStringList = new SortedLinkedList<>(caseInsensitiveComparator);
		assertTrue(sortedStringList.getSize() == 0);
		System.out.println(sortedStringList.toString());
	}
	
	@Test
	public void testingSortedLinkedListAdd() {
		Comparator<String> caseInsensitiveComparator = String.CASE_INSENSITIVE_ORDER;
		SortedLinkedList<String> sortedStringList = new SortedLinkedList<>(caseInsensitiveComparator);
		sortedStringList.add​("dog");
		sortedStringList.add​("cat");
		sortedStringList.add​("cow");
		sortedStringList.add​("horse");
		sortedStringList.add​("armadillo");
		sortedStringList.add​("lion");
		sortedStringList.add​("cat");
		sortedStringList.add​("kangaroo");
		sortedStringList.add​("zebra");
		assertTrue(sortedStringList.toString().equals("List Size = 9\narmadillo\ncat\ncat\ncow\ndog\nhorse\nkangaroo\nlion\nzebra\n"));
		System.out.println(sortedStringList.toString());
	}
	
	@Test
	public void testingSortedLinkedListRemove() {
		Comparator<String> caseInsensitiveComparator = String.CASE_INSENSITIVE_ORDER;
		SortedLinkedList<String> sortedStringList = new SortedLinkedList<>(caseInsensitiveComparator);
		sortedStringList.add​("dog");
		sortedStringList.add​("cat");
		sortedStringList.add​("cow");
		sortedStringList.add​("horse");
		sortedStringList.add​("armadillo");
		sortedStringList.add​("lion");
		sortedStringList.add​("kangaroo");
		sortedStringList.add​("zebra");
		sortedStringList.remove​("dog");
		assertTrue(sortedStringList.toString().equals("List Size = 7\narmadillo\ncat\ncow\nhorse\nkangaroo\nlion\nzebra\n"));
		System.out.println(sortedStringList.toString());
	}
	
	@Test
	public void testingSortedLinkedListAddToFront() {
		Comparator<String> caseInsensitiveComparator = String.CASE_INSENSITIVE_ORDER;
		SortedLinkedList<String> sortedStringList = new SortedLinkedList<>(caseInsensitiveComparator);
		try {
			sortedStringList.addToFront​("dog");
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Invalid operation for sorted list."));
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testingSortedLinkedListAddToEnd() {
		Comparator<String> caseInsensitiveComparator = String.CASE_INSENSITIVE_ORDER;
		SortedLinkedList<String> sortedStringList = new SortedLinkedList<>(caseInsensitiveComparator);
		try {
			sortedStringList.addToEnd​("dog");
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("Invalid operation for sorted list."));
			System.out.println(e.getMessage());
		}
	}

}
