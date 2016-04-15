package com.example.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.example.basestation.Info;

public class TestSocket {

	Socket socket;
	String data;
	StringBuffer s = new StringBuffer();

	public void createSocket() throws Exception {
		socket = new Socket("61.187.123.99", 6060); //��ַ���ü�http��ֱ��д����λ�ü���
	}
	
	public void communicate() throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("GET / HTTP/1.1\r\n");   //��������ʽΪGET������HTTP��1.1Э�飬����ͷ���ֶβ�����ӣ���Ϊ����POST��ʽ
		sb.append("\r\n");				   //��һ�е������Ǵ����ͽ�������д�Ļ����������᷵��

		// ����HTTP����
		OutputStream socketOut = socket.getOutputStream();
		socketOut.write(sb.toString().getBytes());
		socket.shutdownOutput(); // �ر������
		// ������Ӧ���
		System.out.println(socket);
		InputStream socketIn = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(socketIn));
		while ((data = br.readLine()) != null) {
			s.append(data);
		}
		socket.close();
	}
	
	//���������յ������ݷ��ͳ�ȥ
	public String getInformation() {
		return s.toString();
	}
}