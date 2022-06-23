import axios from 'axios'

const instance = axios.create({
    timeout: 300000,
})

instance.interceptors.request.use(
    (config) => {
        config.headers['BEARER'] = this.$store.state.token
        config.headers['account'] = this.$store.state.account
        return config
    },
    (error) => {
        return Promise.reject(error)
    }
)

instance.interceptors.response.use(
    (response) => {
        let tokenTmp = response.headers['BEARER']
        if (tokenTmp !== this.$store.state.token) {
            this.$store.commit('setToken', tokenTmp)
        }

        return response
    },
    (error) => {
        return Promise.reject(error)
    }
)

const api = {
    get(url, data) {
        return instance.get(url, data)
    },
    post(url, data) {
        return instance.post(url, data)
    }
}

export {api}