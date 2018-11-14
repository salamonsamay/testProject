package bst;

public class BST {
    Node root;
    Node newNode;



    public void insert(int num){
        newNode=new Node(num);
        if(root==null){
            root=newNode;
            return;
        }
        Node temp=root;
        while(temp!=null){
            if(temp.key>num){
                if(temp.left==null){
                    temp.left=new Node(num);
                    return;
                }
                temp=temp.left;
            }
            else if(temp.key<=num){
                if(temp.right==null){
                    temp.right=new Node(num);
                    return;
                }
                temp=temp.right;
            }
        }

    }

    public void add(int x){
        if(root==null){
            root=new Node(x);
            return;
        }
        Node temp=root;
        while (temp!=null){
            temp.child++;
            if(temp.key<x){
                if(temp.right==null){
                    Node a=new Node(x);
                    temp.right=a;
                    return;
                }
                temp=temp.right;
            }
            else {
                if(temp.left==null){
                    Node b=new Node(x);
                    temp.left=b;
                    return;
                }
                temp=temp.left;
            }
        }



    }

    public int descendants(Node node){
        return node.child;
    }

    public void print() {
        print(root);
        System.out.println();
    }
    private void print(Node root){
        if(root!=null){
            print(root.left);
            System.out.print(root.key+" ");
            print(root.right);
        }

    }



    public void print_between(int a,int b){
        print_between(a,b,root);
    }
    private void print_between(int a,int b,Node node){
        if(node!=null ){
            print_between(a,b,node.left);
            if ( (node.key>a && node.key<b))
            System.out.print(node.key+" ");
            print_between(a,b,node.right);
        }
    }

    public static boolean isomorphic(BST bs1,BST bs2){
        return isomorphic(bs1, bs1.root, bs2, bs2.root);

    }
    private static boolean isomorphic(BST bs1,Node b1 ,BST bs2,Node b2){

        if(b1.left!=null && b2.left!=null){
            return isomorphic(bs1,b1.left,bs2,b2.left);
        }
        if(b1.right!=null && b2.right!=null){
            return isomorphic(bs1,b1.right,bs2,b2.right);
        }
        if(b1.left!=null && b2.left==null || b1.left==null && b2.left!=null ||(b1.right!=null && b2.right==null || b1.right==null && b2.right!=null) ){
            return false;
        }
        return true;
    }



    public static void main(String[] args) {

        BST a=new BST();
        a.add(2);
        a.add(1);
        a.add(312);
        a.add(5);
        a.add(33);
        a.add(33);
       // a.add(133);

        a.print();

        a.print_between(3,300);


    }





}
