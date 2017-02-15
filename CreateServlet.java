package wiki;

import java.io.IOException;
import java.sql.SQLException;
import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;

import java.net.URL;
import java.sql.*;


public class CreateServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		String image = req.getParameter("path");
		
		System.out.println("csimage= " +image);
		
		//�����Ă����ʐ^��url�Ƀt���p�X�ɂȂ�悤�ɕ������t�^
		String url="file:"+image;
		System.out.println("csurl1="+url);
		URL imageurl = new URL(url);
		//URL �I�u�W�F�N�g�� = new URL(�t�@�C����);
		
		System.out.println("csurl2= " +imageurl);
		
		String path = imageurl.getPath();
		
		System.out.println("csurl3= " +path);
		
		try{
			//WikiPage��new����
			WikiPage wikiPage = new WikiPage();
			
			//Jsp����̏����Z�b�g
			wikiPage.setName(name);
			wikiPage.setContent(content);
			wikiPage.setPath(path);
			
			//WikiPageDAO�̃C���X�^���X���擾���A
			//�Z�b�g�������e��sql���ɏ�������
			WikiPageDAO.getInstance().insert(wikiPage);
			
			//DB�ւ̃A�b�v�f�[�g
			RequestUtils.setMessage(req, name + "���쐬���܂���");
			
			//req.setAttribute("path",path);
			
			req.getRequestDispatcher("/refer").forward(req,res);
			
			System.out.println("csurl4= " +path);
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}