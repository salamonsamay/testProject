package myMath;

import java.util.InputMismatchException;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative),
 * see: https://en.wikipedia.org/wiki/Monomial
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply.
 * @author Boaz
 *
 */

public class Monom  implements function {

    private double _coefficient;
    private int _power;

    /**
     *this constructs a Monom with a and b
     * @param a Represents the coefficient of monom
     * @param b Represents the power of monom
     * */
    public Monom(double a, int b)throws  InputMismatchException{
        if(b<0)throw new InputMismatchException("the power must be bigger than 0");
        set_coefficient(a);
        set_power(b);
    }

    /**
     * copy constructs
     * @param ot the object we copy
     */
    public Monom(Monom ot) {
        this(ot.get_coefficient(), ot.get_power());
    }
    // ***************** add your code below **********************

    /**
     *  constructs which receive string and convert to Monom  by use help function
     * @param str the string wee convert to monom
     */
    public Monom(String str){
        Monom m=stringToMonom(str);
        if(m.get_coefficient()==0)
            return;
        set_coefficient(m.get_coefficient());
        set_power(m._power);


    }

    /**
     * add use to add another monom  If they share same power
     * @param m the monom we add
     */
    public void add(Monom m) {
        if(get_power()!=m.get_power())
            return;
        set_coefficient(get_coefficient()+m.get_coefficient());
    }

    /**
     * test if the monom are equal by comper the coefficient and power
     * @param obj the monom we comper to this
     * @return  true if the monoms are equal
     */
    public boolean equals(Object obj){
        if(!(obj instanceof  Monom))
           return false;
        if(get_power() ==  ((Monom) obj).get_power() && get_coefficient() ==  ((Monom) obj).get_coefficient())
            return true;

        return false;
    }

    /**
     * function that derivative the monom
     * @return derivative of monom
     */
    public Monom derivative(){
        double a=_coefficient*_power;
        int b=_power-1;
        return new Monom(a,b);
    }

    /**
     * get the coefficient
     * @return coefficient of monom
     */
    public double get_coefficient(){
        return _coefficient;
    }

    /**
     * get the power
     * @return power of monom
     */
    public int get_power(){
        return _power;
    }
    //****************** Private Methods and Data *****************

    /**
     * the function get string and convert to monom
     * @param str the string we need to convert
     * @return monom
     */
    private Monom stringToMonom(String str){
        if(str==null)throw new RuntimeException("got null string ");
        String strCoefficient="",strPower="";
        int i=0;
        boolean operator=true;
        if(str.charAt(i)=='-'){//if the first element is -
            operator=false;
            i++;
        }
        for(;i<str.length();i++){
            if((str.charAt(i)>47 && str.charAt(i)<58) || str.charAt(i)==46 ){//if the char is number or '.'
                strCoefficient+=str.charAt(i);
            }
            else {
                if((str.charAt(i)>96 && str.charAt(i)<123 ) && ((operator && i==0) ||(!operator && i==1))){
                    strCoefficient+='1';
                }
                if(str.length()-1==i &&  (str.charAt(i)>96 && str.charAt(i)<123 ) ){//if the letter is the last element Make it to power 1
                    strPower="1";
                }
                else   strPower=str.substring(i+2);// else we know the power is from index i+2


                break;  //when we got the power and Coefficient  we can end the loops
            }
        }
        if(strPower=="")// if got no power the power is zero
            strPower="0";
        try {// We might get an error when Coefficient is not double and power is not int

            double Coefficient=Double.parseDouble(strCoefficient);
            int power=Integer.parseInt(strPower);

            if(operator)return new Monom(Coefficient,power);
            return new Monom(-Coefficient,power);

        }catch (Exception e){
            e.printStackTrace();
            return new Monom(0,0);
        }
    }

    /**
     * test if is zero monom
     * @return true or false
     */
    private boolean isZero(){
        if(get_coefficient()==0)return true;
        return false;
    }

    /**
     * private set method
     * @param a the coefficient
     */
    private void set_coefficient(double a){
        this._coefficient = a;
    }

    /**
     * private set method
     * @param p the power
     */
    private void set_power(int p) {
        this._power = p;
    }


    /**
     *
     * @param x the number putting in f
     * @return the value of y in point x
     */
    public double f(double x) {
        return get_coefficient()*Math.pow(x,get_power());
    }

    /**
     *string method
     * @return string Which represents monom
     */

    public String toString(){
        if(get_coefficient()==0)
            return get_coefficient()+"";
        if(get_power()==0)
            return get_coefficient()+"";
        return get_coefficient()+"x^"+get_power();
    }


}
