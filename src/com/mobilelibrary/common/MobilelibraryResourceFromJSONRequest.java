package com.mobilelibrary.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.json.JSONException;
import org.json.JSONObject;

import com.mobilelibrary.entity.BookRecommendEntity;
import com.mobilelibrary.entity.BookSearchEntity;
import com.mobilelibrary.entity.UserEntity;
import com.mobilelibrary.handlerexception.WSError;
import com.mobilelibrary.net.HttpRequest;
import com.mobilelibrary.parse.PersonInformationParser;

/*
 * �����������װJSON���󼰵õ���Ӧ��Դ
 */
public class MobilelibraryResourceFromJSONRequest  {
	
	
	//login
	public UserEntity loginAuthentication(String userID ,String password) throws JSONException, WSError{
		// TODO Auto-generated method stub
		
		//generate JSON object
		JSONObject param = new JSONObject();
		param.put("userId", userID);
		param.put("password", password);

		InputStream   inputStream  = HttpRequest.requestByXML("url",param.toString());
		
		//		UserEntity  userEntity = (UserEntity)new PersonInformationParser().executeToObject(inputStream, null);

		//test
		UserEntity  userEntity = (UserEntity)new PersonInformationParser().executeToObject(new ByteArrayInputStream(param.toString().getBytes()), null);
		
		return userEntity;
	}
    
	//�˷���������ȡ�Ƽ�������
	public BookRecommendEntity[] getBooksRecommend() throws JSONException, WSError{
		// TODO Auto-generated method stub
		
		//����Ĵ���Ŀǰֻ����������
		BookRecommendEntity[] books = new BookRecommendEntity[5];
		BookRecommendEntity  book = null;
		for (int i = 0; i < 5; i++) {
			
			if (i == 0) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("Android开发实践");
			}
			if (i == 1) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("JaveEE 5");
			}
			if (i == 2) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("数据结构与算法");
			}
			if (i == 3) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("JavaEE入门到精通");
			}
			if (i == 4) {
				book = new BookRecommendEntity();
				book.setBookImageUrl("aa");
				book.setBookText("Android实践与提高");
			}
			books[i]=book;
			
		}
		//����Ĵ���ֻ����������
		
		
		return books;
	}
	
	//�˷���������ȡ������������
	public BookSearchEntity[] getBooksSearch(String query) throws JSONException, WSError{
		// TODO Auto-generated method stub
		
		//����Ĵ���Ŀǰֻ����������
		BookSearchEntity[] books = new BookSearchEntity[5];
		BookSearchEntity  book = null;
		
		for (int i = 0; i < 5; i++) {
			
			if (i == 0) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("Android开发实践");
			}
			if (i == 1) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("JaveEE 5");
			}
			if (i == 2) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("数据结构与算法");
			}
			if (i == 3) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("JavaEE入门到精通");
			}
			if (i == 4) {
				book = new BookSearchEntity();
				book.setBookImageUrl("aa");
				book.setBookText("Android实践与提高");
			}
			books[i]=book;
		}
		
		return books;
	}

}
