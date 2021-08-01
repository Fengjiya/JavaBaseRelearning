
import java.awt.event.*;
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
public class ProgressMonitorTest
{
	Timer timer;
	public void init()
	{
		final SimulatedActivity target = new SimulatedActivity(1000);
		// ������һ���̵߳ķ�ʽ��ִ��һ����ʱ������
		final Thread targetThread = new Thread(target);
		targetThread.start();
		final ProgressMonitor dialog = new ProgressMonitor(null
			, "�ȴ��������" , "����ɣ�" , 0 , target.getAmount());
		timer = new Timer(300 , new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// ������ĵ�ǰ��������ý��ȶԻ������ɱ���
				dialog.setProgress(target.getCurrent());
				// ����û������˽��ȶԻ����"ȡ��"��ť
				if (dialog.isCanceled())
				{
					// ֹͣ��ʱ��
					timer.stop();
					// �ж������ִ���߳�
					targetThread.interrupt();    // ��
					// ϵͳ�˳�
					System.exit(0);
				}
			}
		});
		timer.start();
	}
	public static void main(String[] args) 
	{
		new ProgressMonitorTest().init();
	}
}
