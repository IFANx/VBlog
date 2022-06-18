package com.example.vblogservice.service;


import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.entity.domian.ArticleExample;
import com.example.vblogservice.entity.domian.Comment;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentService {
    PageInfo<Comment> getCommentByAriticle(int AriticleId,int startPage,int pageSize);

    int addComment(Comment comment);

    int deleteComment(int id);

    int updateById(Comment comment);

}
