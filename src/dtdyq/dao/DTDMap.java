package dtdyq.dao;

import java.util.HashMap;
import java.util.Set;

/**
 * 用于用户名和输出流之间的映射：
 * @author Admin
 *
 * @param <K>
 * @param <V>
 */
public class DTDMap<K,V> {
	private HashMap<K,V> map=new HashMap<>();
	//将用户名和对用的输出流加入Map中
	public void put(K user,V ps){
		map.put(user,ps);
	}
	//判断是否包含指定用户名：
	public boolean contains(K user){
		return map.containsKey(user);
	}
	//根据用户名获取输出流：
	public V getPs(String user){
		return map.get(user);
	}
	//获取所有用户：
	public Set<K> keySet(){
		return map.keySet();
	}
}






