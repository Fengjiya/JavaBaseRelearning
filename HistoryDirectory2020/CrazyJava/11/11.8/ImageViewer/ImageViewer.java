package ImageViewer;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class ZoomImage
{
	//������������������С��ͼƬ�Ĵ�С
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	
	//����һ��BufferedImage�������ڱ�����С���λͼ
	BufferedImage image = new BufferedImage( WIDTH, HEIGHT
		, BufferedImage.TYPE_INT_RGB );
	Graphics gh = image.getGraphics();
	
	public void zoom() throws Exception
	{
		//��ȡԭʼλͼ
		Image srcImage = ImageIO.read(new File("image/board.jpg") );
		//��ԭʼλͼ��С����Ƶ�image������
		gh.drawImage( srcImage, 0, 0, WIDTH, HEIGHT , null );
		//��image��������������ļ���
		ImageIO.write( image,  "jpeg"
			, new File( System.currentTimeMillis() + ".jpg" ));
	}
	
	public static void main( String[] args ) throws Exception
	{
		new ZoomImage().zoom();
	}
	
}
	
	
	