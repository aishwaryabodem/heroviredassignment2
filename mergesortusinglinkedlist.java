import java.util.*;
class Node 
{
     int data;
     Node next;   
     Node(int nums) 
    {
        data = nums;
    }
    Node() 
    {}
    void displayNode() 
    {
        System.out.print("[" + data + "] ");
    }
}
 
class LinkedList 
{
    Node first; 
    LinkedList() 
    {
        first = null;
    }
    boolean isEmpty() 
    {
        return (first == null);
    }
    void insert(int nums)
    {
        Node newNode = new Node(nums);
        newNode.next = first;
        first = newNode;
    }
    void append(Node result) 
    {
        first = result;
    } 
    void display() 
    {
        Node current = first;
        while (current != null) 
        {
            current.displayNode();
            current = current.next;
        }
        System.out.println("");
    }
    Node extractFirst() 
    {
        return first;
    } 
    Node MergeSort(Node head ) 
    {
        if (head  == null || head .next == null)
            return head ;
        Node a = head ;
        Node b = head .next;
        while ((b != null) && (b.next != null)) 
        {
            head  = head .next;
            b = (b.next).next;
        }
        b = head .next;
        head .next = null;
        return merge(MergeSort(a), MergeSort(b));
    }
 
    
    Node merge(Node a, Node b) 
    {
        Node temp = new Node();
        Node head = temp;
        Node c = head;
        while ((a != null) && (b != null)) 
        {
            if (a.data <= b.data) 
            {
                c.next = a;
                c = a;
                a = a.next;
            }
            else 
            {
                c.next = b;
                c = b;
                b = b.next;
            }
        }
        c.next = (a == null) ? b : a;
        return head.next;
    }
}
 
class mergesortusinglinkedlist {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        LinkedList obj = new LinkedList();
        Random numbers = new Random();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            obj.insert(Math.abs(numbers.nextInt(50)));
        System.out.println("Before sorting :");
        obj.display();
        obj.append(obj.MergeSort(obj.extractFirst()));
        System.out.println("After sorting :");
        obj.display();
        sc.close();
    }
}