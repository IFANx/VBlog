import axios from 'axios'
import store from '@/store/index'
import qs from 'qs'

const instance = axios.create({
    timeout: 300000,
    baseURL: 'http://localhost:8989'
})

instance.interceptors.request.use(
    (config) => {
        config.headers['BEARER'] = sessionStorage.getItem('Token')
        config.headers['account'] = sessionStorage.getItem('Account')
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
            sessionStorage.setItem('Account', tokenTmp)
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
    },
    put(url, data) {
        return instance.put(url, data)
    },
    delete(url, data) {
        return instance.delete(url, qs.stringify(data))
    }
}

export {api}
