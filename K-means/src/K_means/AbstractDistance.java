package K_means;
//抽象的距离，实现为欧几里德距离 
public abstract class AbstractDistance {  
    abstract public double getDis(Point p1, Point p2);  
}