package K_means;
import java.util.*;
public class Cluster {  
    private int id;//标识  
    private Point center;//中心  
    private List<Point> members = new ArrayList<Point>();//成员  
  
    public Cluster(int id, Point center) {  
        this.id = id;  
        this.center = center;  
        
    }  
  
    public Cluster(int id, Point center, List<Point> members) {  
        this.id = id;  
        this.center = center;  
        this.members = members;  
    }  
  
    public void addPoint(Point newPoint) {  
        if (!members.contains(newPoint))  
            members.add(newPoint);  
        else  
            throw new IllegalStateException("试图处理同一个样本数据!");  
    }  
  
    public int getId() {  
        return id;  
    }  
  
    public Point getCenter() {  
        return center;  
    }  
  
    public void setCenter(Point center) {  
        this.center = center;  
    }  
  
    public List<Point> getMembers() {  
        return members;  
    }  
  
    @Override  
    public String toString() {  
        return "Cluster{" +  
                "id=" + id +  
                ", center=" + center +  
                ", members=" + members +  
                "}";  
    }  
}