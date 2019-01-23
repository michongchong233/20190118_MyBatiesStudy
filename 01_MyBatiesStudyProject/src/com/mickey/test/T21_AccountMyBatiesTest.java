package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.pojo.Account;

/**
 * 用來測試MyBaties SQL數據是否正確
 */
public class T21_AccountMyBatiesTest {
	public static void main(String[] args) throws IOException {
		InputStream is;
		is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		//全選測試
//		List<Account> accounts = session.selectList("com.mickey.mapper.account.selectAll");
//		accounts.stream().forEach(a->System.out.println(a.toString()));
		
		//查詢用戶帳號密碼測試
		Map selAccount = new HashMap();
		selAccount.put("account_name", "aaaa");
		selAccount.put("password", "aaaa");
		Account a = session.selectOne("com.mickey.mapper.account.selectAccount", selAccount);
		System.out.println(a!=null?a.toString():"登入失敗");
		
	}
}
