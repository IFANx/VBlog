package com.example.vblogservice.controller;

import com.example.vblogservice.entity.Result;
import com.example.vblogservice.entity.domian.Comment;
import com.example.vblogservice.service.CommentService;
import com.example.vblogservice.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/add")
    public Result addcomment(@RequestBody Comment comment) {
        int res = commentService.addComment(comment);
        if(res == 0x7fffff)return ResultUtils.error("1200","评论失败");
        else if(res != 0)return ResultUtils.error("0000","评论成功");
        else return ResultUtils.error("1100","评论失败");
    }

    @GetMapping("/list")
    public Result getCommentByAriticle(int articleid){
        List<Comment> commentByAriticle = commentService.getCommentByAriticle(articleid);
        if(commentByAriticle.isEmpty()) return ResultUtils.success("错误码：1400，当前文章没有评论", new Comment());
        return ResultUtils.success("0000",commentByAriticle);
    }

    @DeleteMapping("/delete")
    public Result deleteComment(int id){
        int res = commentService.deleteComment(id);
        if(res != 0)return ResultUtils.success("0000","删除成功");
        else return ResultUtils.error("1100","删除失败");

    }

    @PutMapping("/update")
    public  Result updateComment(Comment comment){
        int res = commentService.updateById(comment);
        if (res != 0) return ResultUtils.success("0000",getCommentByAriticle(comment.getArticleId()));
        else return ResultUtils.error("1100","删除失败");
    }




}
