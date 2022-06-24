import {api} from "../service/service.js"

/** APIs for article resources HERE. */

const getArticleById = (id) => {
    return api.get('article', {id: id})
}

const countArticle = () => {
    return api.get('article/counts')
}

const getArticlesPaged = (startPage, pageSize) => {
    return api.get('articles/paged', {startPage: startPage, pageSize: pageSize})
}

const countArticleByTitle = (title) => {
    return api.get('article/counts/title', {title: title})
}

const countArticleByFuzzyTitle = (title) => {
    return api.get('article/counts/title/fuzzy', {title: title})
}

const getArticlesByTitlePaged = (title, startPage, pageSize) => {
    return api.get('articles/title/paged', {title: title, startPage: startPage, pageSize: pageSize})
}

const getArticleByFuzzyTitlePaged = (title, startPage, pageSize) => {
    return api.get('articles/title/fuzzy/paged', {title: title, startPage: startPage, pageSize: pageSize})
}

const countArticleByTag = (tag) => {
    return api.get('article/counts/tag', {tag: tag})
}

const getArticlesByTagPaged = (tag, startPage, pageSize) => {
    return api.get('articles/tag/paged', {tag: tag, startPage: startPage, pageSize: pageSize})
}

const countArticleByUserId = (userId) => {
    return api.get('article/counts/user_id', {userId: userId})
}

const getArticlesByUserIdPaged = (userId, startPage, pageSize) => {
    return api.get('articles/user_id/paged', {userId: userId, startPage: startPage, pageSize: pageSize})
}

const countArticleByPublishTime = (publishTime) => {
    return api.get('article/counts/publish_time', {publishTime: publishTime})
}

const countArticleByPublishTimeRange = (startTime, endTime) => {
    return api.get('article/counts/publish_time/range', {startTime: startTime, endTime: endTime})
}

const getArticlesByPublishTimePaged = (publishTime, startPage, pageSize) => {
    return api.get('articles/publish_time/paged', {publishTime: publishTime, startPage: startPage, pageSize: pageSize})
}

const getArticlesByPublishTimeRangePaged = (startTime, endTime, startPage, pageSize) => {
    return api.get('articles/publish_time/range/paged', {
        startTime: startTime,
        endTime: endTime,
        startPage: startPage,
        pageSize: pageSize
    })
}

const insertArticle = (articleObj) => {
    return api.post('article', articleObj)
}

const deleteArticle = (id) => {
    return api.delete('article', id)
}

const updateArticle = (articleObj) => {
    return api.put('article', articleObj)
}

/** Export all functions. */
const article = {
    getArticleById,
    countArticle,
    getArticlesPaged,
    countArticleByTitle,
    countArticleByFuzzyTitle,
    getArticlesByTitlePaged,
    getArticleByFuzzyTitlePaged,
    countArticleByTag,
    getArticlesByTagPaged,
    countArticleByUserId,
    getArticlesByUserIdPaged,
    countArticleByPublishTime,
    countArticleByPublishTimeRange,
    getArticlesByPublishTimePaged,
    getArticlesByPublishTimeRangePaged,
    insertArticle,
    deleteArticle,
    updateArticle
}

export default article
