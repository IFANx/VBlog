package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.Article;
import com.example.vblogservice.entity.domian.ArticleExample;
import com.example.vblogservice.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    final
    ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public Article getArticleById(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    /**
     * Return all article records that match the title.(ordered by time, from latest to earlier.)
     * */
    public List<Article> getArticleByTitle(String title) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo(title);
        criteria.andTitleIsNotNull();
        example.setOrderByClause("publish_time desc");

        return articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public int insertArticle(Article article) {
        articleMapper.insertSelective(article);
        return article.getId();
    }

    @Override
    public int deleteArticleById(int id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }
}
