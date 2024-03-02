import java.util.List;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}


class HashSet {
//    We use an array buckets of size SIZE to store the buckets, where each bucket is a linked list. (As sir discussed in class)
//    In the constructor MyHashSet(), we initialize the buckets array with null.

    private static final int   size = 10000;
    private ListNode[] buckets;

    public HashSet(){
       this.buckets = new ListNode[size];

    }
    public void add(int key){
        int ind = key % size;
        ListNode newNode  = new ListNode(key);
        if(buckets[ind]==null){
            buckets[ind] = newNode;
        }
        else{
            ListNode temp = buckets[ind];
            while(temp.next != null){
                if (temp.val == key) {
                    return;
                }

            }
            temp.next = newNode;
        }
    }
    public void remove(int key){
        int ind = key%size;
        ListNode temp = buckets[ind];
        while(temp != null){
            if (temp.val == key) {
                if(temp.next==null){
                    temp = null;
                    return;
                }
                else{
                    temp.val = temp.next.val;
                    temp.next = temp.next.next;
                    return;
                }
            }
            temp = temp.next;
        }
    }
    public boolean contains(int key){
        int ind = key%size;
        ListNode temp = buckets[ind];
        while (temp != null) {
            if (temp.val == key) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }
}


/*
* hard
class ListNode{
    int key;
    ListNode next;

    public ListNode(int key){
        this.key = key;
        this.next = null;
    }
}


class MyHashSet {

    private static final  int size = 10000;
    private ListNode[] buckets;

    public MyHashSet() {
        this.buckets = new ListNode[size];
    }

    public void add(int key) {
        int indBucket = key % size;
        ListNode newNode = new ListNode(key);

        if (buckets[indBucket] == null) {
            buckets[indBucket] = newNode;
        } else {
            ListNode tempHead = buckets[indBucket];
            while (tempHead != null) {
                if (tempHead.key == key)
                    return; // key already exists, no need to add
                if (tempHead.next == null){
                    break;}
                tempHead = tempHead.next;
            }
            tempHead.next = new ListNode(key);
        }
    }


    public void remove(int key) {
        int indBucket = key % size;

        ListNode tempHead = buckets[indBucket];
        ListNode prev = null;
        // Adjusted loop condition to check if tempHead is null or if tempHead.key != key
        while (tempHead != null && tempHead.key != key) {
            prev = tempHead;
            tempHead = tempHead.next;
        }

        if (tempHead != null) {
            if (prev == null) {
                // If the node to remove is the head of the list, update the bucket directly
                buckets[indBucket] = tempHead.next;
            } else {
                prev.next = tempHead.next;
            }
        }
    }

    public boolean contains(int key) {
        int indBucket = key%size;
        ListNode tempHead = buckets[indBucket];

    while (tempHead != null) {
        if (tempHead.key == key)
            return true;
        tempHead = tempHead.next;
    }

    return false;

    }
}*/