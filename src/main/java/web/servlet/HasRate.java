package web.servlet;

import service.RateService;
import service.impl.RateServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HasRate", value = "/hasRate")
public class HasRate extends HttpServlet {
    private RateService rateService = new RateServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String articleID = request.getParameter("articleID");
        String uid = request.getParameter("uid");

        int hasRate = rateService.hasRate(articleID,uid);
        response.getWriter().write(Integer.toString(hasRate));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
