package K_menas;
public class Point {  
        private double x;  
        private double y;  
        private int id;  
        private boolean beyond;//标识是否属于样本  
      
        public Point(int id, double x, double y) {  
            this.id = id;  
            this.x = x;  
            this.y = y;  
            this.beyond = true;  
        }  
      
        public Point(int id, double x, double y, boolean beyond) {  
            this.id = id;  
            this.x = x;  
            this.y = y;  
            this.beyond = beyond;  
        }  
      
        public double getX() {  
            return x;  
        }  
      
        public double getY() {  
            return y;  
        }  
      
        public int getId() {  
            return id;  
        }  
      
        public boolean isBeyond() {  
            return beyond;  
        }  
      
        @Override  
        public String toString() {  
            return "Point{" +  
                    "id=" + id +  
                    ", x=" + x +  
                    ", y=" + y +  
                    '}';  
        }  
      
        @Override  
        public boolean equals(Object o) {  
            if (this == o) return true;  
            if (o == null || getClass() != o.getClass()) return false;  
      
            Point point = (Point) o;  
      
            if (Double.compare(point.x, x) != 0) return false;  
            if (Double.compare(point.y, y) != 0) return false;  
      
            return true;  
        }  
      
        @Override  
        public int hashCode() {  
            int result;  
            long temp;  
            temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;  
            result = (int) (temp ^ (temp >>> 32));  
            temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;  
            result = 31 * result + (int) (temp ^ (temp >>> 32));  
            return result;  
        }  
    }
