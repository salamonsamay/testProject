package File_format;

import GIS.*;
import Geom.Point3D;

import java.io.*;
import java.text.Format;
import java.util.Formatter;
import java.util.Scanner;

public class Csv2kml {

    public static void read(String path) throws IOException  {
        File f=new File(path);
        int count=0;
        Scanner in=new Scanner(f);
        while (in.hasNext()){
            count++;
            in.nextLine();
        }
        in=new Scanner(f);
        String line="";
        String tabelData[][]=new String[count][11];

        int startLine=2;
        in.nextLine();
        in.nextLine();
        while (in.hasNext()){
            line=in.nextLine();
            tabelData[startLine++]=line.split(",");
        }


        inlaize(tabelData);
    }


    public static void inlaize(String[][] s) throws IOException {
        GIS_layer layer = new GisLayer();
        Formatter Kml = new Formatter("C:\\Users\\סלומון\\Desktop\\x1.kml");
        // File kml=new File("C:\\Users\\סלומון\\Desktop\\x1.kml");
        String a="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"\n";
        String b="<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>"+"\n";
        Kml.format("%s",a);
        Kml.format("%s",b);
        double lat,lon,alt;
        for(int i = 2 ; i < s.length ; i++) {

            lat = Double.parseDouble(s[i][6]);
            lon = Double.parseDouble(s[i][7]);
            alt = Double.parseDouble(s[i][8]);
            MetaData m = new MetaData(s[i][0],s[i][1],s[i][2],s[i][3],s[i][4],s[i][5],s[i][9],s[i][10]);
            Point3D p = new Point3D(lat,lon,alt);
            GIS_element element = new GisElement(m,p);
            layer.add(element);

            String t=  "<Placemark>"+"\n"+
                    "<name><![CDATA["+s[i][1]+"]]></name>"+"\n"+
                    "<description>"+
                    "<![CDATA[BMAC: <b>"+s[i][0]+"</b><br/>"+
                    "Capabilities: <b>"+s[i][2]+"</b><br/>"+
                    "Channel: <b>"+s[i][4]+"</b><br/>"+
                    "RSSI: <b>"+s[i][5]+"</b><br/>"+
                    "AltitudeMeters: <b>"+s[i][8]+"</b><br/>"+
                    "AccuracyMeters: <b>"+s[i][9]+"</b><br/>"+
                    "Type: <b>"+s[i][10]+"</b><br/>"+
                    "Date: <b>"+((MetaData) element.getData()).getUTC()+"</b>]]>"+
                    "</description>"+
                    "<styleUrl>#red</styleUrl>"+"\n"+
                    "<Point>\n<coordinates>"+s[i][7]+","+s[i][6]+"</coordinates></Point>"+"\n"+
                    "</Placemark>"+"\n";

            Kml.format("%s ",t);

        }

        String lastdata= "</Folder>\n" +
                "</Document></kml>";
        Kml.format("%s",lastdata);
        Kml.close();



    }

    public static void main(String[] args) throws IOException {
        Csv2kml.read("C:\\Users\\סלומון\\Desktop\\מטלה 2 מונחה\\Ex2\\data\\WigleWifi_20171201110209.csv");
    }
}
