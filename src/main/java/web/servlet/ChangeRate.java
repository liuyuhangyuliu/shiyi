package web.servlet;

import service.ArticleService;
import service.RateService;
import service.impl.ArticleServiceImpl;
import service.impl.RateServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangeRate", value = "/changeRate")
public class ChangeRate extends HttpServlet {
    private ArticleService articleService = new ArticleServiceImpl();
    private RateService rateService = new RateServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int rate = Integer.parseInt(request.getParameter("rate"));
        String articleID = request.getParameter("articleID");
        String uid = request.getParameter("uid");

        int hasRate = rateService.hasRate(articleID,uid);
        if(0 != hasRate){
            rateService.updateRate(rate,articleID,uid);
            articleService.updateAvgRate(articleID);
        }else{
            rateService.insertRate(rate,articleID,uid);
            articleService.updateAvgRate(articleID);
            articleService.addMarkNumber(Integer.parseInt(articleID));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
