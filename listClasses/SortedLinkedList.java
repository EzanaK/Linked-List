package listClasses;

import static org.junit.Assert.fail;

import java.util.*;


/**
 * Implements a generic sorted list using a provided Comparator. It extends
 * BasicLinkedList class.
 * 
 *  @author Dept of Computer Science, UMCP
 *  
 */

public class SortedLinkedList<T> extends BasicLinkedList<T> {
	private Comparator<T> comparator;
	
	public SortedLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	public SortedLinkedList<T> add​(T element) {
		Node newNode = new Node(element);
		if (listSize == 0) {
			head = newNode;
			tail = newNode;
			listSize++;
		} else {
			Node cur = head;
			if (comparator.compare(element, cur.data) <= 0) {
				head = newNode;
				newNode.next = cur;
				listSize++;
				return this;
			} else if (listSize == 1 && comparator.compare(element, cur.data) > 0) {
				tail = newNode;
				cur.next = newNode;
				listSize++;
				return this;
			}
			while (cur != null) {
				if (cur == tail) {
					tail = newNode;
					cur.next = newNode;
					listSize++;
					break;
				} else if (comparator.compare(element, cur.data) > 0 && comparator.compare(element, cur.next.data) <= 0) {
					newNode.next = cur.next;
					cur.next = newNode;
					listSize++;
					break;
				}
				cur = cur.next;
			}
		}
		return this;
	}
	
	public SortedLinkedList<T> remove​(T targetData) {
		return (SortedLinkedList<T>) super.remove​(targetData, comparator);
	}
	
	@Override
	public BasicLinkedList<T> addToEnd​(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
	@Override
	public BasicLinkedList<T> addToFront​(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
	}
	
}