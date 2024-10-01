import axios from "axios";

const baseUrl = 'http://localhost:3000/messages';

export default {
    getMessageById(messageId) {
        return axios.get(`${baseUrl}/${messageId}`);
    }
}