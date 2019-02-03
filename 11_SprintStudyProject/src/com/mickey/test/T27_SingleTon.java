package com.mickey.test;

/*
 * ��ҳ]�p�Ҧ��A�i�~���A��H�u���b�եΪ��ɭԤ~�إ�
 */
public class T27_SingleTon {
	// ��������L�������եΦ��ܶq�A�]���ϥ�private
	private static T27_SingleTon singleTon = new T27_SingleTon();

	private T27_SingleTon() {}

	/*
	 * ��Ҥ�k�A��Ҥ�k�����q�L��H�ӽե� �n�]�m��k���R�A��k(�]���L�k�q�Lnew�ӹ�Ҥƹ�H)
	 */
	public static T27_SingleTon getInstance() {
		if (singleTon == null) {// �p�G��H�S���Q��ҤƹL�~new�A�_�Ѫ�����^
			synchronized (T27_SingleTon.class) {// �b�h�u�{�X�ݤU�A�i��X�{if�P�ɦ��ߪ�í�p�A�ݲK�[��
				if (singleTon == null) {// ��������
					singleTon = new T27_SingleTon();
				}
			}
		}
		return singleTon;
	}
}
