import store from '@/store/index'

let timeout = 10 * 1000
let timeoutObj = null
let serverTimeoutObj = null
let timeoutnum = null
let lockReconnect = false
let ws = null

const createWebSocket = () => {
    ws = new WebSocket('ws://localhost:8989/ws/notification/' + store.getters.getAccount)
    ws.onopen = websocketOpen
    ws.onclose = websocketClose
    ws.onmessage = getMessage
}
const start = () => {
    console.log('start')
    timeoutObj && clearTimeout(timeoutObj)
    serverTimeoutObj && clearTimeout(serverTimeoutObj)
    timeoutObj = setTimeout(() => {
        if (ws && ws.readyState === 1) {
            ws.send('heartBath')
        } else {
            reconnect()
        }
        serverTimeoutObj = setTimeout(() => {
            ws.close();
        }, timeout)
    }, timeout)
}
const reset = () => {
    clearTimeout(timeoutObj)
    clearTimeout(serverTimeoutObj)
    start()
}
const reconnect = () => {
    if (lockReconnect) return
    lockReconnect = true;
    timeoutnum && clearTimeout(timeoutnum);
    timeoutnum = setTimeout(() => {
        createWebSocket();
        lockReconnect = false;
    }, 5000)
}
const websocketOpen = () => {
    start()
    console.log(ws.readyState)
}
const websocketClose = () => {
    ws.close()
    clearTimeout(timeoutObj)
    clearTimeout(serverTimeoutObj)
    console.log("WebSocket连接关闭")
}
const getMessage = (event) => {
    reset()
    let message = event.data
    console.log(message)
}

const websocket = {
    createWebSocket
}

export default websocket
