import {api} from "../service/service.js"

/** APIs for comment HERE. */

const getCommentByArticlePaged = (articleId, startPage, pageSize) => {
    return api.get('comment/byArticleId/paged', {articleId: articleId, startPage: startPage, pageSize: pageSize})
}

const addComment = (commentObj) => {
    return api.post('comment', commentObj)
}

const deleteComment = (commentId) => {
    return api.delete('comment', commentId)
}

const updateComment = (commentObj) => {
    return api.put('comment', commentObj)
}


/** Export all functions. */
const comment = {
    getCommentByArticlePaged,
    addComment,
    deleteComment,
    updateComment
}

export default comment
