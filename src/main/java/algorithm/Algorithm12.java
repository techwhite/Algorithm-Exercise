package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Algorithm12 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println("前序递归遍历 ...");
        recursiveTranverse(head);
        System.out.println("前序非递归遍历 ...");
        preNoRecursiveTranverse(head);
        System.out.println("中序非递归遍历 ...");
        noRecursiveMidTranverse(head);
        System.out.println("后序非递归遍历 ...");
        noRecursivePostTranverse(head);
        System.out.println("层序遍历 ...");
        levelTranverse(head);

    }

    private static void levelTranverse(Node head) {
        if (head == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(head);

        while (!q.isEmpty()) {
            Node elem = q.poll();

            System.out.print(elem.val + " ");

            if (elem.left != null) q.add(elem.left);

            if (elem.right != null) q.add(elem.right);
        }
        System.out.println();
    }

    // 后序非递归遍历。
    // 要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。如果P不存在左孩子和右孩子，则可以直接访问它；或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
    private static void noRecursivePostTranverse(Node head) {
        if (head == null) return;
        
        Stack<Node> s = new Stack<>();
        s.push(head);

        Node pre = null;
        while (!s.isEmpty()) {
            Node p = s.peek();

            if (p.left == null && p.right == null || pre != null && (p.left == pre || p.right == pre)) {
                s.pop();
                System.out.print(p.val + " ");
                pre = p;
                continue;
            }

            if (p.right != null) {
                s.push(p.right);
            }

            if (p.left != null) {
                s.push(p.left);
            } 

        }
        System.out.println();
    }

    // 中序非递归遍历。应该按照右/中/左顺序来入栈，且左子数不为空的情况下，中间节点不能出栈
    private static void noRecursiveMidTranverse(Node head) {
        if (head == null) return;
        
        Stack<Node> s = new Stack<>();
        Node p = head;

        while (p != null || !s.isEmpty()) {

            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                System.out.print(p.val + " ");                
                p = p.right;
            }

        }
        System.out.println();
    }


    // 前序非递归遍历
    private static void preNoRecursiveTranverse(Node head) {
        if (head == null) return;
        
        Stack<Node> s = new Stack<>();
        Node p = head;

        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                System.out.print(p.val + " ");
                p = p.left;
            } else {
                p = s.pop();
                p = p.right;
            }
        }
        System.out.println();
    }

    
    // 区分清楚 前序/中序/后序遍历的区别
    private static void recursiveTranverse(Node head) {
        if (head == null) return;
        
        // 前序遍历
        System.out.print(head.val + " ");

        recursiveTranverse(head.left);
        recursiveTranverse(head.right);
        System.out.println();
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int value) {
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }
}
