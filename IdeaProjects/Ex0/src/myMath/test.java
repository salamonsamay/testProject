package myMath;

public class test {

    public static void main(String[] args) {

       test5();
    }


    public static void test5() {

        Polynom_able p1 = new Polynom();
        Polynom_able p2 =new Polynom();
        Polynom p3 = new Polynom("-3x^2+1.9999999999999996x+x^3");
        Polynom p4 = new Polynom("-13x^4-4x^9+7x^10");

        Monom m1 = new Monom(11, 1);
        Monom m2 = new Monom(-4, 13);
        Monom m3 = new Monom(5, 6);
        Monom m4 = new Monom(-2, 13);
        Monom m5 = new Monom(2, 4);

        p1.add(m1);
        p1.add(m2);
        p1.add(m3);
        p1.add(m4);
        p2 = p1.copy();
        p2.add(m5);

        System.out.println("/////////////p1 && p2/////////////");
        System.out.println("p1 : " + p1.toString());
        System.out.println("p2 : " + p2.toString());
        System.out.println();
        p1.substract(p2);

        System.out.println("////////////substract///////////////");
        System.out.println("p1 after substract p2 need to be : -2x^4");
        System.out.println("p1 : " + p1.toString());
        System.out.println();

        System.out.println("/////////////////multiply////////////");
        p1.multiply(p2);
        System.out.println("p1 after multiply p2 need to be : -22x^5 + 12x^17 - 10x^10 - 4x^8");
        System.out.println("p1 : " + p1);
        System.out.println();

        System.out.println("////////////////derivative/////////");
        System.out.println("p2 : " + p2.toString());
        System.out.println("p2 after derivative need to be : 11 - 78x^12 + 30x^5 + 8x^3");
        System.out.println("p2 : " + p2.derivative().toString());
        System.out.println("p1 after derivative need to be : -110x^4 + 204x^16 - 100x^9 - 32x^7");
        System.out.println("p1 : " + p1.derivative().toString());
        System.out.println();

        System.out.println("////////////root//////////////");
        double eps = Double.MIN_VALUE;
        System.out.println(p3.toString());
        System.out.println("get something close to 0:" + p3.root(-0.5, 0.5, eps));
        System.out.println("get something close to 1:" + p3.root(0.5, 1.5, eps));
        System.out.println("get something close to 2:" + p3.root(1.5, 2.5, eps));
        System.out.println();

        System.out.println("///////////////////////f////////////////////");
        System.out.println("\nf(5) = 60538750 \n" + "answer :" + p4.f(5));
        System.out.println("\nf(2) = 4912 \n" + "answer :" + p4.f(2));
        System.out.println();

        System.out.println("///////////////////zero//////////////////");
        Polynom p5 = new Polynom();
        p5.add(new Monom(0.2, 0));
        p5.add(new Monom(-0.1, 0));
        p5.add(new Monom(-0.1, 0));
        System.out.println("get zero:" + p5.toString());
        Polynom p6 = new Polynom(p5.toString());
        System.out.println("get zero:" + p6.toString());

        System.out.println("///////////////////equal/////////////////");
        System.out.println("get false : " + p1.equals(p2));
        System.out.println("get false : " + p2.equals(p3));
        System.out.println("get true : " + p1.equals(p1));
        System.out.println("get true:" + p6.equals(p6));
        System.out.println();

    }


}