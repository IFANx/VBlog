import {api} from "../service/service.js"

const parseTimeToDate = (datetime) => {
    let time = new Date(datetime)
    let year = time.getFullYear()
    let month = time.getMonth()
    let day = time.getDay()
    return year + '-' + month + '-' + day
}

const parseTimeToDateTime = (datetime) => {
    let time = new Date(datetime)
    let year = time.getFullYear()
    let month = time.getMonth()
    let day = time.getDay()
    let hour = time.getHours()
    let min = time.getMinutes()
    let sec = time.getSeconds()
    return year + '-' + month + '-' + day + ' ' + hour + ':' + min + ':' + sec
}

/** Export all functions. */
const utils = {
    parseTimeToDate,
    parseTimeToDateTime
}

export default utils
