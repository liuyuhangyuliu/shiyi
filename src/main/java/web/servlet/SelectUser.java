package web.servlet;

import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SelectUser", value = "/selectUser")
public class SelectUser extends HttpServlet {

    private UserService userService =  new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置临时文件大小（有时候可能传的文件太大，需要使用临时文件）
        factory.setSizeThreshold(1024 * 1024);


        //工厂相关的参数设置完成后，以工厂为模版，new一个upload实例
        ServletFileUpload upload = new ServletFileUpload(factory);

        try{

            List<FileItem> items = upload.parseRequest(request);

            String username = items.get(0).getString();
            String password = items.get(1).getString();

            User user = userService.SelectUser(username,password);

            response.setContentType("text/json;charset=utf-8");
            PrintWriter writer = response.getWriter();

            if(user == null){

                writer.write("false");
            }else{



                String jsonString = JSON.toJSONString(user);
                Cookie username_cookie = new Cookie("username",user.getUsername());
                Cookie avatarSrc_cookie = new Cookie("avatarSrc",user.getAvatarSrc());
                Cookie coverSrc_cookie = new Cookie("coverSrc",user.getCoverSrc());
                Cookie uid_cookie = new Cookie("uid",user.getUid());

                response.addCookie(username_cookie);
                response.addCookie(avatarSrc_cookie);
                response.addCookie(coverSrc_cookie);
                response.addCookie(uid_cookie);

                writer.write(jsonString);



            }



        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
