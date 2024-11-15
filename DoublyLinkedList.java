package driver;

//import linkedlistsortingalgoritym.SinglyLinkedListNode;

//import linkedlistsortingalgoritym.SinglyLinkedListNode;

public class DoublyLinkedList<T> {
	public Node<T> Header;
	public Node<T> Tail;
	
	public DoublyLinkedList() {
		this.Header = null;
		this.Tail = null;
	}
	
	//IsEmpty()
	public boolean IsEmpty() {
		return this.Header == null;
	}
	//GetLength()
	public int GetLength() {
		int length = 0;
		Node<T> node = this.Header;
		while (node != null) {
			length++;
			node = node.NextNode;
		}
		return length;
	}
	
	//append()
	public void Append(Node<T> node) {
		if (this.IsEmpty()) {
			this.Header = node;
			this.Tail = node;
		} else {
			this.Tail.NextNode = node;
			node.PreNode = this.Tail;
			this.Tail = node;
		}
	}
	
	//prepend()
	public void Prepend(Node<T> node) {
		if (this.IsEmpty()) {
			this.Header = node;
			this.Tail = node;
		} else {
			node.NextNode = this.Header;
			this.Header.PreNode = node;
			this.Header = node;
		}
	}
	
	//InsertAfter()
	//insert node after preNode
	public boolean InsertAfter(Node preNode, Node node) {
		//if we are doing append?
		if (preNode == this.Tail) {
			this.Append(node);
			return true;
		} else if (preNode == null) {//preNode is null
			return false;
		} else {
			Node next = preNode.NextNode;
			preNode.NextNode = node;
			node.NextNode = next;
			next.PreNode = node;
			node.PreNode = preNode;
			return true;
		}
	}
	
	
	public boolean InsertAhead(Node nextNode, Node node) {
		if (nextNode == this.Tail) {
		//if the nextNode is the header
			this.Prepend(node);
			return true;
		} else if (nextNode == null) {
		//if the nextNode is null
			return false;
		} else {
			Node pre = nextNode.PreNode;
			pre.NextNode = node;
			node.NextNode = nextNode;
			nextNode.PreNode = node;
			node.PreNode = pre;
			return true;
		}
	}
	
	//Remove()
	public void Remove(Node node) {
		if (node == this.Header && node == this.Tail) {
		//node it both the tail and the header
			this.Header = null;
			this.Tail = null;
		} else if (node == this.Tail) {
		//node is the tail
			//.....-> 2 -> 3 -> null
			Node pre = node.PreNode;
			pre.NextNode = null;
			node.PreNode = null;
			this.Tail = pre;
		} else if (node == this.Header) {
		//node is the header
			Node next = node.NextNode;
			node.NextNode = null;
			next.PreNode = null;
			this.Header = next;
		} else {
		//all generic cases
			node.PreNode.NextNode = node.NextNode;
			node.NextNode.PreNode = node.PreNode;
			node.NextNode = null;
			node.PreNode = null;
		}
	}
	
	//Search()
	//what is the arguments? payload
	//what is the output? all the instances
	//search returns all the matching node by payload and return as a doubly linked list
	//do not use this method, it is a bad one.
	public DoublyLinkedList<T> BladesBrokenSearch(T value){
		DoublyLinkedList<T> result = new DoublyLinkedList();
		Node node = this.Header;
		while (node != null) {
			if (node.Payload == value) {
				result.Append(node.clone());
			}
			node = node.NextNode;
		}
		return result;
	}
	
	//this is the method find the last instance of the matching node from the beginning
	public Node<T> Search(T value){
		Node<T> node = this.Tail;
		while (node != null) {
			if (node.Payload == value) {
				return node;
			}
			node = node.PreNode;
		}
		return null;
	}
	
	@Override
	public String toString() {
		if (this.IsEmpty()) {
			return "(0){empty}";
		}
		Node<T> node = this.Header;
		String output = "(" + this.GetLength() + ")" + "{"+ node;
		node = this.Header.NextNode;
		while (node != null) {
			output = output + ", " + node;
			node = node.NextNode;
		}
		output = output + "}";
		return output;
	}
	
	
	public void Print(String output) {
		System.out.println(output);
	}
	
	
	public void Sort (boolean ascending) {
		Node<T> node = this.Header;
		Node<T> node1 = node.NextNode;
		Node<T> pNode = node.PreNode;
		//Node<T> pNode1 = node1.PreNode;
		Node<T> nNode = node1.NextNode;
		Node<T> temp1 = null;
		//Node<T> temp2 = null;
		//System.out.println(node1);
		while (node1 != null) {
			//1 -> 1 -> 1
			if(node.compareTo(node1) > 0) { //the correct code is node.compareTo(node1)
				//swap node and node 1
				/*
				temp1 = node;
				temp2 = node1;
				Remove(node);
				Remove(node1);
				InsertAfter(temp1, pNode1);
				InsertAfter(temp2, pNode);
				*/
				temp1 = node;
				node = node1;
				node1 = temp1;
				//if node was head
				if(pNode == null) {
					node1 = this.Header;
				//if node was tail
				}else if(nNode == null) {
					node = this.Tail;
				}
				
				//else do nothing
				//define what is next node
				//this is for the next iteration, next round node is node 1
				//... -> 2 -> 1 -> ...
				//'node = 2; node1 = 1;
				//... -> 1 -> 2 -> ...
				//'node is still 2, node1 is still 1
				//node = node;
				//node 1 is node.nextNode
				node1 = node.NextNode;
			} else if (node.compareTo(node1) == 0) {
				node = node1;
				node1 = node.NextNode;
			} else {
				node = node1;
				node1 = node.NextNode;
			}
		}
	}
	
}
