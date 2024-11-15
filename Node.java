package driver;

public class Node<T> {
	public T Payload;
	public Node<T> PreNode;
	public Node<T> NextNode;
	
	//Node a = new Node();
	//Node<int> a = new Node();
	public Node(){
		this.PreNode = null;
		this.NextNode = null;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.Payload);
	}
	
	public Node<T> clone(){
		Node newNode = new Node();
		newNode.Payload = this.Payload;
		return newNode;
	}
	
	//if this is equal to another, return 0
	//if this is larger than another, return 1(positive)
	//if this is smaller, return -1(negative)
	public int compareTo(Node<T> another) {
		if (this.Payload instanceof Integer) {
			if ((int)this.Payload > (int)another.Payload) {
				return 1;
			} else if ((int)this.Payload < (int)another.Payload) {
				return -1;
			} else {
				return 0;
			}
		} else if (this.Payload instanceof String) {
			return ((String)this.Payload).compareTo((String)another.Payload);
		} else {
			return 0;
		}
	}

}
