package web.servlet;

import mapper.RateMapper;
import service.RateService;
import service.impl.RateServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SelectMyRate", value = "/selectMyRate")
public class SelectMyRate extends HttpServlet {
    private RateService rateService = new RateServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String articleID = request.getParameter("articleID");
        String uid = request.getParameter("uid");

        float rate = rateService.selectMyRate(articleID,uid);

        response.getWriter().write(Float.toString(rate));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
