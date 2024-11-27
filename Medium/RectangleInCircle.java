public class RectangleInCircle {
    // Method to check if a rectangle can fit inside a circle
    public static boolean rectangleInCircle(int w, int h, int radius) {
        // Calculate the diagonal of the rectangle using Pythagoras' theorem
        double diagonal = Math.sqrt(w * w + h * h);
        // Calculate the diameter of the circle
        double diameter = 2 * radius;
        // Check if the rectangle's diagonal is less than or equal to the circle's diameter
        return diagonal <= diameter;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(rectangleInCircle(8, 6, 5));
        System.out.println(rectangleInCircle(5, 9, 5));
    }
}
