package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.mapper.T23_UserMapper;
import com.mickey.pojo.User;

/*
 * 學習MyBaties的使用
 */
public class T26_CacheTest {
	public static void main(String[] args) throws IOException {
//		Connection conn = null;
//		conn.prepareStatement("sql");
//		conn.createStatement();
//		conn.prepareCall("sql");//調用存儲過程的方法
		
		InputStream is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		T23_UserMapper um = session.getMapper(T23_UserMapper.class);
		um.selectAll();
		
		//同一個SqlSession對象調用同一個<select>標簽時，只有第一次訪問數據庫，查詢結束後把查詢結果緩存到SqlSession緩存區(內存)中
		um.selectAll();
		
		//使用不同的select標簽就是屬於不同的statement
		List<User> users_cache = um.selectAll_Cache();
		session.close();
		
		//有效范圍必須是同一個SqlSession，否則同一個<select>還是會查詢數據庫
		//<cache readOnly="true"></cache>將內存等級提升到SqlSessionFactory(二級緩存)
		//SqlSession和SqlSessionFactory的緩存空間不一樣(相互獨立)
		//在SqlSession關閉後才會將sql放入SqlSessionFactory的緩存中
		SqlSession session2 = factory.openSession();
		T23_UserMapper um2 = session2.getMapper(T23_UserMapper.class);
		um2.selectAll();
		
		session.close();
	}
}
