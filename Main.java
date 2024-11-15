package driver;

public class Main {
	public static void main(String[] args) {
		System.out.println("Doubly Linked List");
		Node<Integer> a = new Node();
		a.Payload = 5;
		
		Node<Integer> b  = new Node();
		b.Payload = 7;
		
		Node<Integer> c  = new Node();
		c.Payload = 3;
		
		Node<Integer> d  = new Node();
		d.Payload = 8;
		
		Node<Integer> e  = new Node();
		e.Payload = 6;
		
		Node<Integer> f  = new Node();
		f.Payload = 1;
		
		DoublyLinkedList<Integer> list = new DoublyLinkedList();
		list.Append(a);
		list.Append(b);
		list.Append(c);
		list.Append(d);
		list.Append(e);
		list.Append(f);
		System.out.println(list.toString());
		//list.Print(output);
		//System.out.println(a.compareTo(b));
		list.Sort(true);
		System.out.println(list.toString());
	}
}
