import axios from "axios";

const http = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API || "http://localhost:9000",
});

export default {
    addPracticeSession(sessionData) {
        return http.post('/practice-session', sessionData);
    },

    getPracticeSessions() {
        return http.get('/practice-session');
    },

    updatePracticeSession(id, sessionData) {
        return http.put(`/practice-session/${id}`, sessionData);
    },

    deletePracticeSession(id) {
        return http.delete(`/practice-session/${id}`);
    },

    addGoal(goalData) {
        return http.post('/goal', goalData);
    },

    getGoals() {
        return http.get('/goal');
    },

    updateGoal(id, goalData) {
        return http.put(`/goal/${id}`, goalData);
    },

    deleteGoal(id) {
        return http.delete(`/goal/${id}`);
    }
};