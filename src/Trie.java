
public class Trie {

	public Trie() {
		// TODO Auto-generated constructor stub
		this.run();
	}

	private void run() {
		// TODO Auto-generated method stub
		String[] keys = {"the","a","there"};
	}
	public static final int ALPHABETS = 26;
	public static class Root {
		Node rootNode;
		int count;
	}
	public static class Node {
	 Node[] children  = new Node[ALPHABETS]; 
	 int data;
	}
	public void insert(Root root,Node node,String key) {
		if(root == null)
			initializeRoot(root);
	}
	private void initializeRoot(Root root) {
		// TODO Auto-generated method stub
		root = getNode();
	}

	private Root getNode() {
		// TODO Auto-generated method stub
		Node node = new Node();
		
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Trie();
	}

}
