package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.entity.domian.ArticleExample;
import com.example.vblogservice.mapper.ArticleMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    final
    ArticleMapper articleMapper;

    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Transactional
    public Article getArticleById(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    /**
     * Count how many articles that match the example condition.
     */
    @Transactional
    public long getArticleCountsByExample(ArticleExample example) {
        return articleMapper.countByExample(example);
    }


    /**
     * Get all articles that match the example condition.
     */
    @Transactional
    public List<Article> getArticleByExample(ArticleExample example) {
        return articleMapper.selectByExampleWithBLOBs(example);
    }


    /**
     * Get all articles that match the example condition and in specified page.
     */
    @Transactional
    public PageInfo<Article> getArticlesByExamplePaged(ArticleExample example, int startPage, int pageSize) {
        Page<Article> page = PageHelper
                .startPage(startPage, pageSize)
                .doSelectPage(
                        () -> articleMapper.selectByExampleWithBLOBs(example)
                );
        return new PageInfo<>(page);
    }

    @Transactional
    public int insertArticle(Article article) {
        articleMapper.insertSelective(article);
        return article.getId();
    }

    @Transactional
    public int deleteArticleById(int id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public int updateById(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }
}
