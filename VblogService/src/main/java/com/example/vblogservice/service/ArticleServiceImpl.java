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
public class ArticleServiceImpl implements ArticleService {

    final
    ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    @Transactional
    public Article getArticleById(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    /**
     * Count how many articles that match the example condition.
     * */
    @Override
    @Transactional
    public long getArticleCountsByExample(ArticleExample example) {
        return articleMapper.countByExample(example);
    }


    /**
     * Get all articles that match the example condition.
     * */
    @Override
    @Transactional
    public List<Article> getArticleByExample(ArticleExample example) {
        return articleMapper.selectByExampleWithBLOBs(example);
    }


    /**
     * Get all articles that match the example condition and in specified page.
     * */
    @Override
    @Transactional
    public PageInfo<Article> getArticlesByExamplePaged(ArticleExample example, int startPage, int pageSize) {
        Page<Article> page = PageHelper
                .startPage(startPage, pageSize)
                .doSelectPage(
                        () -> articleMapper.selectByExampleWithBLOBs(example)
                );
        return new PageInfo<>(page);
    }

    @Override
    @Transactional
    public int insertArticle(Article article) {
        articleMapper.insertSelective(article);
        return article.getId();
    }

    @Override
    @Transactional
    public int deleteArticleById(int id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateById(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }
}
