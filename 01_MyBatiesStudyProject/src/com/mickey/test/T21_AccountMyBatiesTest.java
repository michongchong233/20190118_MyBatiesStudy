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
		Map selAccount = new HashMap();
		selAccount.put("account_name", "aaaa");
		selAccount.put("password", "aaaa");
		Account a = session.selectOne("com.mickey.mapper.account.selectAccount", selAccount);
		System.out.println(a!=null?a.toString():"�n�J����");
		
	}
}
