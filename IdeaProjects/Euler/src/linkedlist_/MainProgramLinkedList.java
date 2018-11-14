package linkedlist_;

public class MainProgramLinkedList {

    public static int complete(int n,int i){
        if(n==0)
            return 0;
        return complete(n/10,++i)+((int)Math.pow(10,i-1)*(9-(n%10)));
    }



    public static void main(String[] args) {

        System.out.println(complete(1234,0));
        /*
        MyLinkedList l=new MyLinkedList();
        for(int i=0;i<20;i++){
            l.add(i+1);
        }
        l.print();
        System.out.println();
        l.buildlink(12);*/
    }
}
