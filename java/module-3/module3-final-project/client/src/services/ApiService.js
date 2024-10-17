import axios from "axios";

const http = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API || "http://localhost:9000",
});

export default {
    addPracticeSession(sessionData) {
        return http.post('/practice-session', sessionData);
    },

    getPracticeSessions(id) {
        return http.get(`/practice-session/`);
    }
};