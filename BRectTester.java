/*=============================================================================
|    Source code: BRectTester.java
|
|    Assignment:  Assignment 4 Better Rectangle
|
|        Course:  COP 3337 (Intermediate Programming)
|        Section:  U06
|
|       Language:  Java
|       Compile/Run:
|
|       javac BRectTester.java BetterRectangle
|       java BRectTester
|
|  +-----------------------------------------------------------------------------
|
|  Description:  This program calls methods of BetterRectangle objects and displays the results
|
|                The following are useful formulas provided in the spec sheet of assignment 4:
|
|                Area = (width * height)
|                Perimeter(width + height) * 2
|                slope = height / width
|                Mid-Point = Center of rectangle + "anchor" corner
|
|
|       Input:    No input.
|
|       Output:   The program displays information about rectangle objects
|
|       Process:  The program's steps are as follows:
|
|                      1.  The program calls methods in the BetterRectangle class and displays the result
|
|
|                No particular algorithms are used.
|
|
|   Required Features Not Included: All required features are included.
|
|   Known Bugs:  None; the program operates correctly.
|
|  *===========================================================================*/


enum RectangleIndex
{
    // Corresponds to the array index of the objects in BRectTester class and Used as arguments for methods
    A_INDEX(0), B_INDEX(1), C_INDEX(2), D_INDEX(3);

    private int index = 0;

    private RectangleIndex(int index)
    {
        this.index = index;
    }

    /**
     * Getter method for index
     *
     * @return index value of constants
     */
    public int getIndex()
    {
        return index;
    }
}


public class BRectTester

{

    private static final String[] RECTANGLE_NAMES = {"a", "b", "c", "d"};
    private static final int AMOUNT_OF_RECTANGLE = 4;


    public static void main(String[] args)
    {

        int[] scaleBy = {4, -4};

        BetterRectangle[] betterRectangleArray = new BetterRectangle[AMOUNT_OF_RECTANGLE];

        betterRectangleArray[RectangleIndex.A_INDEX.getIndex()] = new BetterRectangle(3, 4);
        betterRectangleArray[RectangleIndex.B_INDEX.getIndex()] = new BetterRectangle(betterRectangleArray[RectangleIndex.A_INDEX.getIndex()]);
        betterRectangleArray[RectangleIndex.C_INDEX.getIndex()] = new BetterRectangle(1, 1, 4, 3);
        betterRectangleArray[RectangleIndex.D_INDEX.getIndex()] = new BetterRectangle();

        displayInformation(betterRectangleArray, scaleBy);
    }


    /**
     *    Calls the required methods to output information about all rectangles
     *
     *    @param rectangle an array of BetterRectangle objects
     *    @param scaleBy an array of values that will be used to scale a rectangle
     */
    public static void displayInformation(BetterRectangle[] rectangle, int[] scaleBy)
    {
        displayToString(rectangle);
        System.out.println();

        displayAccessors(rectangle, RectangleIndex.A_INDEX);
        System.out.println("\n");

        displayUtility(rectangle, RectangleIndex.B_INDEX, RectangleIndex.C_INDEX);
        System.out.println();

        displayMutator(rectangle, RectangleIndex.D_INDEX, scaleBy);
    }


    /**
     * Calls the to toString method for each of the rectangle objects
     *
     * @param rectangle an array of BetterRectangle objects
     */

    public static void displayToString(BetterRectangle[] rectangle)
    {
        for(int i = 0; i < rectangle.length; i++)
        {
            System.out.println(RECTANGLE_NAMES[i].toUpperCase() + ": " +  rectangle[i].toString());
        }
    }


    /**
     * Displays information about accessors methods
     *
     * @param rectangle an array of BetterRectangle objects
     * @param INDEX a RectangleIndex constant representing the index of a rectangle
     */

