package s1;

import java.util.ArrayList;

/**
 * User�̈ꗗ��\���^�B
 * HAS-A�֌W�̃T���v���Ƃ��ăt�B�[���h��ArrayList�����������B
 * ArrayList�͉B������Ă���A���ڑ��삷�邱�Ƃ͂ł��Ȃ��B
 * 
 * @author nagise
 */
public class Users {
	ArrayList<User> userList = new ArrayList<>();

	/**
	 * ���[�U�[�̒ǉ�
	 * @param user �ǉ����郆�[�U�[
	 */
	public void add(User user) {
		this.userList.add(user);
	}
	/**
	 * ���[�U�[�̎擾
	 * @param index �擾�ΏۂƂȂ�C���f�b�N�X
	 * @return �擾���ꂽ���[�U�[
	 */
	public User get(int index) {
		return this.userList.get(index);
	}
}
