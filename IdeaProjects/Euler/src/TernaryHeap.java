public class TernaryHeap {

    private int[] arr;
    private  int size=0;

    public  TernaryHeap(int capacity){
        this.arr=new int[capacity+1];
    }

    //return the left son
    private int left(int i){
        return arr[3*i-1];
    }

    //return the mid son
    private int mid(int i){
        return arr[3*i];
    }

    //return the right son
    private int right(int i){
        return arr[3*i+1];
    }

    //return the parent
    private int parent(int i){
        return (arr[(Math.round((float)i/3))]);
    }

    /*
    the insert function  checks if the
    array have a room,if not the function return false
    else the function insert the element In the next free space arr[size]
    than we use the function heapUp to keep the TernaryHeap normal
    and return true

    *the running time of insert is O(1)
    *the running time of heapUp in worst case is O(1og(n))
    * O(1)*O(log(n))=O(log(n))
     */
    public boolean insert(int k){
        if(size<arr.length-1){
            arr[size+1]=k;
            size++;
            heapUp(size);
            return true;
        }
        return false;
    }

    //get index and and checks if the parent is bigger,if so we switch between them
    private void heapUp(int index){
        int k=0;
        if(index<=1 ||index>size)
            return;
        if(arr[index]>parent(index)){
            int temp=arr[index];
            arr[index]=parent(index);
            arr[Math.round((float)index/3)]=temp;
            k=Math.round((float)index/3);
            heapUp(k);

        }

    }

    /*
    the function copy the last element in the array
    Instead of the first organ
    now the max value deleted
    and to keep the TernaryHeap normal
    we call to heapDown

    *the running time of remove is O(1)
    *the running time of heapDown in worst case is O(1ogn)
    *   O(1)*O(logn)=O(log(n))
     */
    public int remove_max(){
        int max=arr[1];
        if (size > 0) {
            arr[1]=arr[size];
            heapDown(1);
            size--;
            return max;
        }
        return Integer.MAX_VALUE;
    }

    /*get index and checks if the element smaller than the biggest son
      if so we switch between them*/
    private void heapDown(int i){
        int maxchild=max_child_index(i);
        if(maxchild!=-1){
            int temp2=arr[i];
            arr[i]=arr[maxchild];
            arr[maxchild]=temp2;
            heapDown(maxchild);
        }
    }

    //retrun the biggest chid
    private int max_child_index(int i){
        if(3*i-1<=size &&3*i<=size &&3*i+1<=size){//במקרה של שלוש ילדים
            if(arr[3*i-1]>=arr[3*i]&& arr[3*i-1]>=arr[3*i+1])
                return 3*i-1;
            if(arr[3*i]>=arr[3*i-1]&&arr[3*i]>=arr[3*i+1])
                return 3*i;
            if(arr[3*i+1]>=arr[3*i-1]&&arr[3*i+1]>=arr[3*i])
                return 3*i+1;
        }
        if(3*i-1<=size &&3*i<=size){//במקרה של 2 ילדים
            if(arr[3*i-1]>=arr[3*i])
                return 3*i-1;
            else return 3*i;
        }
        if(3*i-1<=size)//במקרה של ילד 1
            return 3*i-1;
        else return -1;

    }


    public static void main(String[] args) {
        TernaryHeap t1=new TernaryHeap(100);

/*
        t1.insert(10);
        t1.insert(9);
        t1.insert(18);
        t1.insert(13);
        t1.insert(10);
        t1.insert(8);
        */
       /* System.out.println(t1.insert(17));
        System.out.println(t1.insert(6));
        System.out.println(t1.remove_max());
        System.out.println(t1.remove_max());
        System.out.println(t1.remove_max());
        System.out.println(t1.remove_max());
        System.out.println(t1.remove_max());
        System.out.println(t1.remove_max());
        System.out.println(t1.remove_max());*/




    }
}
