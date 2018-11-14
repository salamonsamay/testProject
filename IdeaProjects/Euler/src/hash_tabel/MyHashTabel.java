package hash_tabel;

import java.util.Hashtable;

public class MyHashTabel  {
    private Student[] students;


    public MyHashTabel(int size){
        students=new Student[size];
    }

    public MyHashTabel(MyHashTabel hb){
        this.students=hb.students;

    }

    public void insert(Integer key,Student data){
        int m=students.length;
        double a=((Math.pow(5,0.5))-1)/2;
        int hash=(int)(m*(a*key%1));
        if(hash<students.length)
        students[hash]=new Student(data);
    }

    public void print(){

        String s="";
        for(int i=0;i<students.length;i++){
            System.out.println(students[i]);
        }

    }

    /*public static void MergeSort(int[] a) {
        MergeSort(a, 0, a.length-1,0);	// call function on entire range
    }

    // this sort takes an array, and a range to sort
    private static void MergeSort(int[] a, int start, int end,int count) {
        if(end-start > 0) {	// if the range is more than 1
            int middle = (start+end)/2;		// split the range
            MergeSort(a, start, middle,count++);	// sort first half
            MergeSort(a, middle+1,end,count++);		// sort second half
            Merge(a,start,middle,end);		// merge
        }
    }*/

    // this merge takes an array, and a range to merge:
    // start to middle is increasing, middle+1 to end is increasing
    // merge start to middle, middle+1 to end
    private static void Merge(int[] a, int start, int middle, int end) {
        int[] b = new int[end-start+1];		// temp array
        int i=start, j=middle+1, k=0;
        while(i<=middle && j<=end) {		// merge parts into temp
            if(a[i] < a[j])
                b[k++] = a[i++];
            else
                b[k++] = a[j++];
        }

        while(i<=middle) 			// copy remaining half into temp
            b[k++] = a[i++];

        while(j<=end)
            b[k++] = a[j++];

        for(k=0; k<b.length; k++) 		// copy from temp back into array
            a[start+k] = b[k];
    }

    public static void main(String[] args) {
        MyHashTabel hb=new MyHashTabel(50);
        //hb.print();
        Student[] st=new Student[1000];
        for (int i=0;i<st.length-900;i++){
            hb.insert(new Integer((int)Math.pow(i,3)),new Student("dani"+i,22+i,new Integer(123456+i)));
        }

        hb.print();
    }

}
