import axios from 'axios'
import store from '@/store/index'
import qs from 'qs'

const instance = axios.create({
    timeout: 300000,
    baseURL: 'http://localhost:8989'
})

instance.interceptors.request.use(
    (config) => {
        config.headers['BEARER'] = store.getters.getToken
        config.headers['account'] = store.getters.getAccount
        return config
    },
    (error) => {
        return Promise.reject(error)
    }
)

instance.interceptors.response.use(
    (response) => {
        let tokenTmp = response.headers['BEARER']
        if (tokenTmp !== store.getters.getToken) {
            store.commit('setToken', tokenTmp)
        }

        return response
    },
    (error) => {
        return Promise.reject(error)
    }
)

const api = {
    get(url, data) {
        return instance.get(url, qs.stringify(data))
    },
    post(url, data) {
        return instance.post(url, data)
    }
}

export {api}