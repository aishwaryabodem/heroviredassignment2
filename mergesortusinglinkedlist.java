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
    void display() 
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
            current.display();
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
        Node data1 = head ;
        Node data2 = head .next;
        while ((data2 != null) && (data2.next != null)) 
        {
            head  = head .next;
            data2 = (data2.next).next;
        }
        data2 = head .next;
        head .next = null;
        return merge(MergeSort(data1), MergeSort(data2));
    }
 
    
    Node merge(Node data1, Node data2) 
    {
        Node temp = new Node();
        Node head = temp;
        Node var = head;
        while ((data1 != null) && (data2 != null)) 
        {
            if (data1.data <= data2.data) 
            {
                var.next = data1;
                var = data1;
                data1 = data1.next;
            }
            else 
            {
               var.next = data2;
                var = data2;
                data2 = data2.next;
            }
        }
        var.next = (data1== null) ? data2 : data1;
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
        System.out.println("before sorting :");
        obj.display();
        obj.append(obj.MergeSort(obj.extractFirst()));
        System.out.println("After sorting :");
        obj.display();
        sc.close();
    }
}