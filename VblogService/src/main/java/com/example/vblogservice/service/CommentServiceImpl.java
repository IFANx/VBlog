package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.Comment;
import com.example.vblogservice.mapper.CommentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommentServiceImpl implements CommentService{
    final private CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    @Override
    @Transactional
    public PageInfo<Comment> getCommentByAriticle(int AriticleId, int startPage, int pageSize) {
        Page<Comment> page = PageHelper
                .startPage(startPage, pageSize)
                .doSelectPage(
                        () -> commentMapper.selectByArticle(AriticleId)
                );
        return new PageInfo<>(page);
    }

    @Override
    @Transactional
    public int addComment(Comment comment) {
        commentMapper.insert(comment);
        return comment.getId();
    }

    @Override
    @Transactional
    public int deleteComment(int id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateById(Comment comment) {
        System.out.println(comment.getId());
        return commentMapper.updateById(comment.getId(),comment);
    }
}
