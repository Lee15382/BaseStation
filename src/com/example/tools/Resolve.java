package com.example.tools;

import java.util.ArrayList;
import java.util.List;

import com.example.basestation.Info;

public class Resolve {
	
	private Info in;
	private String data;
	private List<Info> list = new ArrayList<Info>();
	
	public Resolve(String data){
		this.data = data;
	}
	
	public  List<Info> data(){
	String[] a= data.split(";");//ʹ�÷ֺŽ���õ��ַ����ָ�װ��������
	for(int i=1;i<=(a.length-17);i+=18){ //��λ��ע������Խ������
		in = new Info(a[i], a[i+8],a[i+9]); //ȡÿ�и���
		list.add(in);
		}
	
	return list;
	}	

}
