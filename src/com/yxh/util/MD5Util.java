package com.yxh.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {
	public static String makePassword(String password) {
		MessageDigest md;
		try {
			// ����һ��MD5���ܼ���ժҪ
			md = MessageDigest.getInstance("MD5");
			// ����md5����
			md.update(password.getBytes());
			// digest()���ȷ������md5 hashֵ������ֵΪ8λ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
			// BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
			//BigInteger(1,md.digest()),����1��ʾ��������-1��ʾ������0��ʾ0  
			//java.math.BigInteger.toString(int radix) ���ش�BigInteger�ڸ����Ļ������ַ�����ʾ��ʽ��
			//��������Ǵ�Character.MIN_RADIX��Character.MAX_RADIX���ݵķ�Χ�ڣ�����Ĭ��Ϊ10(��ΪInteger.toString�������)��
			String pwd = new BigInteger(1, md.digest()).toString(16);
			return pwd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
}