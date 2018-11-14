package linkedlist_;

import java.util.LinkedList;

public class Question6 {
    public static int complemente(int n){
        return complemente(n,1);
    }
    public static int complemente(int n,int i){
        if(n==0)
            return 0;
        return complemente(n/10,i*10)+comp((n%10))*i;
    }
    private static int comp(int k){
        return 9-k;
    }


    public static void deleteDuplicates(LinkedList list){
        LinkedList a=new LinkedList();
        for(int i=0;i<list.size();i++){
            if(!(a.contains(list.peek())))
                a.add(list.peek());

        }
        list.clear();
        list.addAll(a);

    }

    public static int BinarySearch(int[] a,int x){
       return BinarySearch(a,0,a.length-1,x);
    }
    private static int BinarySearch(int a[],int start,int end,int x){
        int middle=(end+start)/2;
        if(end-start<1)
            return -1;
        if(a[middle]==x)return middle;
        if(a[middle]<x)return BinarySearch(a,middle+1,end,x);
        if(a[middle]>x)return BinarySearch(a,start,middle,x);

        return -1;
    }
    public static int find(int[] a,int x){
        for(int i=0;i<a.length;i++){
            if(a[i]==x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(complemente(2345));


    }
}
