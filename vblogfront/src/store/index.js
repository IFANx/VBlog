import { createStore } from 'vuex'

export default createStore({
  state: {
    onlineState: false,
    account: null,
    token: null
  },
  getters: {
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
    }
  },
  actions: {
  },
  modules: {
  }
})
