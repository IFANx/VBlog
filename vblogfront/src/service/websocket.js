export default {
    ws: WebSocket,
    createWebSocket(account) {
        this.ws = new WebSocket('ws://localhost:8989/ws/notification/' + account)
    }
}