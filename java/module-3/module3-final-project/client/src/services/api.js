import axios from "axios";

const API_BASE_URL = 'http://localhost:9000/api';

const api = axios.create({
    baseURL: API_BASE_URL,
});

export const fetchPracticeSessions = () => {
    return api.get('/practice-sessions');
};

export const addPracticeSession = (sessionData) => {
    return api.post('/practice-sessions', sessionData);
};