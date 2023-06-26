package web.servlet;

import com.alibaba.fastjson.JSONObject;
import mapper.ArticleMapper;
import service.ArticleService;
import service.CommentService;
import service.impl.ArticleServiceImpl;
import service.impl.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet(name = "InsertComments", value = "/insertComments")
public class InsertComments extends HttpServlet {

    private CommentService commentService = new CommentServiceImpl();
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

        String articleID = jsonObject.get("articleID").toString();
        String content = jsonObject.get("content").toString();
        String uid = jsonObject.get("uid").toString();

        int success = commentService.InsertComments(articleID,content,uid);
        articleService.addCommentNumber(Integer.parseInt(articleID));
        if(1 == success ){
            response.getWriter().write("success");
        }

    }
}
