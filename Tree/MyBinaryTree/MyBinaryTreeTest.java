package MyBinaryTree;

import jdk.jfr.StackTrace;
import org.junit.Test;

public class MyBinaryTreeTest {
    @Test
    public void test1() {
        MyBinaryTree tree = new MyBinaryTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(3);
        tree.insert(1);
        tree.printTree();
        System.out.println(tree.findMax());
        System.out.println(tree.findMin());
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(3));
        System.out.println(tree.contains(4));

        tree.remove(3);
        System.out.println(tree.contains(3));
        tree.printTree();
    }
}
