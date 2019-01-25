package com.mickey.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.mapper.T23_UserMapper;
import com.mickey.pojo.User;

/**
 * ���ըϥ�MyBaties��{�ʺASQL
 */
public class T24_DynamicSqlTest {
	public static void main(String[] args) throws IOException {
		User user = inputSelectCondition();//�bconsole����J�d�߱���
		System.out.println(user.toString());
		
		InputStream is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		T23_UserMapper um = session.getMapper(T23_UserMapper.class);
//		List<User> users = um.selectForDynamicSql_if(user.getUid(), user.getUname(), user.getGender());
//		List<User> users = um.selectForDynamicSql_where(user.getUid(), user.getUname(), user.getGender());
//		List<User> users = um.selectForDynamicSql_choose(user.getUid(), user.getUname(), user.getGender());
		List<User> users = um.selectForDynamicSql_trim(user.getUid(), user.getUname(), user.getGender());
		users.stream().forEach(u->System.out.println(u.toString()));

//		int updateNum = um.updateForDynamicSql_set(user.getUid(), user.getUname(), user.getGender());
//		session.commit();
//		System.out.println(updateNum==1?"�ק令�\":"�ק異��");
//		System.out.println(um.selectForDynamicSql_where(user.getUid(), user.getUname(), user.getGender()));
		
//		inputInputCondition();
		
	}
	
	/**
	 * ��J�d�߱���
	 */
	private static User inputSelectCondition() {
		User user = new User();
		Scanner input = new Scanner(System.in);
		System.out.println("please input select condition�Guid�Buname�Bgender");
		
		String uidStr = input.nextLine();
		if(uidStr!=null && !uidStr.equals("")) {
			int uid = Integer.parseInt(uidStr);
			user.setUid(uid);
		}
		
		String uname = input.nextLine();
		if(uname!=null && !uname.equals("")) {
			user.setUname(uname);
		}
		
		String genderStr = input.nextLine();
		if(genderStr!=null && !genderStr.equals("")) {
			byte gender = Byte.parseByte(genderStr);
			user.setGender(gender);	
		}
		input.close();
		return user;
	}
	
	/**
	 * ��J�d�߱���
	 */
	private static User inputInputCondition() {
		User user = new User();
		Scanner input = new Scanner(System.in);
		System.out.println("please input select condition�Guid�Buname�Bgender");
		
		String uidStr = input.nextLine();
		if(uidStr!=null && !uidStr.equals("")) {
			int uid = Integer.parseInt(uidStr);
			user.setUid(uid);
		}
		
		String uname = input.nextLine();
		if(uname!=null && !uname.equals("")) {
			user.setUname(uname);
		}
		
		String genderStr = input.nextLine();
		if(genderStr!=null && !genderStr.equals("")) {
			byte gender = Byte.parseByte(genderStr);
			user.setGender(gender);	
		}
		input.close();
		return user;
	}
}
