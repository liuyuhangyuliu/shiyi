package web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UploadCover", value = "/uploadCover")
public class UploadCover extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("uid");

        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);

        request.setCharacterEncoding("utf-8");
        //设置缓冲区大小和临时目录
        factory.setSizeThreshold(1024*1024*10);
        File uploadTemp=new File("d:\\uploadTemp");
        uploadTemp.mkdirs();
        factory.setRepository(uploadTemp);

        try {
            List<FileItem> list=upload.parseRequest(request);
            System.out.println(list);
            for (FileItem fileItem:list){
                if (!fileItem.isFormField()&&fileItem.getName()!=null&&!"".equals(fileItem.getName())){
                    String fileName=fileItem.getName();
                    //利用UUID生成伪随机字符串，作为文件名避免重复
                    String uuid= UUID.randomUUID().toString();
                    //获取文件后缀名
                    String suffix=fileName.substring(fileName.lastIndexOf("."));

                    //获取文件上传目录路径，在项目部署路径下的upload目录里。若想让浏览器不能直接访问到图片，可以放在WEB-INF下
                    //如果用这个获取路径并放到那，每次重启服务器图片就没了，索性放在固定位置，模拟上传到文件服务器
                    String uploadPath=request.getSession().getServletContext().getRealPath("/public/images");
                    //String uploadPath = "C:/Users/DELL/IdeaProjects/shiyi/web/public/images";

                    File file=new File(uploadPath);
                    System.out.println(uploadPath);
                    file.mkdirs();
                    //写入文件到磁盘，该行执行完毕后，若有该临时文件，将会自动删除
                    fileItem.write(new File(uploadPath,uuid+suffix));

                    userService.UpdateCover("/shiyi_war/public/images/"+uuid+suffix,uid);

                    response.getWriter().write("/shiyi_war/public/images/"+uuid+suffix);
                }
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }






    }
}
