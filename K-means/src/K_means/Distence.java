package K_means;
/*º∆À„µ„∂‘æ‡¿Î*/
public class Distence implements Comparable<Distence> {  
    private Point source;  
    private Point dest;  
    private double dis;  
    private AbstractDistance distance;  
  
    public Distence(Point source, Point dest, AbstractDistance distance) {  
        this.source = source;  
        this.dest = dest;  
        this.distance = distance;  
        dis = distance.getDis(source, dest);  
    }  
  
    public Point getSource() {  
        return source;  
    }  
  
    public Point getDest() {  
        return dest;  
    }  
  
    public double getDis() {  
        return dis;  
    }  
  
    @Override  
    public int compareTo(Distence o) {  
        if (o.getDis() > dis)  
            return -1;  
        else  
            return 1;  
    }  
}