package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.Comment;
import com.example.vblogservice.entity.domian.CommentExample;
import com.example.vblogservice.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    final private CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    @Transactional
    public List<Comment> getCommentByAriticle(int ArticleId) {
        List<Comment> comments = commentMapper.selectByArticle(ArticleId);
//        List<Comment> comments = commentMapper.selectByExample(commentExample);
        return comments;
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
        return commentMapper.updateByPrimaryKey(comment);
    }
}
