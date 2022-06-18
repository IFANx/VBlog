package com.example.vblogservice.service;


import com.example.vblogservice.entity.domian.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentByAriticle(int AriticleId);

    int addComment(Comment comment);

    int deleteComment(int id);

    int updateById(Comment comment);

}
