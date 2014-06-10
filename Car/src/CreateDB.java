package sock;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class CopyOfGuisever {
	
	public class GS extends JFrame{
		Socket socket=null;
		JTextField name=new JTextField();
		JTextArea old=new JTextArea();
		JTextArea nnn=new JTextArea();
		//JButton ok=new JButton("send");
		JButton cancle=new JButton("exit");
		
		public GS(Socket socket){
			
			this.setTitle("客户端");
			intiframe();
			this.setSize(300,200);
			this.setVisible(true);
			addl();
			this.socket=socket;
			new liten().start();

		}
		public void addl(){
			cancle.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(socket!=null){
						try {
							socket.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					GS.this.dispose();
					
					
				}});
			
		}
		public void  intiframe(){
			JPanel mainp=new JPanel();
			mainp.setLayout(new BorderLayout());
			JPanel zhong=new JPanel();
			zhong.setLayout(new GridLayout(2,0));
			JScrollPane js=new JScrollPane(old);
			
			JScrollPane js1=new JScrollPane(nnn);
			js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
			zhong.add(js);
			
			//zhong.add(js1);
			JPanel shang=new JPanel();
			shang.add(new JLabel("车辆预警提醒"));
			//shang.add(name);
			JPanel xia =new JPanel();
			//xia.add(ok);
			xia.add(cancle);
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			mainp.add(shang,BorderLayout.NORTH);
			mainp.add(zhong,BorderLayout.CENTER);
			mainp.add(xia,BorderLayout.SOUTH);
			this.getContentPane().add(mainp);
			
		}
		class liten extends Thread{
			public void run(){
				BufferedInputStream is=null;
				byte[]b=new byte[256];
				while(true){
					if(GS.this.socket.isClosed()||GS.this.socket==null){
							//is.close();
							//GS.this.socket.close();
						System.out.println("连接中断");
						GS.this.dispose();
						return;
					}
				try {
					int i=0;
					is=new BufferedInputStream(GS.this.socket.getInputStream());
					while(is.available()>0&&(i=is.read(b))!=-1){
						old.append(new String(b,0,i));
					}
					//is.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					GS.this.dispose();
					e.printStackTrace();
				}finally{
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					GS.this.dispose();
				}
			}
			}
		}
		
		}
	public CopyOfGuisever(int port){
		start(port);
	}
	public void start(int port){
		ServerSocket sever=null;
		try {
			sever=new ServerSocket(port);
			while(true){
				Socket socket=sever.accept();
				new GS(socket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new JFrame("ffg").setVisible(true);
		//System.out.print("sdfsd");
		new CopyOfGuisever(2111);
	}

}
