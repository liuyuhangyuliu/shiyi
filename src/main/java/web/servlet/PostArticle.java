package web.servlet;

import com.alibaba.fastjson.JSONObject;
import service.ArticleService;
import service.impl.ArticleServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet(name = "PostArticle", value = "/postArticle")
public class PostArticle extends HttpServlet {
    private ArticleService articleService = new ArticleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        JSONObject jsonObject = null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader( request.getInputStream(), "UTF-8" ) );
            StringBuilder jsonStrBuilder = new StringBuilder();
            String inputStr = "";
            while ((inputStr = streamReader.readLine())!= null){
                jsonStrBuilder.append( inputStr );
            }
            jsonObject = JSONObject.parseObject( jsonStrBuilder.toString() );

        }catch (Exception e){
            e.printStackTrace();
        }

        String content = jsonObject.get("content").toString();
        String uid = jsonObject.get("uid").toString();
        String title = jsonObject.get("title").toString();
        String preview = jsonObject.get("preview").toString();
        String username = jsonObject.get("username").toString();
        String cover = jsonObject.get("cover").toString();

        articleService.postArticle(title,username,content,preview,uid,cover);


    }
}
