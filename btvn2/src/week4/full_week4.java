package week4;

public class full_week4 {
    //1
    static void printLinkedList(SinglyLinkedListNode head) {

        while (head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }

    //2
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(head == null){
            return newNode;
        }else{
            SinglyLinkedListNode cur = head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next = newNode;
            return head;
        }

    //3
        static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            if(llist==null){
                return newNode;
            }
            else {
                newNode.next=llist;
                return newNode;
            }


        }

    //4
        public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
            // Write your code here
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            if(position == 0){
                newNode.next = llist;
                return newNode;
            }else{
                SinglyLinkedListNode cur = llist;
                int cnt = 0;
                while(cur!=null){
                    cnt++;
                    if(cnt==position){
                        newNode.next = cur.next;
                        cur.next = newNode;
                        break;
                    }
                    cur = cur.next;
                }
            }

            return llist;
        }

    //5
        public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
            // Write your code here
            int count =0;
            SinglyLinkedListNode temp =head;
            if (position == 0) {
                head=head.next;
                return head;
            }
            while (count!=position-1){
                temp=temp.next;
                count++;
            }
            if (temp.next.next!=null){
                temp.next = temp.next.next;
            }
            else temp.next = null;
            return head;
        }

    //6
        public static void reversePrint(SinglyLinkedListNode head) {
            // Write your code here
            SinglyLinkedListNode temp = head;

            List<Integer> arr = new ArrayList<>();
            while (temp.next!=null){
                arr.add(temp.data);
                temp=temp.next;
            }
            arr.add(temp.data);
            for (int i=arr.size()-1;i>=0;i--){
                System.out.println(arr.get(i));
            }
        }

    //7
        public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
            // Write your code here

            SinglyLinkedListNode temp = head;
            if ( head == null || head.next == null) {
                return head;
            }
            SinglyLinkedListNode newHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

    //8
        static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            SinglyLinkedListNode temp1 =head1;
            SinglyLinkedListNode temp2 = head2;
            int count1=0;
            int count2=0;
            while (count1==count2){
                if (temp1.data == temp2.data){
                    if (head1!=null){
                        head1=head1.next;
                        count1++;
                    }
                    if (head2!=null){
                        head2=head2.next;
                        count2++;
                    }
                    else break;
                }
                else return false;
            }
            if (count1==count2) return true;
            else   return false;
        }

    //9
        static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
            SinglyLinkedListNode res;
            if(head1.data < head2.data){
                res = new SinglyLinkedListNode(head1.data);
                head1 = head1.next;
            }
            else{
                res = new SinglyLinkedListNode(head2.data);
                head2 = head2.next;
            }
            SinglyLinkedListNode temp = res;
            while(head1 != null && head2 != null){
                if(head1.data < head2.data){
                    res.next = new SinglyLinkedListNode(head1.data);
                    head1 = head1.next;
                }
                else{
                    res.next = new SinglyLinkedListNode(head2.data);
                    head2 = head2.next;
                }
                res = res.next;
            }
            if(head1 == null && head2 != null){
                res.next = head2;
            }
            else if (head1 != null && head2 == null){
                res.next = head1;
            }
            return temp;

        }

    //10
        public static int getNode(SinglyLinkedListNode head, int positionFromTail) {
            // Write your code here
            SinglyLinkedListNode temp = head;
            int count =0;
            while (temp!=null){
                count ++;
                temp=temp.next;
            }
            int re = (count-1) - positionFromTail;
            count=0;
            SinglyLinkedListNode temp1 = head;
            while (count!=re){
                count++;
                temp1=temp1.next;
            }
            return temp1.data;
        }

}
