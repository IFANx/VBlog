import {api} from "../service/service.js"

/** APIs for like relation HERE. */

const countLikeByUserId = (userId) => {
    return api.get('like/counts/', {userId: userId})
}

const getLikeListByUserId = (userId) => {
    return api.get('like/what', {userId: userId})
}

const getLikerListByArticleId = (articleId) => {
    return api.get('like/by-whom', {articleId: articleId})
}

/**
 * @param likeKey has 2 attributes, userId and articleId.
 * */
const addLikeRelation = (likeKey) => {
    return api.post('like', likeKey)
}

const deleteLikeRelation = (userId, articleId) => {
    return api.delete('like/', {userId: userId, articleId: articleId})
}

/** Export all functions. */
const like = {
    countLikeByUserId,
    getLikeListByUserId,
    getLikerListByArticleId,
    addLikeRelation,
    deleteLikeRelation
}

export default like
