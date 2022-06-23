package com.example.vblogservice.service;

import com.example.vblogservice.entity.domian.*;
import com.example.vblogservice.mapper.ArticleMapper;
import com.example.vblogservice.mapper.LikeMapper;
import com.example.vblogservice.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikeService {
    final
    LikeMapper likeMapper;

    final
    ArticleMapper articleMapper;

    final
    UserMapper userMapper;

    public LikeService(LikeMapper likeMapper, ArticleMapper articleMapper, UserMapper userMapper) {
        this.likeMapper = likeMapper;
        this.articleMapper = articleMapper;
        this.userMapper = userMapper;
    }

    /**
     * @param userId The id of whose like you want to count.
     * @return How many articles did the user like.
     */
    @Transactional
    public long countLikeByUserId(int userId) {
        // set example to match userId.
        LikeExample likeExample = new LikeExample();
        LikeExample.Criteria criteria = likeExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        return likeMapper.countByExample(likeExample);
    }

    /**
     * @param userId The id of whose like list you want to query.
     * @return Target user's like article list.
     */
    @Transactional
    public List<Article> getLikeListByUserId(int userId) {

        List<Article> resultList = new ArrayList<>();

        // set example to match userId.
        LikeExample likeExample = new LikeExample();
        LikeExample.Criteria criteria = likeExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        List<LikeKey> likeKeys = likeMapper.selectByExample(likeExample);

        // call article mapper to fetch all articles that matched, and add them into the result list.
        for (LikeKey key : likeKeys) {
            ArticleWithBLOBs matchedArticle = articleMapper.selectByPrimaryKey(key.getArticleId());
            resultList.add(matchedArticle);
        }

        return resultList;
    }

    /**
     * @param articleId The id of the article that you want to query.
     * @return Target article's liker list.
     */
    @Transactional
    public List<User> getUserListByArticleId(int articleId) {

        List<User> resultList = new ArrayList<>();

        // set example to match articleID
        LikeExample likeExample = new LikeExample();
        LikeExample.Criteria criteria = likeExample.createCriteria();
        criteria.andArticleIdEqualTo(articleId);

        List<LikeKey> likeKeys = likeMapper.selectByExample(likeExample);

        // call user mapper to fetch all user that matched, and add them into the result list.
        for (LikeKey key : likeKeys) {
            UserWithBLOBs matchedUser = userMapper.selectByPrimaryKey(key.getUserId());
            resultList.add(matchedUser);
        }

        return resultList;
    }

    /**
     * @param likeKey contains 2 attribute, userId and articleID, specifies the like relation to add.
     * @return affected rows, 0 means no effect, aka failed.
     */
    @Transactional
    public int addLikeRelation(LikeKey likeKey) {
        return likeMapper.insert(likeKey);
    }

    /**
     * @param likeKey contains 2 attribute, userId and articleID, specifies the like relation to delete.
     * @return affected rows, 0 means no effect, aka failed.
     */
    @Transactional
    public int deleteLikeRelation(LikeKey likeKey) {
        return likeMapper.deleteByPrimaryKey(likeKey);
    }
}
