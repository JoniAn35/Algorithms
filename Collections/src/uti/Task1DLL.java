package uti;

//A complete working Java program to demonstrate all

//Class for Doubly Linked List
public class Task1DLL {
	Node head; // head of list

	/* Doubly Linked list Node */
	class Node {
		int data;
		Node prev;
		Node next;

		// Constructor to create a new node
		// next and prev is by default initialized as null
		Node(int d) {
			data = d;
		}
	}

	// Adding a node at the front of the list
	public void push(int new_data) {
		/*
		 * 1. allocate node 2. put in the data
		 */
		Node new_Node = new Node(new_data);

		/* 3. Make next of new node as head and previous as NULL */
		new_Node.next = head;
		new_Node.prev = null;

		/* 4. change prev of head node to new node */
		if (head != null)
			head.prev = new_Node;

		/* 5. move the head to point to the new node */
		head = new_Node;
	}

	/*
	 * Given a node as prev_node, insert a new node after the given node
	 */
	// въвежда се предишен node, след който ще се вмъкне нов node
	public void insertAfter(Node prev_Node, int new_data) {

		/* 1. check if the given prev_node is NULL */
		// проверява се да не би дадения node да е нулев
		if (prev_Node == null) {
			System.out.println("The given previous node cannot be NULL ");
			return;
		}

		/*
		 * 2. allocate node 3. put in the data
		 */
		// създаване на нов node и подаване на параметър в конструктора му, който сме
		// от самия метод insertAfter
		Node new_node = new Node(new_data);

		/* 4. Make next of new node as next of prev_node */
		// бившия следващ node за даденият ни node става следващ за новия node -
		// вече новия node сочи към своя следващ
		new_node.next = prev_Node.next;

		/* 5. Make the next of prev_node as new_node */
		// даденият ни node вече съдържа информация за следващия елемент, която да сочи
		// към
		// новия node
		// вече дадения node сочи към своя следващ
		prev_Node.next = new_node;

		/* 6. Make prev_node as previous of new_node */
		// даденият ни node е посочен като предишен на новия
		// вече новия node сочи към своя предишен
		new_node.prev = prev_Node;

		/* 7. Change previous of new_node's next node */
		// в случай че новия node не е последен за листа се посочва, че неговият следващ
		// елемент има предишен самия него
		// вече следващия на новия node сочи към своя предишен (тоест новия node)
		if (new_node.next != null)
			new_node.next.prev = new_node;
	}

	// Add a node at the end of the list
	// добавя нов node в края на листа
	void append(int new_data) {
		/*
		 * 1. allocate node 2. put in the data
		 */
		// създаване на нов node и подаване на параметър в конструктора му, който сме
		// от самия метод append
		Node new_node = new Node(new_data);

		// създава се нов node, който се казва last и дубликира информацията от главата
		// (началото) на листа
		Node last = head; /* used in step 5 */

		/*
		 * 3. This new node is going to be the last node, so make next of it as NULL
		 */
		// посочва се, че следващия на новиа node е всъщност нулев, тъй като той трябва
		// да е последен
		// вече новия node сочи към своя следващ (нулев)
		new_node.next = null;

		/*
		 * 4. If the Linked List is empty, then make the new node as head
		 */
		// в случай че самия лист е празен, новия node става първи и се посочва че
		// предишния му е нулев
		// вече новия node сочи към предишния си (нулев)
		if (head == null) {
			new_node.prev = null;
			head = new_node;
			return;
		}

		/* 5. Else traverse till the last node */
		// last в началото е първият node, обхожда се целия лист като всеки следващ node
		// става своя следващ, докато не се стигне до последния, но не нулев
		// по този начин last става реално node-а, който е последен
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */
		// посочва се, че следващия node на last е новия node
		// вече досега последния node сочи към свой следващ (новия node)
		last.next = new_node;

		/* 7. Make last node as previous of new node */
		// посочва се, че предния на новия node е node-а last
		// вече новия node сочи към своя предишен
		new_node.prev = last;
	}

	// This function prints contents of
	// linked list starting from the given node
	public void printlist(Node node) {
		Node last = null;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direction");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		/* Start with the empty list */
		Task1DLL dll = new Task1DLL();

		// Insert 6. So linked list becomes 6->NULL
		dll.append(6);

		// Insert 7 at the beginning. So
		// linked list becomes 7->6->NULL
		dll.push(7);

		// Insert 1 at the beginning. So
		// linked list becomes 1->7->6->NULL
		dll.push(1);

		// Insert 4 at the end. So linked
		// list becomes 1->7->6->4->NULL
		dll.append(4);

		// Insert 8, after 7. So linked
		// list becomes 1->7->8->6->4->NULL
		dll.insertAfter(dll.head.next, 8);

		System.out.println("Created DLL is: ");
		dll.printlist(dll.head);
	}
}
