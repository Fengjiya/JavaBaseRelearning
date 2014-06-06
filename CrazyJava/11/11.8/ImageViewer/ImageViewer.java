import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class ZoomImage
{
	//下面两个常量设置缩小后图片的大小
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	//定义一个BufferedImage对象，用于保存缩小后的位图
	BufferedImage image = new BufferedImage( WIDTH, HEIGHT
		, BufferedImage.TYPE_INT_RGB );
	Graphics gh = image.getGraphics();
	
	public void zoom() throws Exception
	{
		//读取原始位图
		Image srcImage = ImageIO.read(new File("image/board.jpg") );
		//将原始位图缩小后绘制到image对象中
		gh.drawImage( srcImage, 0, 0, WIDTH, HEIGHT , null );
		//将image对象输出到磁盘文件中
		ImageIO.write( image,  "jpeg"
			, new File( System.currentTimeMillis() + ".jpg" ));
	}
	
	public static void main( String[] args ) throws Exception
	{
		new ZoomImage().zoom();
	}
	
}
	
	
	