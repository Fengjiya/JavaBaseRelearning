package org.crazyit.flashget.state;

import javax.swing.ImageIcon;

import org.crazyit.flashget.ContextHolder;
import org.crazyit.flashget.object.Resource;
import org.crazyit.flashget.util.FileUtil;
import org.crazyit.flashget.util.ImageUtil;

public class Finished extends AbstractState {

	@Override
	public ImageIcon getIcon() {
		return ImageUtil.FINISHED_IMAGE;
	}

	public String getState() {
		return "finished";
	}

	public void init(Resource resource) {
		//ɾ����ʱ�ļ�
		FileUtil.deletePartFiles(resource);
		//��Դ������ɺ�ȡ������
		ContextHolder.dh.stopTimer(resource);
	}
	
	
}
