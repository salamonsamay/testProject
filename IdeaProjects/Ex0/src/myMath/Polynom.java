package myMath;


//import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
//import java.util.function.Predicate;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 *
 * @author Boaz
 *
 */



public class Polynom implements Polynom_able{


    private Vector<Monom> monoms;
    private Monom_Comperator mc=new Monom_Comperator();

    /**
     * empty constructs initialize the vector
     */
    public Polynom(){
        monoms=new Vector<Monom>();
        mc=new Monom_Comperator();

    }

    /**
     * constructs  get string , convert to polynom and initialization them by use function helper "stringToPolynom"
     * @param str the string we convert to monom
     */
    public Polynom(String str) {
        Polynom p=stringToPolynom(str);
        monoms=p.monoms;
    }

    /**
     * copy constructs ,get other Polynom  and copy  to this
     * @param other the Polynom we copy
     */
    public Polynom(Polynom other){

        Polynom_able temp=other.copy();
        monoms=((Polynom) temp).monoms;

    }

    /**
     * add any object that implements Polynom_able to the Vector
     * by using Iterator the add method first checking if p1 is instanceof Polynom_able
     * if it does the method go over on p1 monoms and add to this.momos monom by monom
     * @param p1 the polynom object we add to this
     */
    public void add(Polynom_able p1) {
        Iterator<Monom> it= p1.iteretor();
        if(p1 instanceof Polynom){
            while (it.hasNext())
                add(it.next()) ;
        }
    }

    /**
     *"add" get monom and add it to monoms Collections
     * if we get any monoms who shares same power  Connects them
     * @param m1 the monom we add to Polynom
     */
    public void add(Monom m1) {

        Iterator<Monom> it =iteretor();
        Monom current;
        int index=0;
        while (it.hasNext()){
            current=it.next();
            if( mc.compare(current,m1)<0){
                monoms.add(index,m1);
                return;
            }
            else if(mc.compare(current,m1)==0){
                if(current.get_coefficient()+m1.get_coefficient()==0){
                    monoms.remove(index);
                    return;
                }
                monoms.set(index,new Monom(current.get_coefficient()+m1.get_coefficient(),m1.get_power()));
                return;
            }
            index++;
        }
        monoms.add(m1);


    }

    /**
     * get a Polynom_able object and substract from this
     * @param p1 the polynom we substract from this
     */

    public void substract(Polynom_able p1) {
        if(p1 instanceof Polynom){
            Iterator<Monom> it=p1.iteretor();
            while (it.hasNext()){
                Monom m=it.next();
                add(new Monom(-m.get_coefficient(),m.get_power()));
            }
        }
    }

    /**
     * get a Polynom_able object and multiply with this
     * @param p1 the polynom we multiply with this
     */
    public void multiply(Polynom_able p1) {
        if(p1 instanceof Polynom){

            Iterator<Monom> this_it=iteretor();
            Polynom temp=new Polynom();
            while (this_it.hasNext()){

                Iterator<Monom> other_it=p1.iteretor();
                Monom thisMonom=this_it.next();

                while (other_it.hasNext()){
                    Monom otherMonom=other_it.next();
                    temp.add(new Monom(thisMonom.get_coefficient()*otherMonom.get_coefficient(),thisMonom.get_power()+otherMonom.get_power()));

                }
            }
            this.monoms=temp.monoms;


        }


    }

    /**
     * test if 2 polynom are equals
     * @param p1 The object they compare
     * @return true or false
     */
    public boolean equals(Polynom_able p1) {
        if(p1 instanceof  Polynom){
            if(monoms.size()!=((Polynom) p1).monoms.size())
                return false;
            Iterator<Monom> it=iteretor();
            Iterator<Monom> it2=((Polynom) p1).iteretor();

            while (it.hasNext()){
                if(it.next().equals(it2.next())==false)
                    return false;

            }
            return true;

        }
        return false;

    }

    public boolean equals(Object obj){
        if(obj instanceof  Polynom){
            if(monoms.size()!=((Polynom) obj).monoms.size())
                return false;
            Iterator<Monom> it=iteretor();
            Iterator<Monom> it2=((Polynom) obj).iteretor();

            while (it.hasNext()){
                if(it.next().equals(it2.next())==false)
                    return false;

            }
            return true;

        }
        return false;

    }

    /**
     * test if the polynom There are no organs
     * @return true or false
     */
    public boolean isZero() {
        if(monoms.size()==0)
            return true;
        return false;
    }


