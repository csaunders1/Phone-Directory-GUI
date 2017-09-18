import java.util.ArrayList;

public class AddressList {

    private ListNode head;
    private ListNode currentNode;

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void addToFront(String name, String tel, String email, String address, String dob) {
        ListNode n = new ListNode(name, tel, email, address, dob);
        if (head == null) {
            head = n;
        } else {
            this.currentNode = n;
            this.currentNode.next = head;
            this.head = this.currentNode;
        }
    }

    public void addToBack(String name, String tel, String email, String address, String dob) {
        ListNode n = new ListNode(name, tel, email, address, dob);
        if (head == null) {
            this.head = n;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            this.currentNode = n;
        }
    }

    public String toString() {
        ListNode temp = head;
        String s = "";
        while (temp != null) {
            s = s.concat(temp.toString() + "\n");
            temp = temp.next;
        }
        
        return s;
    }

    public String reverseToString() {
        String s = "";
        ListNode temp = head;
        ArrayList<String> a = new ArrayList<String>();
        while (temp!= null) {
            a.add(temp.toString());
            temp = temp.next;
        }

        for (int i = a.size() - 1; i >= 0; i--) {
            s = s+a.get(i)+"\n";
        }

        return s;
    }

    public AddressList reverse() {
        ListNode currNode = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
        AddressList list = new AddressList();
        list.setHead(head);
        return list;
    }

    public int sizeOf() {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            ++size;
        }
        return size;
    }

    public String phoneNumberByName(String name) {
        ListNode n = head;
        while (n != null) {
            if (n.getName().equals(name)) {
                return n.getTel();
            }
            n = n.next;
        }
        return "No matching telephone number found!";
    }

    public String emailByName(String name) {
        ListNode n = head;
        while (n != null) {
            if (n.getName().equals(name)) {
                return n.getEmail();
            }
            n = n.next;
        }
        return "No matching eMail found!";
    }

    public String nameByPhoneNumber(String tel) {
        ListNode n = head;
        while (n != null) {
            if (n.getTel().equals(tel)) {
                return n.getName();
            }
            n = n.next;
        }
        return "No matching name found!";
    }

    public String dobByName(String name) {
        ListNode n = head;
        while (n != null) {
            if (n.getName().equals(name)) {
                return n.getDob();
            }
            n = n.next;
        }
        return "No matching date of birth found!";
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public ListNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(ListNode currentNode) {
        this.currentNode = currentNode;
    }

    /**
     * This nested, private class represents a node of a singly linked list.
     */
    private class ListNode {

        private String name;
        private String tel; // Telephone number
        private String email;
        private String addr; // Address
        private String dob; // Date of birth
        private ListNode next; // Pointer to the next node

        private ListNode(String name, String tel, String email, String addr, String dob) {
            this.name = name;
            this.tel = tel;
            this.email = email;
            this.addr = addr;
            this.dob = dob;
        } // end of the constructor

        public String getName() {
            return name;
        }

        public String getTel() {
            return tel;
        }

        public String getEmail() {
            return email;
        }

        public String getAddr() {
            return addr;
        }

        public String getDob() {
            return dob;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode link) {
            next = link;
        }

        @Override
        public String toString() {
            return "ListNode {" + "Name:" + name + " | Phone:" + tel + " | eMail:" + email + " | Address:" + addr + " | DoB:" + dob + '}';
        }

    }
}