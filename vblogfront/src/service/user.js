import {api} from "../service/service.js"

/** APIs for user HERE. */

const login = (account, password) => {
    return api.post('user/login', {account: account, password: password})
}

const register = (account, password) => {
    return api.post('user/register', {account: account, password: password})
}


/** Export all functions. */
const user = {
    login,
    register
}

export default user
