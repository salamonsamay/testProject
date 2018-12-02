import Coords.MyCoords;
import File_format.MultiCSV;
import Geom.Point3D;

import java.io.File;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        Point3D p=new Point3D(32.103315,35.209039,670);
        Point3D p2=new Point3D(32.106352,35.205225,650);
        MyCoords m=new MyCoords();
        System.out.printf(m.vector3D(p,p2).toString());

    }
}
