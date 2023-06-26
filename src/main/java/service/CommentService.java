package service;

import pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> SelectAllComments(String article_id);

    int InsertComments(String articleID,String content,String uid);




}
