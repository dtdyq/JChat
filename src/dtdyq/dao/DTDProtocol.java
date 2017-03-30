package dtdyq.dao;
/**
 * 
 * @author Admin
 * 定义用户发送数据类型接口：
 */
public interface DTDProtocol {
	//私聊：
	String USER_PRI="//";
	//登陆：
	String USER_LOGIN="[@]";
	//用户名重复，登录失败：
	String USER_DUP="username duplicate";
	//用户登录成功：
	String USER_SUCCESS="login success";
}
