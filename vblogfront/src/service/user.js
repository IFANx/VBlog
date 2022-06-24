import {api} from "../service/service.js"

/** APIs for user HERE. */

const login = (account, password) => {
    return api.post('user/login', {account: account, password: password})
}

const register = (account, password) => {
    return api.post('user/register', {account: account, password: password})
}
const update = (id, password,name,email,gender,birthday,description) => {
    return api.put('user/update', {id:id, password:password,name:name,email:email,gender:gender,birthday:birthday,description:description})
}

/** Export all functions. */
const user = {
    login,
    register,
    update
}

export default user
