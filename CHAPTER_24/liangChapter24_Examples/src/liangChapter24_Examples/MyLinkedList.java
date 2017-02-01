package liangChapter24_Examples;

import java.util.ArrayList;

public class MyLinkedList<E> extends MyAbstractList<E> {
	private Node<E> head, tail;

	ArrayList<E> linkedList = new ArrayList<>(); // Use composition


	/** Create a default list */
	public MyLinkedList() {
	}

	/** Create a list from an array of objects */
	public MyLinkedList(E[] objects) {
		super(objects);
	}

	/** Return the head element in the list */
	public E getFirst() {
		if (size == 0) {
			return null;
		}
		else {
			return head.element;
		}
	}

	/** Return the last element in the list */
	public E getLast() {
		if (size == 0) {
			return null;
		}
		else {
			return tail.element;
		}
	}

	/** Add an element to the beginning of the list */
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // the new node is the only node in list
			tail = head;
	}

	/** Add an element to the end of the list */
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new for element e

		if (tail == null) {
			head = tail = newNode; // The new node is the only node in list
		}
		else {
			tail.next = newNode; // Link the new with the last node
			tail = tail.next; // tail now points to the last node
		}

		size++; // Increase size
	}


	@Override /** Add a new element at the specified index 
	 * in this list. The index of the head element is 0 */
	public void add(int index, E e) {
		if (index == 0) {
			addFirst(e);
		}
		else if (index >= size) {
			addLast(e);
		}
		else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}
	}

	/** Remove the head node and
	 *  return the object that is contained in the removed node. */
	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp.element;
		}
	}

	/** Remove the last node and
	 * return the object that is contained in the removed node. */
	public E removeLast() {
		if (size == 0) {
			return null;
		}
		else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	@Override /** Remove the element at the specified position in this 
	 *  list. Return the element that was removed from the list. */
	public E remove(int index) {   
		if (index < 0 || index >= size) { // Checks boundary cases
			return null;
		}
		else if (index == 0) {
			return removeFirst();
		}
		else if (index == size - 1) {
			return removeLast();
		}
		else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	@Override /** Override toString() to return elements in the list */
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			}
			else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	@Override /** Clear the list */
	public void clear() {
		size = 0;
		head = tail = null;
	}

	@Override /** Return true if this list contains the element e */
	public boolean contains(E e) {
		if(head == null) {
			System.out.println(" List is empty!");
			return false;
		}
		else {
			Node<E> tempHead = head;
			while(tempHead != null) {
				linkedList.add(tempHead.element);
				tempHead = tempHead.next;
			}

			for(E element: linkedList) {
				if(element.equals(e)) {
					System.out.println("\n" + element + " was found succesfully!");
					return true;
				}
			}

			//System.out.println("Implementation left as an exercise");
		}

		System.out.println("\n" + e + " doesn't exist!");
		return false;
	}

	@Override /** Return the element at the specified index */
	public E get(int index) {
		if (index < 0 || index >= size) { // Checks boundary cases
			return null;
		}
		else {
			for(int i = 0; i < linkedList.size(); i++) {
				if(i == index) {
					return linkedList.get(i);
				}
			}
		}
		//System.out.println("Implementation left as an exercise");
		return null;
	}

	@Override /** Return the index of the head matching element in 
	 *  this list. Return -1 if no match. */
	public int indexOf(E e) {
		if(e == null) {
			System.out.println("Invalid value!");
			return -1;
		} else {
			if(linkedList != null) { // Reuse helper method here
				for(int index = 0; index < linkedList.size(); index++) {
					if(linkedList.contains(e)) {
						return index;
					}
				}
			} else {
				return -1;
			}
		}
		//System.out.println("Implementation left as an exercise");
		return 0;
	}

	@Override /** Return the index of the last matching element in 
	 *  this list. Return -1 if no match. */
	public int lastIndexOf(E e) {
		if(e == null) {
			System.out.println("Invalid value!");
			return -1;
		} else {
			if(linkedList != null) { // Reuse helper method here
				for(int index = linkedList.size() - 1; index >= 0; index--) {
					if(linkedList.contains(e)) {
						return index;
					}
				}
			} else {
				return -1;
			}
		}
		//System.out.println("Implementation left as an exercise");
		return 0;
	}

	@Override /** Replace the element at the specified position 
	 *  in this list with the specified element. */
	public E set(int index, E e) {
		if(index < 0 || index >= linkedList.size()) { // assume first 
			System.out.println("Invalid index! ");    // element index  
												      // is 0	       
		} else {
			E oldValue = linkedList.get(index);
			
			linkedList.set(index, e);
			
			return oldValue;
		}
		//System.out.println("Implementation left as an exercise");
		return null;
	}

	@Override /** Override iterator() defined in Iterable */
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	@SuppressWarnings("unused")
	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException
			("Index: " + index + ", Size: " + size);
	}

	private class LinkedListIterator 
	implements java.util.Iterator<E> {
		private Node<E> current = head; // Current index 

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
			System.out.println("Implementation left as an exercise");
		}
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element) {
			this.element = element;
		}
	}
}