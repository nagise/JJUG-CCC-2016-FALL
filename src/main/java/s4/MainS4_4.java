package s4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �C���X�^���X�X�R�[�v�̃W�F�l���N�X�̃T���v��
 * 
 * @author nagise
 */
public class MainS4_4 {
	/** �Ђǂ��p�����^���C�Y�h�^�C�v�̗� */
	Map<String, Map<Integer, List<String>>> sample1;

	/** �r���ňϏ��N���X�����߂΂���Ȃ�Ƀ}�V�� */
	Map<String, HogeMap> sample2;

	/**
	 * �Ȃɂ����Ǘ�����N���X
	 */
	static class HogeMap {
		Map<Integer, List<String>> map = new HashMap<>();
		
		/**
		 * ����ԍ��ɒl��ǉ�����
		 * @param no �ԍ�
		 * @param value �ǉ�����l
		 */
		public void add(int no, String value) {
			List<String> list = map.get(no);
			if (list == null) {
				list = new ArrayList<>();
				map.put(no, list);
			}
			list.add(value);
		}
		/**
		 * ����ԍ��ɓo�^���ꂽ�l�̈ꗗ���擾
		 * @param no �ԍ�
		 * @return �ꗗ (�{���͉ςȎQ�ƂŕԂ��Ɠ����\����\�I����̂ł悭�Ȃ�)
		 */
		public List<String> get(int no) {
			return map.get(no);
		}
	}
}
