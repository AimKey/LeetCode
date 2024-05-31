import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Main {
    public void run() {
        // ListNode l1 = new ListNode(9);
        // l1.next = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new
        // ListNode(9, new ListNode(9))))));

        // ListNode l2 = new ListNode(9);
        // l2.next = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        // 462 + 674 = 1136
        print(l1);
        print(l2);
        addTwoNumbers(l2, l1);
    }

    public void addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n = new ListNode();
        ListNode pointer = n;
        int val = 0, remainder = 0;
        boolean check = false;
        // Calculate the number based on l1 (if it is equal or less)
        do {
            // Calculate the value of current l1 and l2
            System.out.println("remainder: " + remainder);
            val = l1.val + l2.val + remainder;
            System.out.println(l1.val + "+" + l2.val + " = " + (val));

            // Check to see if we need to carry the remainder to the next one
            remainder = val / 10;
            if (remainder > 0)
                check = true;
            else
                check = false;

            // Advance both l1 and l2
            l1 = l1.next;
            l2 = l2.next;

            System.out.println("Current val: " + val);
            // Advance our pointer
            if (check)
                pointer.val = (val - 10);
            else
                pointer.val = (val);

            if (l1 == null || l2 == null) {
                break;
            } else {
                pointer.next = new ListNode();
                pointer = pointer.next;
            }
        } while (true);

        // if (remainder != 0) {
        // pointer.val = remainder;
        // }
        print(n);
        System.out.println("Remain: " + remainder);

        if (l1 != null) {
            do {
                pointer.next = new ListNode();
                pointer = pointer.next;

                val = l1.val + remainder;
                System.out.println(l1.val + "+" + remainder + " = " + val);
                remainder = val / 10;
                if (remainder > 0)
                    check = true;
                else
                    check = false;
                System.out.println("Remainder: " + remainder);
                if (check)
                    pointer.val = (val - 10);
                else
                    pointer.val = (val);
                l1 = l1.next;
            } while (l1 != null);
            print(n);
        } else if (l2 != null) {
            System.out.println("l2 is longer than l1");
            do {
                pointer.next = new ListNode();
                pointer = pointer.next;

                val = l2.val + remainder;
                System.out.println(l2.val + "+" + remainder + " = " + val);
                remainder = val / 10;
                if (remainder > 0)
                    check = true;
                else
                    check = false;
                System.out.println("Remainder: " + remainder);
                if (check)
                    pointer.val = (val - 10);
                else
                    pointer.val = (val);
                l2 = l2.next;
            } while (l2 != null);
            print(n);
        }

        // In case if l1 has equals nums and reminder is still stainding (Ex: 462 + 674)
        if (remainder > 0) {
            pointer.next = new ListNode(remainder);
        }
        System.out.println("==============Final result==============");
        print(n);

        // Calulate the rest
        // In case if l1 has more nums than l2 (Ex: 123 + 12)
        // In case if l1 has less nums than l2 (Ex: 12 + 123)

    }

    public void print(ListNode n) {
        while (n.next != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println(n.val);
    }
}
