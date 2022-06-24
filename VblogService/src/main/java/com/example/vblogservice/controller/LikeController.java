package com.example.vblogservice.controller;

import com.example.vblogservice.constants.StatusCode;
import com.example.vblogservice.entity.Result;
import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.entity.domian.LikeKey;
import com.example.vblogservice.entity.domian.User;
import com.example.vblogservice.service.LikeService;
import com.example.vblogservice.util.ResultUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class LikeController {

    final
    LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("like/counts/{userId}")
    Result countLikesByUserId(@PathVariable int userId) {
        long resultData = likeService.countLikeByUserId(userId);
        return ResultUtils.success(resultData);
    }

    @GetMapping("like/what/{userId}")
    Result getLikeListByUserId(@PathVariable int userId) {
        List<Article> resultData = likeService.getLikeListByUserId(userId);

        if (resultData.size() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get like relation by user id=%d: No relation found.", userId));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("like/by-whom/{articleId}")
    Result getLikerListByArticleId(@PathVariable int articleId) {
        List<User> resultData = likeService.getUserListByArticleId(articleId);

        if (resultData.size() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get like relation by article id=%d: No relation found.", articleId));
        else return ResultUtils.success(resultData);
    }

    @PostMapping("like")
    Result addLikeRelation(@RequestBody LikeKey likeKey) throws IOException {
        int affectedRows = likeService.addLikeRelation(likeKey);

        if (affectedRows == 0)
            return ResultUtils.error("4002", StatusCode.STATUS_CODE_4002 + " Add like relation failed.");
        else {
            return ResultUtils.success("");
        }
    }

    @DeleteMapping("like/{userId}/{articleId}")
    Result deleteLikeRelation(@PathVariable int userId, @PathVariable int articleId) {
        LikeKey likeKey = new LikeKey();
        likeKey.setUserId(userId);
        likeKey.setArticleId(articleId);

        int affectedRows = likeService.deleteLikeRelation(likeKey);

        if (affectedRows == 0)
            return ResultUtils.error("4003", StatusCode.STATUS_CODE_4003 + String.format(" Delete like relation by {userId=%d, articleId=%d}: Delete failed.", userId, articleId));
        else return ResultUtils.success("");
    }
}
