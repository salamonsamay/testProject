package stack;
import java.util.concurrent.ArrayBlockingQueue;


public class StackWithQueue {

    private ArrayBlockingQueue a;
    int stackSize;


    public StackWithQueue(int size){
        a=new ArrayBlockingQueue(size);
    }
    public void push(int element){
        a.add(element);
    }
    public int pop(){
        ArrayBlockingQueue b=new ArrayBlockingQueue(a.size());
        int k=a.size();
        for(int i=0;i<k;i++){
            b.add(a.remove());
            System.out.println(a.peek());
            a.add(b.remove());
        }
        return (int)a.element();
    }


    public static void main(String[] args) {
        StackWithQueue st=new StackWithQueue(4);
        st.push(1);
        st.push(22);
        st.push(3);
        st.push(4);
        System.out.println(st.pop());

    }

}
