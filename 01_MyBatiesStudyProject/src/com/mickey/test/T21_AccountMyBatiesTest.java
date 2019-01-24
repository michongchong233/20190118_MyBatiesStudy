package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.pojo.TransferLog;

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
//		Map<String, String> selAccount = new HashMap<String, String>();
//		selAccount.put("account_name", "aaaa");
//		selAccount.put("password", "aaaa");
//		Account a = session.selectOne("com.mickey.mapper.account.selectAccount", selAccount);
//		System.out.println(a!=null?a.toString():"登入失敗");
		
		//insert a new transfer log for test
//		Map<String, Object> logMap = new HashMap<String, Object>();
//		logMap.put("out_account", "aaaa");
//		logMap.put("in_account", "aaaa");
//		logMap.put("transfer_money", 55);
//		logMap.put("transfer_datetime", LocalDateTime.now());
//		session.insert("com.mickey.mapper.account.insertLog", logMap);
//		session.commit();
		
		//select all TransferLog
		List<TransferLog> logs = session.selectList("com.mickey.mapper.account.selectAllLog");
		logs.stream().forEach(l->System.out.println(l.toString()));
		
	}
}
