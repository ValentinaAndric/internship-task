package polygon;

import java.util.Scanner;

public class Test {

	
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices of the polygon: ");
        
        int n = scanner.nextInt();
        
        if (n < 3) {
        	System.out.println("Enter a valid numeber of polygon vertices.");
        	return ;
        }

        Point[] polygon = new Point[n];

        System.out.println("Enter the vertices of the polygon: ");
        for (int i = 0; i < n; i++) {
        	
            System.out.print("x" + (i+1) + " = ");
            double x = scanner.nextDouble();
            
            System.out.print("y" + (i+1) + " = ");
            double y = scanner.nextDouble();
            
            polygon[i] = new Point(x, y);
        }

        System.out.println("Enter the point which you want to check if it's inside the polygon: ");
        
        System.out.print("x = ");
        double x = scanner.nextDouble();
        
        System.out.print("y = ");
        double y = scanner.nextDouble();

        Point p = new Point(x, y);

        if (RayCasting.isInside(polygon, n, p)) {
        	System.out.println("The point is inside the polygon.");
        }
            
        else {
        	System.out.println("The point isn't inside the polygon.");
        }
            
	}

	
	
}
