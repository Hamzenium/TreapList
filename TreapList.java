import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class TreapList<E extends Comparable<E>> implements List<E>{
	
	Node<E> root;
	int size;
	
	public TreapList(){
		this.size=0;	
	}
	
	static final class Node<E>{
		
		E data;
		int priority;
		int key=0;
		Node<E> left =null;
		Node<E> right = null;

		public Node(E data) {
			this.data = data;
			this.priority = new Random().nextInt(1000);
			key++;
		}

	}
	

	/**
	 * function to return the size of TreapList
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * iterator function for TreapList
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * add function for TreapList
	 * @param e is the element to get added to the end
	 */
	@Override
	public boolean add(E e) {
		
		root = add(root,e,size);
		return true;
	}
	private Node<E> add(Node<E> n, E k,int m) {
	    if (n == null) {
	       Node<E> p=new Node<E>
	       (k);
	       p.key=m;
	       this.size++;
	       return p;
	       
	    }
	    // going left
	    if (m < n.key) {
	      n.left = add(n.left, k, m);
	      if (n.priority < n.left.priority) {
	        n = rotateRight(n);
	      }
	    }
	    // going right
	    else if (m > n.key) {
	      n.right = add(n.right, k, m);
	      if (n.priority < n.right.priority)
	        n = rotateLeft(n);
	    } else
	      n.data = k;
	    return n;
	  }
	/**
	 * determined if it goes to the left
	 * @param n is the node
	 * @return the node
	 */
	private Node<E> rotateLeft(Node<E> n) {
	    Node<E> x = n.right;
	    n.right = x.left;
	    x.left = n;
	    return x;
	  }

	/**
	 * determined if it goes to the right
	 * @param n is the node
	 * @return the node
	 */
	  // rotate right
	  private Node<E> rotateRight(Node<E> n) {
		Node<E> x = n.left;
	    n.left = x.right;
	    x.right = n;
	    return x;
	  }
	  
	  /**
	   * helper get function for node
	   * @param n is the node
	   * @param k is the pos
	   * @return the node n
	   */
	  private E get(Node<E> n, int k) {
		    if (n == null)
		      return null;
		    if (k < n.key)
		      return get(n.left, k);
		    else if (k > n.key)
		      return get(n.right, k);
		    return n.data;
		  }
	  /**
	   * helper function for get
	   * @param n is the node
	   * @param k is the pos
	   * @return the node n
	   */
	  private Node<E> get_add(Node<E> n, int k) {
		    if (n == null)
		      return null;
		    if (k < n.key)
		      return get_add(n.left, k);
		    else if (k > n.key)
		      return get_add(n.right, k);
		    return n;
		  }
	  
	  /**
	   * function for getting node based off of the index
	   * throws and indexoutofboundsexception
	   */
	  @Override
		public E get(int index) throws IndexOutOfBoundsException {
			
		  if(this.size == 0 || index >= this.size) {
			  throw new IndexOutOfBoundsException("IndexOutOfBoundsException: make sure size of tree is greater than zero or index is in range");
		  }
		  if(get_add(root,index).data==null) {
			  return getter(index+1);
		  }
		  
		  return get(this.root,index); 
		}
		public E getter(int index)  {
			
			 
			  if(get_add(root,index).data==null) {
				  return get(root,index+1);
			  }
			  
			  return get(this.root,index); 
			}
	
	  /**
	   * helper function to remove node
	   * @param n is node
	   * @param k is pos
	   * @return nod eot be removed
	   */
	  private Node<E> remove(Node<E> n,int k) {
		    if (n == null)
		      return n;
		    if (k < n.key)
		      n.left = remove(n.left, k);
		    else if (k > n.key)
		      n.right = remove(n.right, k);
		    else {
		      if (n.left == null && n.right == null)
		        return null;
		      else if (n.left == null || (n.right != null && n.left.priority > n.right.priority)) {
		        n = rotateLeft(n);
		        n.left = remove(n.left, k);
		      } else {
		        n = rotateRight(n);
		        n.right = remove(n.right, k);
		      }
		    }
		    this.size--;
		    return n;
		  }

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	

	/**
	 * function to clear entire tree
	 */
	@Override
	public void clear() {
//		
		root = null;
//		root.left=null;
//		root.right=null;
		size=0;

	}



	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * function to add element (node) based on position
	 * throw indexoutofboundsexception if out of range
	 */
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		if(index > this.size || index < 0) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException: index is greater than tree size or is negative");
		}
		else {
			if(index<size) {
				if(get_add(root,index)!=null) {
					root = add(root,get(index),size+1);
				}
			}
			root = add(root,element, index);
		}
		
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * remove function, based on index
	 * throws and exception of out of bounds or does not exist
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if((index == 0 && this.size == 0) || index < 0) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		return remove(root,index).data;
	}
	/**
	 * toString function
	 * @return the TreapList as a string
	 */
	@Override
	public String toString() {
		String text = "";
		text+="[";
		if(size==0) {
			return "[]";
		}
		else if(size>0) {
			for(int i=0; i < size;i++) {
				if(get(root,i)!=null) {
					text+=get(i);
				}
				if(i < size-1) {
					text+=", ";
				}
			}
		}
		text+="]";
		return text;
	}
}