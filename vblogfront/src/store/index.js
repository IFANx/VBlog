import { createStore } from 'vuex'

export default createStore({
  state: {
    onlineState: false,
    account: null,
    token: null,
    userid: null
  },
  getters: {
    getOnlineState(state,) {
      return state.onlineState
    },
    getAccount(state) {
      return state.account
    },
    getToken(state) {
      return state.token
    },
    getUserId(state) {
      return state.userid
    }
  },
  mutations: {
    setOnlineState(onlineState, result) {
      this.state.onlineState = result
    },
    setAccount(account, result) {
      this.state.account = result
    },
    setToken(token, result) {
      this.state.token = result
    },
    setUserId(id, result) {
      this.state.userid = result
    }
  },
  actions: {
  },
  modules: {
  }
})
