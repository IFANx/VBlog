import {api} from "../service/service.js"

/** APIs for article resources HERE. */

const getArticleById = (id) => {
    let result;
    api.get('article/', {'id': id}).then(r => {
        result = r
    })
    return result
}


/** Export all functions. */
const article = {
    getArticleById,
}

export default article
