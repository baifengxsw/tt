package cn.itcast01.demo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("customerService")//�൱��<id= class ���ڵ�ǰ ���� init������ ��destroy����
@Scope("prototype")
public class CustomerService {
	@PostConstruct
	public void init() {
		System.out.println("����ʼ����");
	}
	
	public void save() {
		System.out.println("��ִ����");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("��������");
	}
}
