package test;

import Coords.MyCoords;
import Geom.Point3D;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class coordsTest {


    MyCoords coords = new MyCoords();

    @Test
    public void test() {
        Point3D p = new Point3D(32.103315,35.209039,670);
        Point3D gps = new Point3D(32.106352,35.205225,650);
        Point3D vector = new Point3D(337.69899206128815,-359.24920693881893,-20.0);

        assertEquals(vector,coords.vector3D(p, gps));

    }

    @Test
    public void test1() {
        Point3D p = new Point3D(32.10332,35.20904,670);
        Point3D gps = new Point3D(32.10635,35.20523,650);
        assertEquals(493.0523,coords.distance3d(p, gps),493.055);
    }
    @Test

    public void test2() {
        Point3D p = new Point3D(32.10332,35.20904,670);
        assertEquals(true,coords.isValid_GPS_Point(p));
    }
    @Test
    public void test3() {
        Point3D vector = new Point3D(337.699,-359.249,-20);
        Point3D p = new Point3D(32.10332,35.20904,670);
        Point3D p1 = new Point3D(396.7207956,-344.7428478,-41.40948383);
        System.out.println(coords.add(p,vector).toString());
        assertEquals(p1,coords.add(p,vector));
    }

}
