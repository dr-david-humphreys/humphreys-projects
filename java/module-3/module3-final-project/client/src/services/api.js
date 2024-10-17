import axios from "axios";

const API_BASE_URL = 'http://localhost:9000/';

const api = axios.create({
    baseURL: API_BASE_URL,
});

export const fetchPracticeSessions = () => {
    alert(localStorage.getItem('token'));
    return axios.get('/practice-session');
};

export const addPracticeSession = (sessionData) => {
    alert(sessionData.practiceSessionNumber);
    return axios.post('/practice-session', sessionData);
};