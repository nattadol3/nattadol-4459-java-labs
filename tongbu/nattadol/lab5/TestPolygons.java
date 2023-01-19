/**
 * This TestPolygons Program will create either Rectangles or Triangle, then it will counted the total amount of polygons created,
 * The width of both polygons, and calculate both polygons area combine.  It will then display it on the screen with the following format:
 * 
 * "The number of polygons is (number_of_polygons) or (number_of_polygons1) or (number_of_polygons2)
 * The width of polygon1 is (polygons1_width) the width of polygon2 is (polygons2_width)
 * The sum of polygons area is (total_polygons_area)"
 * 
 * Author: Nattadol Thongbu
 * Date: 1/17/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab5;

import tongbu.nattadol.lab5.Polygon.PolygonType;

public class TestPolygons {

    /**
     * This is the main method.  It create two objects, polygon1 which is a rectangle with the height of 3 and width of 2, and polygon2 which is a triangle
     * with the height of 4 and width of 3.  After created each object It then call the setNumpolygons() and setSumPolygonsArea() methods from the Polygon class
     * to increase the polygons count and the combine area.  After all is done it will display the total polygon count, 
     * the width of both polygons, and the combine area to the screen
     **/

    public static void main(String[] args) {
        // Create new Polygon object
        Polygon polygon1 = new Polygon();

        // Set both width, height, and type of the polygon.
        polygon1.width = 2;
        polygon1.height = 3;
        polygon1.type = PolygonType.RECTANGLE;

        // Increase the total polygons count and combine area value.
        Polygon.setNumPolygons(1);
        Polygon.setSumPolygonsArea(polygon1.getArea());

        // Create 2nd Polygon object
        Polygon polygon2 = new Polygon();

        // Set both width, height, and type of the polygon.
        polygon2.width = 3;
        polygon2.height = 4;
        polygon2.type = PolygonType.TRIANGLE;

        // Increase the total polygons count and combine area value.
        Polygon.setNumPolygons(1);
        Polygon.setSumPolygonsArea(polygon2.getArea());
        
        System.out.println("The number of polygons is " + Polygon.numPolygons + " or "
         + polygon1.numPolygons +  " or " + polygon2.numPolygons);
         System.out.println("The width of polygon1 is " + polygon1.width 
         + " the width of polygon2 is " + polygon2.width);
         System.out.println("The sum of polygons area is " + Polygon.sumPolygonsArea);
    }
}