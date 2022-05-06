package algorithm;

public class Algorithm6 {
    public static void main(String[] args) {
        Node ha = new Node(0);
        ha.pNext = new Node(1);
        ha.pNext.pNext = new Node(4);
        ha.pNext.pNext.pNext = new Node(5);

        Node hb = new Node(0);
        hb.pNext = new Node(2);
        hb.pNext.pNext = new Node(3);
        hb.pNext.pNext.pNext = new Node(6);

        print(ha);
        print(hb);
        execute(ha, hb);
        print(ha);
    }

    private static Node execute(Node ha, Node hb) {
        Node pa = ha.pNext;
        Node pb = hb.pNext;
        Node pre = ha; // key point
        while (pa != null && pb != null) {
            // 注意两个判断分支的实现不一致
            if (pa.value <= pb.value) {
                pre = pa;
                pa = pa.pNext;
            } else {
                pre.pNext = pb;
                pre = pb;
                
                // 注意赋值顺序
                Node t = pb.pNext;
                pb.pNext = pa; 
                pb = t;
            }
        }

        if (pb != null) {
            pre.pNext = pb;
        }

        return ha;
    }

    private static void print(Node h) {
        Node t = h.pNext;
        while (t != null) {
            System.out.print(t.value + " ");
            t = t.pNext;
        }
        System.out.println();
    }

    private static class Node {
        int value;
        Node pNext;

        Node(int v) {
            this.value = v;
            this.pNext = null;
        }
    }
}
