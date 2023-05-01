package polygon;

public abstract class RayCasting {

	public static boolean isInside(Point polygon[], int n, Point p) {
        
            
        Point extreme = new Point(Double.MAX_VALUE, p.getY());

        int count = 0, i = 0;
        do {
            int nextVertex = (i + 1) % n;

            if (checkIntersect(polygon[i], polygon[nextVertex], p, extreme)) {
                if (checkOrientation(polygon[i], p, polygon[nextVertex]) == 0)
                    return onSegment(polygon[i], p, polygon[nextVertex]);

                count++;
            }
            i = nextVertex;
        } while (i != 0);

        return (count % 2 == 1);
    }
    
    
   public static boolean checkIntersect(Point p1, Point q1, Point p2, Point q2) {
    	
    	int orientation1 = checkOrientation(p1, q1, p2);
        int orientation2 = checkOrientation(p1, q1, q2);
        int orientation3 = checkOrientation(p2, q2, p1);
        int orientation4 = checkOrientation(p2, q2, q1);

        if (orientation1 != orientation2 && orientation3 != orientation4)
            return true;

        if (orientation1 == 0 && onSegment(p1, p2, q1)) return true;

        if (orientation2 == 0 && onSegment(p1, q2, q1)) return true;

        if (orientation3 == 0 && onSegment(p2, p1, q2)) return true;

        if (orientation4 == 0 && onSegment(p2, q1, q2)) return true;

        return false;
    }

    public static boolean onSegment(Point p, Point q, Point r) {
        if (q.getX() <= Math.max(p.getX(), r.getX()) && q.getX() >= Math.min(p.getX(), r.getX()) &&
                q.getY() <= Math.max(p.getY(), r.getY()) && q.getY() >= Math.min(p.getY(), r.getY()))
            return true;

        return false;
    }

    public static int checkOrientation(Point p, Point q, Point r) {
    	
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) -
                (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val == 0)
            return 0;

        return (val > 0) ? 1 : 2;
    }
}
