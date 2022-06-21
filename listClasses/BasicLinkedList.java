package listClasses;

import java.util.*;

public class BasicLinkedList<T> implements Iterable<T> {
	
	/* Node definition */
	protected class Node {
		protected T data;
		protected Node next;

		protected Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/* We have both head and tail */
	protected Node head, tail;
	
	/* size */
	protected int listSize;
	
	public BasicLinkedList() {
		head = null;
		tail = null;
		listSize = 0;
	}
	
	public int getSize() {
		return listSize;
	}
	
	public BasicLinkedList<T> addToEnd​(T data) {
		Node node = new Node(data);
		if (listSize == 0) {
			head = node;
			tail = node;
			listSize++;
			return this;
		} else {
			tail.next = node;
			tail = node;
			listSize++;
			return this;
		}
	}
	
	public BasicLinkedList<T> addToFront​(T data) {
		Node node = new Node(data);
		if (listSize == 0) {
			head = node;
			tail = node;
			listSize++;
			return this;
		} else {
			node.next = head;
			head = node;
			listSize++;
			return this;
		}
	}
	
	public T getFirst() {
		if (listSize == 0) {
			return null;
		}
		else {
			return head.data;
		}
	}
	
	public T getLast() {
		if (listSize == 0) {
			return null;
		}
		else {
			return tail.data;
		}
	}
	
	public T retrieveFirstElement() {
		if (listSize == 0) {
			return null;
		} else if (listSize == 1) {
			T firstElement = head.data;
			head = null;
			tail = null;
			listSize--;
			return firstElement;
		} else {
			T firstElement = head.data;
			head = head.next;
			listSize--;
			return firstElement;
		}
	}
	
	public T retrieveLastElement() {
		if (listSize == 0) {
			return null;
		} else if (listSize == 1) {
			T lastElement = head.data;
			head = null;
			tail = null;
			listSize--;
			return lastElement;
		} else {
			Node cur = head;
			while (cur.next != tail) {
				cur = cur.next;
			}
			T lastElement = tail.data;
			tail = cur;
			cur.next = null;
			listSize--;
			return lastElement;
		}
	}
	
	public BasicLinkedList<T> remove​(T targetData, Comparator<T> comparator) {
		if (listSize == 0) {
			return null;
		} else {
			Node cur = head;
			if (comparator.compare(cur.data, targetData) == 0) {
				head = cur.next;
				listSize--;
			}
			while (cur.next != null) {
				if (comparator.compare(cur.next.data, targetData) == 0) {
					if (cur.next == head) {
						head = cur.next.next;
						cur.next = cur.next.next;
					} else if (cur.next == tail) {
						tail = cur;
						cur.next = null;
					} else {
						cur.next = cur.next.next;
					}
					listSize--;
				} else {
					cur = cur.next;
				}
			}
			return this;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node curr = head;
			
			public boolean hasNext() {
				return curr != null;
			}
			
			public T next() {
				T toReturn = curr.data;
				curr = curr.next;
				return toReturn;
			}
		};
	}
	
	public ArrayList<T> getReverseArrayList() {
		ArrayList<T> arrayList = new ArrayList<>();
		BasicLinkedList<T> newList = getReverseList();
		Node cur = newList.head;
		return getReverseArrayListAux(newList, arrayList, cur);
	}
	
	private ArrayList<T> getReverseArrayListAux(BasicLinkedList<T> linkedList, ArrayList<T> arrayList, Node cur) {
		if (cur == null) {
			return arrayList;
		} else {
			arrayList.add(cur.data);
			return getReverseArrayListAux(linkedList, arrayList, cur.next);
		}
	}
	
	public BasicLinkedList<T> getReverseList() {
		BasicLinkedList<T> newList = new BasicLinkedList<T>();
		Node cur = head;
		return getReverseListAux(newList, cur);
	}
	
	private BasicLinkedList<T> getReverseListAux(BasicLinkedList<T> newList, Node cur) {
		if (cur == null) {
			return newList;
		} else {
			newList.addToFront​(cur.data);
			return getReverseListAux(newList, cur.next);
		}
	}
	
	@Override
	public String toString() {
		StringBuffer strB = new StringBuffer();
		strB.append("List Size = " + listSize + "\n");
		if (listSize == 0) {
			return strB.toString();
		} else {
			Node cur = head;
			while (cur != null) {
				strB.append(cur.data.toString() + "\n");
				cur = cur.next;
			}
			return strB.toString();
		}
	}
	
}