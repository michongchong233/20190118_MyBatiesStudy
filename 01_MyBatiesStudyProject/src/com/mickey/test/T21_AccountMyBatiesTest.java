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
 * �ΨӴ���MyBaties SQL�ƾڬO�_���T
 */
public class T21_AccountMyBatiesTest {
	public static void main(String[] args) throws IOException {
		InputStream is;
		is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		//�������
//		List<Account> accounts = session.selectList("com.mickey.mapper.account.selectAll");
//		accounts.stream().forEach(a->System.out.println(a.toString()));
		
		//�d�ߥΤ�b���K�X����
//		Map<String, String> selAccount = new HashMap<String, String>();
//		selAccount.put("account_name", "aaaa");
//		selAccount.put("password", "aaaa");
//		Account a = session.selectOne("com.mickey.mapper.account.selectAccount", selAccount);
//		System.out.println(a!=null?a.toString():"�n�J����");
		
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
