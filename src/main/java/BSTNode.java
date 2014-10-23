
public class BSTNode<T extends Comparable<T>> {
	private T value;
	private BSTNode<T> left;
	private BSTNode<T> right;
	private int balanceFactor;
	
	public BSTNode() {
		this.value = null;
		this.left = null;
		this.right = null;
		this.balanceFactor = 0;
	}
	
	public void insert(T element) {
		if (value == null) {
			value = element;
		}
		else if (value.compareTo(element) > 0) {
			if (left == null) {
				left = new BSTNode<T>();
			}
			left.insert(element);
			balanceFactor++;
		}
		else {
			if (right == null) {
				right = new BSTNode<T>();
			}
			right.insert(element);
			balanceFactor--;
		}
	}
}
