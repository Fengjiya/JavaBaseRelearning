package lee.sub;

import static java.lang.System.*;
import static java.lang.Math.*;
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

public class StaticImportTest
{
	public static void main(String[] args) 
	{
		//out��java.lang.System��ľ�̬Field�������׼���
		//PI��java.lang.Math��ľ�̬Field����ʾ�г���
		out.println(PI);
		//ֱ�ӵ���Math���sqrt��̬����
		out.println(sqrt(256));
	}
}
