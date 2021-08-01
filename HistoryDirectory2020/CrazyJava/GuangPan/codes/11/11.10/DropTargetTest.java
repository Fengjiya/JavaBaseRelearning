
import java.util.List;
import java.io.*;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.dnd.*;
import javax.imageio.*;
import java.awt.datatransfer.*;
import javax.swing.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class DropTargetTest
{
	final int DESKTOP_WIDTH = 480;
	final int DESKTOP_HEIGHT = 360;
	final int FRAME_DISTANCE = 30;
	JFrame jf = new JFrame("�����Ϸ�Ŀ�ꡪ����ͼƬ�ļ�����ô���");
	// ����һ����������
	private JDesktopPane desktop = new JDesktopPane();
	// ������һ���ڲ����ڵ������
	private int nextFrameX;
	private int nextFrameY;
	// �����ڲ�����Ϊ���������1/2��С
	private int width = DESKTOP_WIDTH / 2;
	private int height = DESKTOP_HEIGHT / 2;
	public void init()
	{
		desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH
			, DESKTOP_HEIGHT));
		// ����ǰ���ڴ������Ϸ�Ŀ��
		new DropTarget(jf, DnDConstants.ACTION_COPY 
			, new ImageDropTargetListener());
		jf.add(desktop);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	class ImageDropTargetListener extends DropTargetAdapter
	{
		public void drop(DropTargetDropEvent event)
		{
			// ���ܸ��Ʋ���
			event.acceptDrop(DnDConstants.ACTION_COPY);
			// ��ȡ�Ϸŵ�����
			Transferable transferable = event.getTransferable();
			DataFlavor[] flavors = transferable.getTransferDataFlavors();
			// �����Ϸ���������������ݸ�ʽ
			for (int i = 0; i < flavors.length; i++)
			{  
				DataFlavor d = flavors[i];
				try
				{
					// ����Ϸ����ݵ����ݸ�ʽ���ļ��б�
					if (d.equals(DataFlavor.javaFileListFlavor))
					{
						// ȡ���ϷŲ�������ļ��б�
						List fileList = (List)transferable
							.getTransferData(d);
						for (Object f : fileList)
						{
							// ��ʾÿ���ļ�
							showImage((File)f , event);
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				// ǿ���ϷŲ���������ֹͣ�����Ϸ�Ŀ��
				event.dropComplete(true);    // ��
			}
		}
		// ��ʾÿ���ļ��Ĺ��߷���
		private void showImage(File f , DropTargetDropEvent event)
			throws IOException
		{
			Image image = ImageIO.read(f);
			if (image == null)
			{
				// ǿ���ϷŲ���������ֹͣ�����Ϸ�Ŀ��
				event.dropComplete(true);     // ��
				JOptionPane.showInternalMessageDialog(desktop 
					, "ϵͳ��֧���������͵��ļ�");
				// �������أ������������
				return;
			}
			ImageIcon icon = new ImageIcon(image);
			// �����ڲ�������ʾ��ͼƬ
			JInternalFrame iframe = new JInternalFrame(f.getName()
				, true , true , true , true);
			JLabel imageLabel = new JLabel(icon);
			iframe.add(new JScrollPane(imageLabel));
			desktop.add(iframe);
			// �����ڲ����ڵ�ԭʼλ�ã��ڲ�����Ĭ�ϴ�С��0X0������0,0λ�ã�
			iframe.reshape(nextFrameX, nextFrameY, width, height);
			// ʹ�ô��ڿɼ���������ѡ����
			iframe.show();
			// ������һ���ڲ����ڵ�λ��
			nextFrameX += FRAME_DISTANCE;
			nextFrameY += FRAME_DISTANCE;
			if (nextFrameX + width > desktop.getWidth()) 
				nextFrameX = 0;
			if (nextFrameY + height > desktop.getHeight())
				nextFrameY = 0;
		}
	}
	public static void main(String[] args)
	{
		new DropTargetTest().init();
	}
}
