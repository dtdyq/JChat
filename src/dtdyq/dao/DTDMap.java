package dtdyq.dao;

import java.util.HashMap;
import java.util.Set;

/**
 * �����û����������֮���ӳ�䣺
 * @author Admin
 *
 * @param <K>
 * @param <V>
 */
public class DTDMap<K,V> {
	private HashMap<K,V> map=new HashMap<>();
	//���û����Ͷ��õ����������Map��
	public void put(K user,V ps){
		map.put(user,ps);
	}
	//�ж��Ƿ����ָ���û�����
	public boolean contains(K user){
		return map.containsKey(user);
	}
	//�����û�����ȡ�������
	public V getPs(String user){
		return map.get(user);
	}
	//��ȡ�����û���
	public Set<K> keySet(){
		return map.keySet();
	}
}






