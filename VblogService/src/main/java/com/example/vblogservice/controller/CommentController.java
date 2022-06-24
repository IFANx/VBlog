package com.example.vblogservice.controller;

import com.example.vblogservice.constants.StatusCode;
import com.example.vblogservice.entity.Result;
import com.example.vblogservice.entity.domian.Comment;
import com.example.vblogservice.service.CommentService;
import com.example.vblogservice.util.ResultUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * @param comment comment-json对象
     * @return 操作结果
     */
    @PostMapping("comment")
    public Result addComment(@RequestBody Comment comment) {
        int res = commentService.addComment(comment);
        if (res == 0x7fffff) return ResultUtils.error("1200", "评论失败");
        else if (res != 0) return ResultUtils.error("0000", "评论成功");
        else return ResultUtils.error("1100", "评论失败");
    }

    /**
     * @param articleId 文章ID
     * @return 对应文章列表，按回复时间排序
     */
    @GetMapping("comment/byArticleId/paged")
    public Result getCommentByArticleId(int articleId, int startPage, int pageSize) {
        PageInfo<Comment> resultData = commentService.getCommentByAriticle(articleId, startPage, pageSize);
        if (resultData.getTotal() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get comment by article=%d paged: No comment found.", articleId));
        else return ResultUtils.success(resultData);
    }


    /**
     * @param id commentID
     * @return 操作结果
     */
    @DeleteMapping("comment")
    public Result deleteComment(int id) {
        int res = commentService.deleteComment(id);
        if (res != 0) return ResultUtils.success("0000", "删除成功");
        else return ResultUtils.error("1100", "删除失败");

    }

    /**
     * @param comment comment-json对象
     * @return 更新后的文章comment信息
     */
    @PutMapping("comment")
    public Result updateComment(@RequestBody Comment comment) {
        int res = commentService.updateById(comment);
        if (res != 0) return ResultUtils.success("0000");
        else return ResultUtils.error("1100", "更新失败");
    }


}
