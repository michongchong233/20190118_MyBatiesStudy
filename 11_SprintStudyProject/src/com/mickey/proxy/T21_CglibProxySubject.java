package com.mickey.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 * �ϥ�cglib���ʺA�N�z�A�N�z��
 */
public class T21_CglibProxySubject implements MethodInterceptor {

	/*
	 * Method�N��N�z����k�AMethodProxy�N��N�z��{����k
	 */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		Object result = null;
		System.out.println("Proxy_�B��N�z����k");
		//�b����u���H����k�e��i�H�i��������޿�
		result = arg3.invokeSuper(arg0, arg2);//�N�����N�z����������k�A�]�N�O�u��������k
//		result = arg1.invoke(arg0, arg2);//�N�����u�������l����k�A�]�N�O�N�z������k�A�|���`��
//		result = arg3.invoke(arg0, arg2);//�N�����N�z������k�A�|���`��
		System.out.println("Proxy_�N�z����k�B�槹��");
		return result;
	}

}
