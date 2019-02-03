package com.mickey.test;

/*
 * ��ҳ]�p�Ҧ��A�i�~���A��H�u���b�եΪ��ɭԤ~�إ�
 */
public class T26_SingleTon {
	// ��������L�������եΦ��ܶq�A�]���ϥ�private
	private static T26_SingleTon singleTon;

	/*
	 * ��k�W�M���W�ۦP�A�åB�L��^�� ��L�������ҤƳo��������H-->�]��private �����n��~���ѳX�ݤJ�f
	 */
	private T26_SingleTon() {
	}

	/*
	 * ��Ҥ�k�A��Ҥ�k�����q�L��H�ӽե� �n�]�m��k���R�A��k(�]���L�k�q�Lnew�ӹ�Ҥƹ�H)
	 */
	public static T26_SingleTon getInstance() {
		if (singleTon == null) {// �p�G��H�S���Q��ҤƹL�~new�A�_�Ѫ�����^
			synchronized (T26_SingleTon.class) {// �b�h�u�{�X�ݤU�A�i��X�{if�P�ɦ��ߪ�í�p�A�ݲK�[��
				if (singleTon == null) {// ��������
					singleTon = new T26_SingleTon();
				}
			}
		}
		return singleTon;
	}
}
