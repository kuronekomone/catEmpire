package wiki;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginCheck extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=Shift_JIS");
    PrintWriter out = response.getWriter();

    String user = request.getParameter("user");
    String pass = request.getParameter("pass");

    HttpSession session = request.getSession(true);

    boolean check = authUser(user, pass);
    if (check){
      /* �F�؍ς݂ɃZ�b�g */
      session.setAttribute("login", "OK");

      /* �{���̃A�N�Z�X��֔�΂� */
      String target = (String)session.getAttribute("/create.jsp");
      response.sendRedirect(target);
    }else{
      /* �F�؂Ɏ��s������A���O�C����ʂɖ߂� */
      session.setAttribute("status", "Not Auth");
      response.sendRedirect("/login.jsp");
    }
  }

  protected boolean authUser(String user, String pass){
    /* ��肠�������[�U�[���ƃp�X���[�h�����͂���Ă���ΔF�؂��� */
    if (user == null || user.length() == 0 || pass == null || pass.length() == 0){
      return false;
    }

    return true;
  }
}