package funny;


import java.util.LinkedList;
import java.util.List;

public class TreeTraverse2 {

	private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private static List<Node> nodeList = null;

	/**
	 * 节点
	 * 
	 */
	private static class Node {
		Node left;
		Node right;
		int value;

		Node(int newData) {
			left = null;
			right = null;
			value = newData;
		}
	}

	/**
	 * 先序遍历
	 * 
	 * @param node
	 */
	public static void preOrderTraverse(Node node) {
		if (node == null)
			return;
		System.out.print(node.value + " ");
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 */
	public static void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.print(node.value + " ");
		inOrderTraverse(node.right);
	}

	/**
	 * 后序遍历
	 * 
	 * @param node
	 */
	public static void postOrderTraverse(Node node) {
		if (node == null)
			return;
		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		System.out.print(node.value + " ");
	}

	public void createBinTree() {
		nodeList = new LinkedList<Node>();
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new Node(array[nodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子
			nodeList.get(parentIndex).left = nodeList
					.get(parentIndex * 2 + 1);
			// 右孩子
			nodeList.get(parentIndex).right = nodeList
					.get(parentIndex * 2 + 2);
		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = array.length / 2 - 1;
		// 左孩子
		nodeList.get(lastParentIndex).left = nodeList
				.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList
					.get(lastParentIndex * 2 + 2);
		}
	}
	
	public static void main(String[] args) {
		TreeTraverse2 binTree = new TreeTraverse2();
		binTree.createBinTree();
		// nodeList中第0个索引处的值即为根节点
		Node root = nodeList.get(0);

		System.out.println("先序遍历：");
		preOrderTraverse(root);
		System.out.println();

		System.out.println("中序遍历：");
		inOrderTraverse(root);
		System.out.println();

		System.out.println("后序遍历：");
		postOrderTraverse(root);
	}

}

