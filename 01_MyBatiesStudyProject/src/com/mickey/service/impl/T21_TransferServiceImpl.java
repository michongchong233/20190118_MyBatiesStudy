package com.mickey.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mickey.pojo.Account;
import com.mickey.pojo.MessageCode;
import com.mickey.service.T21_TransferService;

public class T21_TransferServiceImpl implements T21_TransferService {
	@Override
	public MessageCode transferAccount(String outAccount_name, String outPassword, double money, String inAccount_name,
			String inName) throws IOException {
		InputStream is = Resources.getResourceAsStream("myBaties.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Map<String, String> outAccMap = new HashMap<String, String>();
		outAccMap.put("outAccount_name", outAccount_name);
		outAccMap.put("outPassword", outPassword);
		Account outAcc = session.selectOne("com.mickey.mapper.account.selectAccount_1", outAccMap);
		if (outAcc != null) {// 當數據庫有轉出帳戶
			double balance = outAcc.getBalance();
			if (balance >= money) {// 當轉出帳戶還有足夠的余額
				Map<String, String> inAccMap = new HashMap<String, String>();
				inAccMap.put("account_name", inAccount_name);
				inAccMap.put("uname", inName);
				Map<String, Object> updateMap_out = new HashMap<String, Object>();
				updateMap_out.put("balance", outAcc.getBalance() - money);
				updateMap_out.put("uid", outAcc.getUid());
				int updateNum_out = session.update("com.mickey.mapper.account.updateBalance", updateMap_out);
				if (updateNum_out == 1) {// 扣款成功
					Account inAcc = session.selectOne("com.mickey.mapper.account.selectAccount_2", inAccMap);
					if (inAcc != null) {// 當數據庫有轉入帳戶
						Map<String, Object> updateMap_in = new HashMap<String, Object>();
						updateMap_in.put("balance", inAcc.getBalance() + money);
						updateMap_in.put("uid", inAcc.getUid());
						int updateNum_in = session.update("com.mickey.mapper.account.updateBalance", updateMap_in);
						if (updateNum_in == 1) {// 存款成功
							session.commit();
							return MessageCode.SUCCESS;
						}
					} else {
						// 無此轉戶帳戶
						return MessageCode.ERROR_002;
					}
				}
			} else {
				// 余額不足
				return MessageCode.ERROR_003;
			}
		} else {
			// 帳號或密碼錯誤
			return MessageCode.ERROR_001;
		}
		//不明錯誤
		return MessageCode.ERROR_004;
	}
}