    /**
     * this function finding point x between two point x0 and x1 such that f(x) smaller eps
     * @param x0 starting point
     * @param x1 end point
     * @param eps step (positive) value
     * @return f(x) such that: x0 smaller than x that smaller than x1
     */
    public double root(double x0, double x1, double eps) {
        double x;
        x = (x0 + x1) / 2;
        while(Math.abs(f(x)) > eps){
            x = (x0 + x1) / 2;
            if(f(x0)*f(x)<0)x1 = x;
            else if(f(x0)*f(x)>0) x0 = x;
            else break;
        }
        return x;
    }

    /**
     * create a deep copy of this Polynum
     * @return  deep copy of this Polynum
     */
    public Polynom_able copy() {
        Polynom_able polynom_able=new Polynom();

        for(int i=0;i<monoms.size();i++){
            polynom_able.add(new Monom(monoms.elementAt(i).get_coefficient(),monoms.elementAt(i).get_power()));
        }
        return polynom_able;
    }

    /**
     * Compute a new Polynom which is the derivative of this Polynom
     * @return derivative of this
     */
    public Polynom_able derivative() {
        Polynom_able dePolynom_able=new Polynom();
        for(int i=0;i<this.monoms.size();i++){
            if(monoms.elementAt(i).get_power()==0){
                dePolynom_able.add(new Monom(monoms.elementAt(i).get_coefficient()*monoms.elementAt(i).get_power(),0));
            }
            else dePolynom_able.add(new Monom(monoms.elementAt(i).get_coefficient()*monoms.elementAt(i).get_power(),monoms.elementAt(i).get_power()-1));
        }
        return dePolynom_able;
    }

    /**
     * the method Space calculus of polynom
     * By dividing the area to 1/eps Rectangles we Calculate the Rectangles area base*height  1/eps time
     * When the value is smaller The result is more accurate
     * @param x0 the the left limit
     * @param x1 the right limit
     * @param eps The margin of error
     * @return the area of f between x0 and x1
     */
    public double area(double x0, double x1, double eps) {
        double delta_Xi=(x1-x0)*eps;
        double width=(x1-x0)*eps;
        double area=0;

        for(int i=0;i<=1/eps;i++){
            area+=delta_Xi*f(x0+width*i);
        }
        return area;
    }

    /**
     * method  iterator
     * Inside the method  have a anonymous class Which represents the iteraor of polynom
     * @return object iterator of monom
     */
    public Iterator<Monom> iteretor() {
        Iterator<Monom> it=new Iterator<Monom>() {
            int index=0;
            @Override
            public boolean hasNext() {
                if(index<monoms.size())
                    return true;
                return false;

            }

            @Override
            public Monom next() {
                if(hasNext())
                    return monoms.elementAt(index++);
                return null;
            }
            public void remove(){
                monoms.remove(index);
            }
        };
        return it;
    }

    /**
     * function f(x)
     * @param x value in polynom
     * @return the value of f(x)
     */
    public double f(double x) {
        double sum=0;
        for(int i=0;i<monoms.size();i++){
            sum+= (monoms.elementAt(i).get_coefficient()*Math.pow(x,monoms.elementAt(i).get_power()));
        }
        return sum;
    }

    /**
     * @return string Which represents polynom
     */
    public String toString(){
        if(this.monoms.size()==0)
            return "0";
        String s="";
        for(int i=0;i<monoms.size();i++){
            if(monoms.elementAt(i).get_coefficient()<0 || i==0)
                s+=monoms.elementAt(i).toString();
            else s+="+"+monoms.elementAt(i).toString();
        }
        return s;
    }

    /**
     *Create A object of polynom.this constructs get string and convert him to polynom by using "stringToPolynom"
     * @param str a polynom from type string
     * @return a polynom from type  string
     */
    private  Polynom stringToPolynom(String str){
        Polynom p=new Polynom();
        LinkedList<String> list=new LinkedList<>();

        int i=0;
        String minus="-";
        String element="";
        if(str.charAt(0)=='-'){
            element+=minus;
            i++;
        }
        for(;i<str.length();i++){
            if(str.charAt(i)=='-'){
                list.add(element);
                element="";
                element+=minus;
            }
            else if(str.charAt(i)=='+'){
                list.add(element);
                element="";
            }
            else {
                element+=str.charAt(i);
            }
        }
        list.add(element);
        for(int j=0;j<list.size();j++){
            p.add(new Monom(list.get(j)));
        }

        return p;
    }








}
