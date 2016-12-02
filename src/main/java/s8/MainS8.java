package s8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Stack;
import java.util.function.Supplier;

import com.google.gson.Gson;

import s1.User;

/**
 * �^�ϐ��̃C���X�^���X�����\�b�h���Ő����������P�[�X�̍l�@���낢��
 * 
 * @author nagise
 */
public class MainS8 {
	public static void main(String[] args) {
		// JSON�`������I�u�W�F�N�g�ɕϊ����郉�C�u����
		// ������Class�I�u�W�F�N�g��n���A���t���N�V�����ŃC���X�^���X������Ă���
		Gson gson = new Gson();
		User user = gson.fromJson("{\"name\":\"�f���[�N\",\"age\":20}", User.class);
		System.out.println(user);
		
		// C#�I�ȗ��z (�^���_�����������|����) (Java�ł͕��ʂɂ͖���)
		User u2 = sample1("{}");
		// C#�I�ȃo�C���h�̖����p�^�[�� (Java�ł͕��ʂɂ͖���)
		User u3 = MainS8.<User>sample1("{}");
		// Java�I�ȑË��_
		// �f�t�H���g�R���X�g���N�^���K�{
		// �f�t�H���g�R���X�g���N�^�̗L���̓R���p�C�����Ƀ`�F�b�N�ł��Ȃ�
		User u4 = MainS8.sample2("{}", User.class);

		// Java8��
		// Supplier���g�����ƂŃf�t�H���g�R���X�g���N�^�ȊO�ł��Ή��ł���
		// �p�����^���C�Y�h�^�C�v�ł��Ή��ł���
		User u5 = MainS8.sample3("{}", User::new);
		ArrayList<User> u6 = MainS8.sample3("[{},{}]", ArrayList::new);
		ArrayList<User> u7 = MainS8.sample3("[{},{}]", ArrayList<User>::new);
		ArrayList<User> u8 = MainS8.sample3("[{},{}]", ()-> new ArrayList<>());
		
		// �����U
		// �f�t�H���g�R���X�g���N�^���K�{
		User u9 = MainS8.sample4("{}");
		// �ꌩ���z�I�Ɍ����邪����IDE�̓��͕⊮�Ƃ͑����������Ďg���ɂ���
		// T...dummy �� null��n���ƁA�^���擾���邽�߂̔z�񂪓n����Ȃ��̂Ńo�O��
		// null �� T[] �Ƃ� new T[]{null}�Ƃ�����̂ŕ\�����B����
		User u10 = MainS8.sample4("{}", null);
		// �e�N�j�b�N�𗝉�����Ȃ��Ƃނ���L�q���Ђǂ����Ƃ�
		User u11 = MainS8.sample4("{}", new User[]{null});

		// Factory����s���ꍇ���Ƃ����炩��^�ϐ��Ƀo�C���h���ꂽ�^�𓾂邱�Ƃ�
		// �V�`���G�[�V���������n�}��Ύg����
		Factory<User> factory = new Factory<User>();
		User u12 = factory.sample5("{}");
	}
	
