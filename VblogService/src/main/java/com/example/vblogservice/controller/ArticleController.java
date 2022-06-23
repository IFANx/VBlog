package com.example.vblogservice.controller;

import com.example.vblogservice.constants.StatusCode;
import com.example.vblogservice.entity.Result;
import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.entity.domian.ArticleExample;
import com.example.vblogservice.entity.domian.ArticleWithBLOBs;
import com.example.vblogservice.service.ArticleService;
import com.example.vblogservice.util.ResultUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ArticleController {

    final
    ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("article/{id}")
    public Result getArticleById(@PathVariable int id) {
        Article result = articleService.getArticleById(id);

        if (result == null)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get article by ID=%d: Article not exist.", id));
        else return ResultUtils.success(result);
    }

    @GetMapping("article/counts")
    public Result getArticleCounts() {
        ArticleExample example = new ArticleExample(); // no criteria, count all articles.

        Long resultData = articleService.getArticleCountsByExample(example);
        return ResultUtils.success(resultData);
    }

    @GetMapping("articles")
    public Result getAllArticles() {
        ArticleExample example = new ArticleExample();// non criteria, get all articles.
        List<ArticleWithBLOBs> resultData = articleService.getArticleByExample(example);

        if (resultData.size() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + " Get all articles: No article record yet.");
        else return ResultUtils.success(resultData);
    }

    @GetMapping("articles/paged/{startPage}/{pageSize}")
    public Result getArticlesPaged(@PathVariable int startPage, @PathVariable int pageSize) {
        ArticleExample example = new ArticleExample();// non criteria, get all articles.
        PageInfo<Article> resultData = articleService.getArticlesByExamplePaged(example, startPage, pageSize);

        if (resultData.getTotal() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + " Get all articles paged: No article record yet.");
        else return ResultUtils.success(resultData);
    }

    @GetMapping("article/counts/title/{title}")
    public Result getArticleCountsByTitle(@PathVariable String title) {
        // set example, count articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo(title);
        criteria.andTitleIsNotNull();

        Long resultData = articleService.getArticleCountsByExample(example);

        return ResultUtils.success(resultData);
    }

    @GetMapping("article/counts/title/fuzzy/{title}")
    public Result getArticleFuzzyCountsByTitle(@PathVariable String title) {
        // set example, count articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleLike("%" + title + "%");
        criteria.andTitleIsNotNull();

        Long resultData = articleService.getArticleCountsByExample(example);

        return ResultUtils.success(resultData);
    }

    @GetMapping("articles/title/{title}")
    public Result getArticlesByTitle(@PathVariable String title) {
        // set example, search articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo(title);
        criteria.andTitleIsNotNull();

        List<ArticleWithBLOBs> resultData = articleService.getArticleByExample(example);

        if (resultData.size() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by title=%s: No article found.", title));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("articles/title/paged/{title}/{startPage}/{pageSize}")
    public Result getArticlesByTitlePaged(
            @PathVariable String title, @PathVariable int startPage, @PathVariable int pageSize) {
        // set example, page articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo(title);
        criteria.andTitleIsNotNull();

        PageInfo<Article> resultData = articleService.getArticlesByExamplePaged(example, startPage, pageSize);

        if (resultData.getTotal() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by title=%s paged: No article found.", title));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("articles/title/fuzzy/{title}")
    public Result getArticleByTitleFuzzy(@PathVariable String title) {
        // set example, search articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleLike("%" + title + "%");
        criteria.andTitleIsNotNull();

        List<ArticleWithBLOBs> resultData = articleService.getArticleByExample(example);

        if (resultData.size() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Fuzzy Query articles by title=%s: No article found.", title));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("articles/title/fuzzy/paged/{title}/{startPage}/{pageSize}")
    public Result getArticlesByTitleFuzzyPaged(
            @PathVariable String title, @PathVariable int startPage, @PathVariable int pageSize) {
        // set example, page articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleLike("%" + title + "%");
        criteria.andTitleIsNotNull();

        PageInfo<Article> resultData = articleService.getArticlesByExamplePaged(example, startPage, pageSize);

        if (resultData.getTotal() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Fuzzy Query articles by title=%s paged: No article found.", title));
        else return ResultUtils.success(resultData);
    }


    @GetMapping("article/counts/tag/{tag}")
    public Result getArticleCountsByTag(@PathVariable String tag) {
        // set example, count articles by tag.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTagEqualTo(tag);
        criteria.andTagIsNotNull();

        Long resultData = articleService.getArticleCountsByExample(example);
        return ResultUtils.success(resultData);
    }

    @GetMapping("articles/tag/{tag}")
    public Result getArticleByTag(@PathVariable String tag) {
        // set example, search articles by tag.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTagEqualTo(tag);
        criteria.andTagIsNotNull();

        List<ArticleWithBLOBs> resultData = articleService.getArticleByExample(example);

        if (resultData.size() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by tag=%s: No article found.", tag));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("articles/tag/paged/{tag}/{startPage}/{pageSize}")
    public Result getArticlesByTagPaged(
            @PathVariable String tag, @PathVariable int startPage, @PathVariable int pageSize) {
        // set example, page articles by tag.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTagEqualTo(tag);
        criteria.andTagIsNotNull();

        PageInfo<Article> resultData = articleService.getArticlesByExamplePaged(example, startPage, pageSize);

        if (resultData.getTotal() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by tag=%s paged: No article found.", tag));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("article/counts/user_id/{userId}")
    public Result getArticleCountsByUserId(@PathVariable int userId) {
        // set example, count articles by user id.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andUserIdIsNotNull();

        Long resultData = articleService.getArticleCountsByExample(example);
        return ResultUtils.success(resultData);
    }

    @GetMapping("articles/user_id/{userId}")
    public Result getArticleByUserId(@PathVariable int userId) {
        // set example, search articles by user id.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andUserIdIsNotNull();

        List<ArticleWithBLOBs> resultData = articleService.getArticleByExample(example);

        if (resultData.size() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by user id=%d: No article found.", userId));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("articles/user_id/paged/{userId}/{startPage}/{pageSize}")
    public Result getArticlesByUserIdPaged(
            @PathVariable int userId, @PathVariable int startPage, @PathVariable int pageSize) {
        // set example, page articles by user id.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andUserIdIsNotNull();

        PageInfo<Article> resultData = articleService.getArticlesByExamplePaged(example, startPage, pageSize);

        if (resultData.getTotal() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by user id=%d paged: No article found.", userId));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("article/counts/publish_time/{publishTime}")
    public Result getArticleCountsByPublishTime(@PathVariable Date publishTime) {
        // set example, search articles by publish time.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andPublishTimeEqualTo(publishTime);
        criteria.andPublishTimeIsNotNull();

        Long resultData = articleService.getArticleCountsByExample(example);
        return ResultUtils.success(resultData);
    }

    @GetMapping("article/counts/publish_time/{startTime}/{endTime}")
    public Result getArticleCountsByPublishTimeRange(@PathVariable Date startTime, @PathVariable Date endTime) {
        // set example, search articles by publish time range.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andPublishTimeBetween(startTime, endTime);
        criteria.andPublishTimeIsNotNull();

        Long resultData = articleService.getArticleCountsByExample(example);
        return ResultUtils.success(resultData);
    }

    @GetMapping("articles/publish_time/{publishTime}")
    public Result getArticlesByPublishTime(@PathVariable Date publishTime) {
        // set example, search articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andPublishTimeEqualTo(publishTime);
        criteria.andPublishTimeIsNotNull();

        List<ArticleWithBLOBs> resultData = articleService.getArticleByExample(example);

        if (resultData.size() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by publishTime=%tc: No article found.", publishTime));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("articles/publish_time/paged/{publishTime}/{startPage}/{pageSize}")
    public Result getArticlesByPublishTimePaged(
            @PathVariable Date publishTime, @PathVariable int startPage, @PathVariable int pageSize) {
        // set example, page articles by publish time.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andPublishTimeEqualTo(publishTime);
        criteria.andPublishTimeIsNotNull();

        PageInfo<Article> resultData = articleService.getArticlesByExamplePaged(example, startPage, pageSize);

        if (resultData.getTotal() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by publishTime=%tc paged: No article found.", publishTime));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("articles/publish_time/{startTime}/{endTime}")
    public Result getArticlesByPublishTimeRange(@PathVariable Date startTime, @PathVariable Date endTime) {
        // set example, search articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andPublishTimeBetween(startTime, endTime);
        criteria.andPublishTimeIsNotNull();

        List<ArticleWithBLOBs> resultData = articleService.getArticleByExample(example);

        if (resultData.size() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by publishTime range[%tc, %tc]: No article found.", startTime, endTime));
        else return ResultUtils.success(resultData);
    }

    @GetMapping("articles/publish_time/paged/{startTime}/{endTime}/{startPage}/{pageSize}")
    public Result getArticlesByPublishTimeRangePaged(
            @PathVariable Date startTime, @PathVariable Date endTime,
            @PathVariable int startPage, @PathVariable int pageSize) {
        // set example, search articles by title.
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andPublishTimeBetween(startTime, endTime);
        criteria.andPublishTimeIsNotNull();

        PageInfo<Article> resultData = articleService.getArticlesByExamplePaged(example, startPage, pageSize);

        if (resultData.getTotal() == 0)
            return ResultUtils.error("4001", StatusCode.STATUS_CODE_4001 + String.format(" Get articles by publishTime range[%tc, %tc] paged: No article found.", startTime, endTime));
        else return ResultUtils.success(resultData);
    }

    @PostMapping("article")
    public Result insertArticle(@RequestBody ArticleWithBLOBs article) {
        int affectedRows = articleService.insertArticle(article);

        if (affectedRows == 0)
            return ResultUtils.error("4002", StatusCode.STATUS_CODE_4002 + " Insert article failed.");
        else {
            int resultData = article.getId();
            return ResultUtils.success(resultData);// return id of the record created.
        }
    }

    @DeleteMapping("article/{id}")
    public Result deleteArticle(@PathVariable int id) {
        int affectedRows = articleService.deleteArticleById(id);

        if (affectedRows == 0)
            return ResultUtils.error("4003", StatusCode.STATUS_CODE_4003 + String.format(" Delete article by id=%d: Delete failed.", id));
        else return ResultUtils.success("");
    }

    @PutMapping("article")
    public Result updateArticle(@RequestBody ArticleWithBLOBs article) {
        int affectedRows = articleService.updateById(article);

        if (affectedRows == 0)
            return ResultUtils.error("4004", StatusCode.STATUS_CODE_4004 + " Update article failed.");
        else return ResultUtils.success("");
    }
}
