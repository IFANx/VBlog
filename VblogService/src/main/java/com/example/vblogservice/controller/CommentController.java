package com.example.vblogservice.controller;

import com.example.vblogservice.constants.StatusCode;
import com.example.vblogservice.entity.Result;
import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.entity.domian.ArticleExample;
import com.example.vblogservice.entity.domian.Comment;
import com.example.vblogservice.service.CommentService;
import com.example.vblogservice.util.ResultUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * @param comment comment-json对象
     * @return 操作结果
     */
    @PostMapping("/add")
    public Result addcomment(@RequestBody Comment comment) {
        int res = commentService.addComment(comment);
        if(res == 0x7fffff)return ResultUtils.error("1200","评论失败");
        else if(res != 0)return ResultUtils.error("0000","评论成功");
        else return ResultUtils.error("1100","评论失败");
    }

    /**
     * @param articleid 文章ID
     * @return 对应文章列表，按回复时间排序
     */
    @GetMapping("list/articleid/paged/{articleid}/{startPage}/{pageSize}")
    public Result getCommentByAriticle(
            @PathVariable int articleid, @PathVariable int startPage, @PathVariable int pageSize) {
        PageInfo<Comment> resultData = commentService.getCommentByAriticle(articleid, startPage, pageSize);
        if (resultData.getTotal() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get comment by article=%d paged: No comment found.", articleid));
        else return ResultUtils.success(resultData);
    }


    /**
     * @param id commentID
     * @return 操作结果
     */
    @DeleteMapping("/delete")
    public Result deleteComment(int id){
        int res = commentService.deleteComment(id);
        if(res != 0)return ResultUtils.success("0000","删除成功");
        else return ResultUtils.error("1100","删除失败");

    }

    /**
     * @param comment comment-json对象
     * @return 更新后的文章comment信息
     */
    @PutMapping("/update")
    public  Result updateComment(@RequestBody Comment comment){
        int res = commentService.updateById(comment);
        if (res != 0) return ResultUtils.success("0000");
        else return ResultUtils.error("1100","更新失败");
    }



}
