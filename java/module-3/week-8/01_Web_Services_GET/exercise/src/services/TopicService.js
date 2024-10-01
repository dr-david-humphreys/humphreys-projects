import axios from "axios";

const baseUrl = 'http://localhost:3000/topics';

export default {
    list() {
        return axios.get(baseUrl);
    },
    get(id) {
        return axios.get(`${baseUrl}/${id}`);
    }
};