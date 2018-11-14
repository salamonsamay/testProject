import myMath.Monom;
import myMath.Polynom;
import myMath.Polynom_able;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class PolynomTest {
    private Polynom polynom=new Polynom("3x+2");

    @Test
    public void add() throws Exception {
        Polynom p_test=new Polynom("3x+2+4x^2-5x^7");
        polynom.add(new Monom(-5,7));
        polynom.add(new Monom(4,2));

        assertEquals(p_test,polynom);
        assertNotSame(p_test,polynom);

    }

    @Test
    public void add1() throws Exception {

        Polynom p_test=new Polynom("3x+2+14x^3+14x^4");
        polynom.add(new Polynom("14x^3+14x^4"));

        assertEquals(p_test,polynom);
        assertNotSame(p_test,polynom);

    }

    @Test
    public void substract() throws Exception {
        Polynom p_test=new Polynom("3x+42");
        polynom.substract(new Polynom("-40"));

        assertEquals(p_test,polynom);
        assertNotSame(p_test,polynom);
    }

    @Test
    public void multiply() throws Exception {
        Polynom p_test=new Polynom("39x^8+26x^7+12x^6+8x^5+9x^2+6x");
        polynom.multiply(new Polynom("3x+13x^7+4x^5"));

        assertEquals(p_test,polynom);
        assertNotSame(p_test,polynom);
    }

    @Test
    public void equals() throws Exception {
        Polynom p_test=new Polynom(polynom);

        assertEquals(p_test,polynom);
        assertNotSame(p_test,polynom);
    }

    @Test
    public void isZero() throws Exception {
        Polynom p_test=new Polynom();
        polynom.substract(polynom.copy());

        assertEquals(p_test,polynom);
        assertNotSame(p_test,polynom);

    }

    @Test
    public void root() throws Exception {
    }

    @Test
    public void copy() throws Exception {
        Polynom_able p_test=polynom.copy();

        assertEquals(p_test,polynom);
        assertNotSame(p_test,polynom);

    }

    @Test
    public void derivative() throws Exception {
        Polynom p_test=new Polynom("3");

        assertEquals(p_test,polynom.derivative());
        assertNotSame(p_test,polynom.derivative());
    }

    @Test
    public void area() throws Exception {
        double x1=2,x2=12,eps=0.0001;
        double area=3*Math.pow(x2,2)/2+2*12 - (3*Math.pow(x1,2)/2+2*2);

        int area2= (int)(area);
        int polynomarea=(int)polynom.area(x1,x2,eps);

        assertEquals((Integer) area2,(Integer) polynomarea);

    }

    @Test
    public void iteretor() throws Exception {
        Monom p_test=new Monom("3x");
        Monom p_test2=new Monom("2");

        Iterator<Monom> it=polynom.iteretor();

        assertEquals(p_test,it.next());
        assertEquals(p_test2,it.next());

    }

    @Test
    public void f() throws Exception {
        int x=4;
        double p_test=3*Math.pow(x,1)+2;
        assertEquals((Double)p_test,(Double) polynom.f(4));
    }

     /*  @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }
*/

}
