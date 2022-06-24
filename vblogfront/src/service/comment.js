import {api} from "../service/service.js"

/** APIs for user HERE. */

const getCommentByAriticle = (articleid,  startPage, pageSize) => {
  return api.get('comment/list/paged', {articleid:articleid,  startPage:startPage, pageSize:pageSize})
}




/** Export all functions. */
const comment = {
  getCommentByAriticle,
}

export default comment
