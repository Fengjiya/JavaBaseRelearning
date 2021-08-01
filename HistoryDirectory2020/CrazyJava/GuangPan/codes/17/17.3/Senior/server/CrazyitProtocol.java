package Senior.server;

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
public interface CrazyitProtocol
{
	//����Э���ַ����ĳ���
	int PROTOCOL_LEN = 2;
	//������һЩЭ���ַ������������Ϳͻ��˽�������Ϣ
	//��Ӧ����ǰ����������������ַ�����
	String MSG_ROUND = "���";
	String USER_ROUND = "�ǡ�";
	String LOGIN_SUCCESS = "1";
	String NAME_REP = "-1";
	String PRIVATE_ROUND = "�";
	String SPLIT_SIGN = "��";
}