    public static void displayAccessors(BetterRectangle[] rectangle, RectangleIndex INDEX)
    {
        final int RECT_INDEX = INDEX.getIndex();

        System.out.println("Accessor methods being executed for Rectangle " + RECTANGLE_NAMES[RECT_INDEX].toUpperCase() + "...");

        System.out.println(RECTANGLE_NAMES[RECT_INDEX].toUpperCase() + ": " + rectangle[RECT_INDEX].toString());

        System.out.printf("%2s Area: %10d \n", "", rectangle[RECT_INDEX].getArea());
        System.out.printf("%2s Perimeter: %5d \n", "", rectangle[RECT_INDEX].getPerimeter());
        System.out.printf("%2s Slope: %11.2f \n", "", rectangle[RECT_INDEX].getSlope());
        System.out.printf("%2s MidPoint: %3s [%d,%d] \n", "", "", (int) rectangle[RECT_INDEX].getMidPoint().getX(), (int) rectangle[RECT_INDEX].getMidPoint().getY());

    }


    /**
     * Displays information about the utility methods
     *
     * @param rectangle an array of BetterRectangle objects
     * @param INDEX_ONE A RectangleIndex enum constant representing the index of a rectangle
     * @param INDEX_TWO A RectangleIndex enum constant representing the index of a rectangle
     */

    public static void displayUtility(BetterRectangle[] rectangle, RectangleIndex INDEX_ONE, RectangleIndex INDEX_TWO)
    {
        // Expected values for results
        final boolean EXPEC_EQUAL = false;
        final boolean EXPEC_PROPORTIONAL = false;
        final boolean EXPEC_EQUIVALENT = true;
        final boolean EXPEC_SIMILAR = true;
        final boolean EXPEC_CONCENTRIC = false;

        final int RECT_ONE_INDEX = INDEX_ONE.getIndex();
        final int RECT_TWO_INDEX = INDEX_TWO.getIndex();

        System.out.println("Utility methods being executed for Rectangle " + RECTANGLE_NAMES[RECT_ONE_INDEX].toUpperCase() + " and " + RECTANGLE_NAMES[RECT_TWO_INDEX].toUpperCase()+ "...");
        System.out.println(RECTANGLE_NAMES[RECT_ONE_INDEX].toUpperCase() + ": " + rectangle[RECT_ONE_INDEX].toString());
        System.out.println(RECTANGLE_NAMES[RECT_TWO_INDEX].toUpperCase() + ": " + rectangle[RECT_TWO_INDEX].toString());

        System.out.printf("%2s Equals? %13s %9sExpected: %6s\n", "", rectangle[RECT_ONE_INDEX].equals(rectangle[RECT_TWO_INDEX]), "", EXPEC_EQUAL);
        System.out.printf("%2s Proportional? %7s %8s Expected: %6s\n", "", rectangle[RECT_ONE_INDEX].proportional(rectangle[RECT_TWO_INDEX]), "", EXPEC_PROPORTIONAL);
        System.out.printf("%2s Equivalent? %8s %10sExpected: %5s\n", "", rectangle[RECT_ONE_INDEX].equivalent(rectangle[RECT_TWO_INDEX]), "", EXPEC_EQUIVALENT);
        System.out.printf("%2s Similar? %11s %10sExpected: %5s\n","", rectangle[RECT_ONE_INDEX].similar(rectangle[RECT_TWO_INDEX]), "", EXPEC_SIMILAR );
        System.out.printf("%2s Concentric? %9s %9sExpected: %6s\n", "", rectangle[RECT_ONE_INDEX].concentric(rectangle[RECT_TWO_INDEX]), "", EXPEC_CONCENTRIC);

    }

    /**
     * Displays information about mutator methods
     *
     * @param rectangle An array of BetterRectangle objects
     * @param INDEX A RectangleIndex enum constant representing the index of a rectangle
     * @param scaleByValues An array of values to scale a rectangle by
     */


    public static void displayMutator(BetterRectangle[] rectangle, RectangleIndex INDEX, int[] scaleByValues)
    {
        final int RECT_INDEX = INDEX.getIndex();

        System.out.println("Mutator methods being executed for Rectangle " + RECTANGLE_NAMES[RECT_INDEX].toUpperCase() + "...");

        for (int scaleByValue : scaleByValues)
        {
            System.out.println(RECTANGLE_NAMES[RECT_INDEX].toUpperCase() + ": " + rectangle[RECT_INDEX].toString());
            System.out.printf("%2s Scale By  %d? %s\n", "", scaleByValue, rectangle[RECT_INDEX].scaleBy(scaleByValue));
        }

        System.out.println(RECTANGLE_NAMES[RECT_INDEX].toUpperCase() + ": " + rectangle[RECT_INDEX].toString());
    }

}