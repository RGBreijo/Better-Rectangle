/*=======================================================================
|   Source code:  BetterRectangle.java
|
|                 Class: BetterRectangle
|
|    
|    
|    Assignment:  Assignment 4 Better Rectangle
|
|        Course: COP 3337 (Intermediate Programming)
|        Section:  U06
|
|        Language:  Java
|        Compile:
|
|                javac BetterRectangle.java
|
|
|  Purpose: To extend functionality of the Rectangle class
|
|
|  Inherits From:  Rectangle
|
|
|   Interfaces:  None
|
|
|  +-----------------------------------------------------------------------
|
|      Constants:  There are no public constants.
|
|
| +-----------------------------------------------------------------------
|
|   Constructors:  BetterRectangle() - Empty constructor which sets a default unit rectangle
|                  BetterRectangle(int x, int y, int width, int height) - Creates a rectangle with a custom anchor, width and height
|                  BetterRectangle(int width, int height) - Creates a rectangle with default anchor nd custom with and height
|                  BetterRectangle(BetterRectangle rectangle) - Creates a rectangle with the same parameters as another BetterRectangle object
|
|  Class Methods:  No private class methods
|
|
|  Instance Methods:  @Override toString() Returns String
|                     @Override  equals(Object rectangle) Returns boolean
|                     getArea() Returns int
|                     getPerimeter() Returns Int
|                     getSlope() Returns float
|                     getMidPoint() Returns Point Object
|                     proportional(BetterRectangle rectangle) Returns boolean
|                     equivalent(BetterRectangle rectangle) Returns boolean
|                     similar(BetterRectangle rectangle) Returns boolean
|                     concentric(BetterRectangle rectangle) Returns boolean
|                     scaleBy(int scale) Returns boolean
|  *===========================================================================*/



import java.awt.Rectangle; // To inherit from
import java.awt.Point; // To Return point values for mid-point

public class BetterRectangle extends Rectangle

{


    /**
     * Creates a unit circle
     * Unit Circle: circle centered at the origin and with radius 1
     */
    public BetterRectangle()
        {
            super(0, 0, 1, 1);
        }

    /**
     * Creates a custom rectangle
     *
     * @param x custom x coordinate
     * @param y custom y coordinate
     * @param width custom width
     * @param height custom height
     */
        public BetterRectangle(int x, int y, int width, int height)
        {
            super(x, y, width, height);
        }


    /**
     *  Creates a rectangle with custom width and height
     *
     * @param width custom width
     * @param height custom height
     */

        public BetterRectangle(int width, int height)
        {
            super(0, 0, width, height);
        }

    /**
     * Creates a copy of a rectangle object
     *
     * @param rectangle rectangle object to copy
     */

        public BetterRectangle(BetterRectangle rectangle)
        {
            super(rectangle);
        }


    /**
     * Override method that outputs information about the rectangle
     *
     * @return A string containing information about the rectangle
     */

        @Override
        public String toString()
        {

            String pointsAndDimensions = super.toString().replace("]",",");
            pointsAndDimensions = pointsAndDimensions.replace(",", ", ");

            String areaAndPerm = String.format(" area=%d, perimeter=%d,", getArea(), getPerimeter());
            String slope = String.format(" slope=%.2f,", getSlope());
            String midPoint = String.format(" mid-point=%s", getMidPoint());

            return pointsAndDimensions + areaAndPerm + slope + midPoint + "]";

        }

    /**
     * Determines if two rectangle are equal
     *
     * @param rectangle rectangle to be tested
     * @return boolean value denoting true if the two rectangle are equal
     */

        @Override
        public boolean equals(Object rectangle)
        {
            return rectangle instanceof BetterRectangle && super.equals(rectangle);
        }


    /**
     * Determines the area of a rectangle
     *
     * Formula:
     *      Area = Width * Height
     *
     * @return Area of a rectangle
     */
        public int getArea()
        {
            return (int) (super.getHeight() * super.getWidth());
        }

    /**
     * Determines the perimeter of a rectangle
     *
     * Formula:
     *       Perimeter = (Width + Height) * 2
     *
     * @return Perimeter of a rectangle
     */
        public int getPerimeter()
        {
            return (int) (super.getWidth() + super.getHeight()) * 2;
        }

    /**
     * Determines the slope of a rectangle
     *
     * Formula:
     *      Slope = Height / Width
     *
     * @return Slope of a rectangle
     */

        public float getSlope()
        {
            if(super.getWidth() != 0)
            {
                return (float) (super.getHeight() / super.getWidth());
            }else
            {
                return 0;
            }
        }

    /**
     * Determines the mid point of a rectangle
     *
     * Formula:
     *      Midpoint = Center of rectangle + "anchor" corner
     *                 Width  / 2.0 +  x coordinate
     *                 Height / 2.0 + Y coordinate
     * @return A point object consisting of the midpoints
     */
        public Point getMidPoint()
        {
            final int X_MID = (int) Math.ceil(((super.getWidth() / 2.0) + super.getX()));
            final int Y_MID = (int) Math.ceil(((super.getHeight() / 2.0) + super.getY()));
            return new Point(X_MID, Y_MID);
        }


    /**
     * Determines if two rectangles have the same slope
     *
     * @param rectangle rectangle to be tested
     * @return boolean value evaluating true if they have the same slope
     */
        public boolean proportional(BetterRectangle rectangle)
        {
            final double  EPSILON = 0.0009; // acceptable difference

            return (Math.abs(this.getSlope() - rectangle.getSlope()) < EPSILON);
        }

    /**
     * Determines if two rectangles have the same perimeter
     *
     * @param rectangle rectangle to be tested
     * @return boolean value evaluating true if they have the same perimeter
     */

        public boolean equivalent(BetterRectangle rectangle)
        {
            return (this.getPerimeter() == rectangle.getPerimeter());
        }

    /**
     * Determines if two rectangles have the same area
     *
     * @param rectangle rectangle to be tested
     * @return boolean value evaluating true if they have the same area
     */

        public boolean similar(BetterRectangle rectangle)
        {
            return (this.getArea() == rectangle.getArea());
        }

    /**
     * Determent if two rectangles have the same mid-point
     *
     * @param rectangle rectangle to be tested
     * @return boolean value evaluating true if they have the same mid-point
     */

        public boolean concentric(BetterRectangle rectangle)
        {
            return(this.getMidPoint() == rectangle.getMidPoint());
        }

    /**
     * Scales a rectangle by a positive value
     *
     * @param scale amount to be scalded by
     * @return boolean denoting if rectangle was successful scaled
     */

        public boolean scaleBy(int scale)
        {
            final int MIN_SCALE_BY = 0;

            if( scale > MIN_SCALE_BY)
            {
                int height = (int) super.getHeight() * scale;
                int width = (int) super.getWidth() * scale;
                super.setSize(width, height);

                return true;
            }else
            {
                return false;
            }
        }
}
