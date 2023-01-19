/**
 * This is the Polygon class.  it contains the width, height, polygon type, total polygons count, and combine area value.
 * it has 3 methods.  getArea() method will calculate the area value base on the polygon type and return that value.
 * setNumPolygons() method will increase the total polygons count by the number of value that is passed into the method.
 * setSumPolygonsArea() method will increase the combine area value by (number of polygons created multiplies by its area)
 * 
 * Author: Nattadol Thongbu
 * Date: 1/17/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab5;

public class Polygon {
    double width, height;
    PolygonType type; 
    static int numOfPolygonsCreated;
    static int numPolygons;
    static double sumPolygonsArea;
    
    // enum value contains both polygons type.  RECTANGLE and TRIANGLE.
    enum PolygonType {
        RECTANGLE,
        TRIANGLE,
    }

    /**
     * getArea() method will calculate the area of the given polygon base on there polygon type.
     **/

    public double getArea() {
        double area = 0;
        switch (type) {

            // Calulate using this formular if the polygon type is RECTANGLE. 
            case RECTANGLE:
                area = width * height;
                break;

            // Calulate using this formular if the polygon type is Triangle. 
            case TRIANGLE:
                area = 0.5 * width * height;
                break;
        }
        return area;
    }

    /**
     * Everytime new polygons is created, setNumpolygons() will add the amount of polygons created to the numPolygons value</p>
     * and change numOfPolygonsCreated value to equal to the amount of polygons created each time
     **/

    public static void setNumPolygons(int numNewPolygons) {
        
        // Add to the total amount.
        numPolygons += numNewPolygons;
        numOfPolygonsCreated = numNewPolygons;
    }

    //This method will add the value of the combine polygons area to the sumPolygonsArea variable.
    public static void setSumPolygonsArea(double newPolygonsArea) {
        sumPolygonsArea += newPolygonsArea * numOfPolygonsCreated;
    }

}

