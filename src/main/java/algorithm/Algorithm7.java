package algorithm;

public class Algorithm7 {
    public static void main(String[] args) {
        Node ha = new Node(0);
        ha.pNext = new Node(14);
        ha.pNext.pNext = new Node(5);
        ha.pNext.pNext.pNext = new Node(2);
        ha.pNext.pNext.pNext.pNext = new Node(7);

        ha.pNext.pRandom = ha.pNext.pNext.pNext;
        ha.pNext.pNext.pRandom = ha.pNext;
        ha.pNext.pNext.pNext.pRandom = ha.pNext.pNext.pNext.pNext;
        ha.pNext.pNext.pNext.pNext.pRandom = ha.pNext;

        print(ha);
        Node hb = copy(ha);
        print(hb);
    }

    private static Node copy(Node ha) {
        Node hb = new Node(ha);
        Node pre = hb;

        Node p = ha.pNext;
        while (p != null) {
            Node t = new Node(p);
            pre.pNext = t;
            pre = t;

            // 更新新链表的random指针和旧链表的next指针
            t.pRandom = p;
            Node t2 = p.pNext;
            p.pNext = t; // 注意赋值顺序！！！
            p = t2;
        }

        p = hb.pNext;
        while (p != null) {
            Node old = p.pRandom;
            if (old.pRandom != null) {
                Node n = old.pRandom.pNext;
                p.pRandom = n;
            }

            p = p.pNext;
        }

        return hb;
    }

    private static void print(Node h) {
        Node t = h.pNext;
        while (t != null) {
            System.out.print(String.format("[{%s},{%s}] ", t.value, t.pRandom != null ? t.pRandom.value : null));
            t = t.pNext;
        }
        System.out.println();
    }

    private static class Node {
        int value;
        Node pNext;
        Node pRandom;

        Node(int v) {
            this.value = v;
            this.pNext = null;
            this.pRandom = null;
        }

        Node(Node a) {
            this.value = a.value;
            this.pNext = null;
            this.pRandom = null;
        }
    }
}
