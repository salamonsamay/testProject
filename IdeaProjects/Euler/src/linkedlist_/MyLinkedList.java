package linkedlist_;

public class MyLinkedList {
    Node head,tail;
    Node newNode;
    int size=0;

    public MyLinkedList(){
        head=tail;
    }

    public void add(int n){
        if(head==tail){
            this.head=new Node(n);
            this.head.next=tail;
            size++;
            return;
        }
        if(head.next==tail){
            this.head.next=new Node(n);
            head.next.next=tail;
            size++;
            return;
        }
        Node temp=head;

        while (temp.next!=tail){

            temp=temp.next;

        }
        size++;
        newNode=new Node(n);
        temp.next =newNode;
        newNode.next=tail;
    }
    public void print(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public void buildlink(int k){
        Node temp=head;
        int count=0;
        int numOfList= (int) Math.floor((float)size/k);
        MyLinkedList lists[]=new MyLinkedList[k];
         for (int i=0;i<k;i++){
             lists[i]=new MyLinkedList();
             for(int j=0;j<numOfList;j++){
                 lists[i].add(temp.data);
                 temp=temp.next;
                 count++;

             }
             for (int j=0;j<size-count;j++){
                 lists[numOfList-1].add(temp.data);
                 temp=temp.next;
             }
         }
         for (int i=0;i<lists.length;i++){
             lists[i].print();
             System.out.println();
         }


    }


}
