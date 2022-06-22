// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :None


class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value)
        {
            this.key=key;
            this.value=value;
        }
        
    }
    Node[] nodes;
    int buckets;
    
    private int getBucket(int key)
    {
        return key % buckets;
    }
    
    private Node find( Node head,int key)
    {
        Node prev = head;
        Node curr = head.next;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
                    
    public MyHashMap() {
        buckets = 1000;
        nodes = new Node[buckets];
    }
    
    public void put(int key, int value) {
        int index = getBucket(key);
        if(nodes[index]==null)
        {
            nodes[index]= new Node(-1, -1);
        }
        Node prev = find(nodes[index],key);
        if(prev.next==null)
        {
            prev.next=new Node(key, value);
        }
        else
        {
            prev.next.value=value;
            
        }
    }
    
    public int get(int key) {
        int index = getBucket(key);
        if(nodes[index]==null)
        {
            return -1;
        }
        Node prev = find(nodes[index],key);
        if(prev.next==null)
        {
            return -1;
            
        }
        return prev.next.value;
            
    }
    
    public void remove(int key) {
        int index = getBucket(key);
        if(nodes[index]==null)
        {
            return;
        }
        Node prev = find(nodes[index],key);
        if(prev.next==null)
        {
            return;
        }
        prev.next = prev.next.next;
    }
}