	public static <T> T sample1(String json) {
		// Java�ł͖���
		return null;
	}
	/**
	 * �悭�������郊�t���N�V�����őΉ���������B
	 * ��_�Ƃ��Ă�ArrayList�̂悤�ȃp�����^���C�Y�h�^�C�v�������̂ɍ���
	 * @param clazz ���t���N�V������new���邽�߂�Class�I�u�W�F�N�g
	 */
	public static <T> T sample2(String json, Class<T> clazz) {
		try {
			T ret = clazz.newInstance();
			// �{���͂�����json���p�[�X���Ēl���i�[���鏈��������
			return ret;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * Java8�����Supplier�ƃ��\�b�h�Q�ƂŎ�������̂��ėp���������X�b�L������
	 * @param supplier �C���X�^���X������ĕԂ�
	 */
	public static <T> T sample3(String json, Supplier<T> supplier) {
		T ret = supplier.get();
		// �{���͂�����json���p�[�X���Ēl���i�[���鏈��������
		return ret;
	}
	/**
	 * �ϒ��z��Ō^��n�������U�B���܂�ǂ��͂Ȃ�
	 * @param json
	 * @param dummy �z��I�u�W�F�N�g���n��̂ł������烊�t���N�V�����Ō^�𓾂�
	 */
	public static <T> T sample4(String json, T ... dummy) {
		try {
			@SuppressWarnings("unchecked")
			Class<T> type = (Class<T>) dummy.getClass().getComponentType();
			T ret = type.newInstance();
			// �{���͂�����json���p�[�X���Ēl���i�[���鏈��������
			return ret;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Factory ���p�����Č^�ϐ����o�C���h����P�[�X
	 * @param <T>
	 */
	static class Factory<T> {
		public T sample5(String json) {
			try {
				Class<T> type = getGenericType(this.getClass(),
						Factory.class, "T");
				T ret = type.newInstance();
				// �{���͂�����json���p�[�X���Ēl���i�[���鏈��������
				return ret;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * �n���ꂽ�^����p���K�w��o���āA
	 * �w��̐e�̌^�̎w��̖��O�̃W�F�l���N�X�^�p�����[�^��
	 * �p���̉ߒ��ŉ��^�ŋ������Ă��邩�𑖍����ĕԂ��B
	 * @param clazz �����J�n����^
	 * @param targetClass ��������Ώۂ̃W�F�l���N�X�^�p�����[�^�����^�B
	 * �����J�n�^�̐e�ł���K�v������B
	 * @param targetTypeName ���^�ŋ�����ꂽ���m�F�������^�p�����[�^�̃v���[�X�z���_��
	 * @return ������ꂽ�^
	 */
	public static <T> Class<T> getGenericType(
	    Class<?> clazz, Class<?> targetClass,
	    String targetTypeName) {
	  if (!targetClass.isAssignableFrom(clazz)) {
	    throw new IllegalArgumentException(
	        "�^" + clazz.getName() + "�́A�^"
	        + targetClass.getName() + "���p�����Ă��܂���");
	  }
	  Stack<Class<?>> stack = new Stack<Class<?>>();
	  while (!targetClass.equals(clazz.getSuperclass())) {
	    stack.push(clazz);
	    clazz = clazz.getSuperclass();
	  }
	  return getGenericTypeImpl(clazz, targetTypeName, stack);
	}
	/**
	 * �^�p�����[�^�̋�ی^�擾�̎����B�ċA���������B
	 * @param clazz ���݂̑����Ώی^
	 * @param targetTypeName ���݂̑����Ώۂ̃W�F�l���N�X�^�p�����[�^��
	 * @param stack ���݂̑����Ώی^�ȉ��̌p���K�w���ς܂ꂽStack
	 * @return �Y���^�p�����[�^�̋�����ꂽ�^
	 */
	@SuppressWarnings("unchecked")
	private static <T> Class<T> getGenericTypeImpl(Class<?> clazz,
	    String targetTypeName, Stack<Class<?>> stack) {
	  TypeVariable<? extends Class<?>>[] superGenTypeAray
	    = clazz.getSuperclass().getTypeParameters();

	  // �����Ώۂ̌^�p�����[�^�̖���(T�Ȃ�)����錾�̃C���f�b�N�X���擾
	  int index = 0;
	  boolean existFlag = false;
	  for (TypeVariable<? extends Class<?>> type : superGenTypeAray) {
	    if (targetTypeName.equals(type.getName())) {
	      existFlag = true;
	      break;
	    }
	    index++;
	  }
	  if (!existFlag) {
	    throw new IllegalArgumentException(
	        targetTypeName + "�ɍ��v����W�F�l���N�X�^�p�����[�^���݂���܂���");
	  }

	  // �����Ώۂ̌^�p�����[�^�����^�Ƃ���Ă���̂����擾
	  ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
	  Type y = type.getActualTypeArguments()[index];

	  // ��ی^�Ōp������Ă���ꍇ
	  if (y instanceof Class) {
	    return (Class<T>)y;
	  }
	  // �W�F�l���b�N�p�����[�^�̏ꍇ
	  if (y instanceof TypeVariable) {
	    TypeVariable<Class<?>> tv = (TypeVariable<Class<?>>)y;
	    // �ċA���ē����̌^�p�����[�^���p���K�w������Ȃ�����������݂�
	    Class<?> sub = stack.pop();
	    return getGenericTypeImpl(sub, tv.getName(), stack);
	  }
	  // �W�F�l���b�N�^�p�����[�^�����^�̏ꍇ
	  if (y instanceof ParameterizedType) {
	    ParameterizedType pt = (ParameterizedType) y;
	    return (Class<T>) pt.getRawType();
	  }
	  throw new IllegalArgumentException("�\�����ʌ^ : "
	      + y.toString() + " (" + y.getClass() + ")");
	}
}
