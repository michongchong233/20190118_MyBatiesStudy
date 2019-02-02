package com.mickey.proxy;

/*
 * 靜態代理類
 */
public class T19_StaticProxySubject implements T19_StaticSubject{
	T19_StaticRealSubject real = new T19_StaticRealSubject();

	public T19_StaticProxySubject(T19_StaticRealSubject real) {
		super();
		this.real = real;
	}

	public T19_StaticProxySubject() {
		super();
	}

	//將請求分派給委托類執行，記錄執行前後的時間
	@Override
	public void dealTask(String taskName) {
		System.out.println("Proxy_運行代理類方法");
		//在執行真實對象的方法前後可以進行相應的邏輯
		real.dealTask(taskName);
		System.out.println("Proxy_代理類方法運行完畢");
	}

}
