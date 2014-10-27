package bst;


public class BSTNode<T extends Comparable<T>> {
	private T value;
	private BSTNode<T> left;
	private BSTNode<T> right;
	private int balanceFactor;
	
	public BSTNode() {
		this.value = value;
		this.left = null;
		this.right = null;
		this.balanceFactor = 0;
	}
	
	public T getValue() {
		return value;
	}
	
	public BSTNode<T> getRight() {
		return right;
	}
	
	public BSTNode<T> getLeft() {
		return left;
	}
	
	public int balanceFactor() {
		return balanceFactor;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
	
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	
	public boolean isLeaf() {
		return (right == null) && (left == null);
	}
	
	public int size() {
		int size = 1;
		if (right != null) {
			size += right.size();
		}
		if (left != null) {
			size +=  left.size();
		}
		return size;
	}
	
	public boolean contains(T element) {
		return value.compareTo(element) == 0
				|| (right != null && right.contains(element))
				|| (left != null && left.contains(element));
	}
	
	public T get(T element) {
		if (value.compareTo(element) == 0) {
			return value;
		}
		BSTNode<T> next;
		if (value.compareTo(element) < 0) {
			next = left;
		}
		else {
			next = right;
		}
		if (next != null) {
			return next.get(element);
		}
		return null;
	}
	
	public void insert(T element) {
		if (value == null) {
			value = element;
		}
		else if (value.compareTo(element) < 0) {
			if (left == null) {
				left = new BSTNode<T>();
				left.setValue(element);
			}
			else {
				left.insert(element);
			}
			balanceFactor++;
		}
		else {
			if (right == null) {
				right = new BSTNode<T>();
				right.setValue(element);
			}
			else {
				right.insert(element);
			}
			balanceFactor--;
		}
	}
}
