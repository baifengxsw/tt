package cn.itcast.demo1;

import java.util.Arrays;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ����servlet��API  ��ȫ����ϵķ�ʽ
 * @author baifeng
 *
 */
public class RequestDemo1 extends ActionSupport {
	public String execute() throws Exception{
		//����Struts2�Ķ���ActionContext����
		ActionContext context = ActionContext.getContext();
		Map<String,Object> map = context.getParameters();
		for(String key:map.keySet()) {
			String [] value = (String [])map.get(key);
			System.out.println(key+":"+Arrays.toString(value));
		}
		
		//��������д�������
		context.put("reqname", "reqvalue"); //�൱��request��setAttribute():
		//���ע�����õ�����һ��map
		context.getSession().put("session", "sessionff");
		//�൱��application.setAttribute():
		context.getApplication().put("appname", "appname");
		
		return SUCCESS;
	}
}
