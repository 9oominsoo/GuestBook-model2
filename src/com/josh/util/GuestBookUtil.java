package com.josh.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GuestBookUtil {

  public static void forward(HttpServletRequest request, HttpServletResponse response, String path)
  throws ServletException, IOException
  {
    RequestDispatcher rd = request.getRequestDispatcher(path);
    rd.forward(request, response);
  }

  public static void redirect(HttpServletRequest Request, HttpServletResponse response, String url)
  throws IOException
  {
    response.sendRedirect(url);
  }

}
