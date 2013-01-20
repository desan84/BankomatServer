package panchenko.igor.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 20.01.13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class CheckPhoneAndPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);

    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response){
        String numberPhone = request.getParameter("phone");
        String userPassword = request.getParameter("password");
        boolean authSuccess = false;
            if (numberPhone.equals("0636618956")&&(userPassword.equals("1234"))){
                authSuccess = true;
        }
        try {
            PrintWriter printWriter = response.getWriter();
            if (authSuccess){
                printWriter.write("status:Ok");
            }else{
                printWriter.write("status:Fail");
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);
    }
}
