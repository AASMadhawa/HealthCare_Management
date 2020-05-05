package com.HelthCare.Model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Servlet implementation class ItemsAPI
 */
@WebServlet("/ItemsAPI")
public class ItemsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 Item itemObj = new Item();
       
    public ItemsAPI() {
        super();
       
    }

    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		
		 String output = itemObj.insertItem(request.getParameter("u_id"),
		 request.getParameter("u_fname"),
		 request.getParameter("u_lname"),
		 request.getParameter("u_age"),
		 request.getParameter("u_address"),
		 request.getParameter("u_sex"),
		 request.getParameter("u_email"),
		 request.getParameter("u_username"),
		 request.getParameter("u_password"),
		 request.getParameter("u_type"),
		 request.getParameter("u_contact"));
		 
		 response.getWriter().write(output);
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 Map paras = getParasMap(request);
		 String output = itemObj.updateItem(paras.get("hidItemIDSave").toString(),
		 
		 paras.get("u_fname").toString(),
		 paras.get("u_lname").toString(),
		 paras.get("u_age").toString(),
		 paras.get("u_address").toString(),
		 paras.get("u_sex").toString(),
		 paras.get("u_email").toString(),
		 paras.get("u_username").toString(),
		 paras.get("u_password").toString(),
		 paras.get("u_type").toString(),
		 paras.get("u_contact").toString());
		 
		response.getWriter().write(output);
		} 

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		 Map paras = getParasMap(request);
		 String output = itemObj.deleteItem(paras.get("u_id").toString());
		 response.getWriter().write(output);
		}
	
	private static Map getParasMap(HttpServletRequest request)
    {
     Map<String, String> map = new HashMap<String, String>();
    try {
     Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
     String queryString = scanner.hasNext() ?
     scanner.useDelimiter("\\A").next() : "";
     scanner.close();
     String[] params = queryString.split("&");
     for (String param : params)
     { 
    	 String[] p = param.split("=");
    	 map.put(p[0], p[1]);
     }
      }catch (Exception e)
    	 {
    	 }
    	return map;
    }

}
