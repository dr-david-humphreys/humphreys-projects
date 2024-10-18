import axios from "axios";

/*const http = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API || "http://localhost:9000",
});*/

export default {
    addPracticeSession(sessionData) {
        return axios.post('/practice-session', sessionData);
    },

    getPracticeSessions() {
        return axios.get('/practice-session');
    },

    updatePracticeSession(id, sessionData) {
        return axios.put(`/practice-session/${id}`, sessionData);
    },

    deletePracticeSession(id) {
        return axios.delete(`/practice-session/${id}`);
    },

    addGoal(goalData) {
        return axios.post('/goal', goalData);
    },

    getGoals() {
        return axios.get('/goal');
    },

    updateGoal(id, goalData) {
        return axios.put(`/goal/${id}`, goalData);
    },

    deleteGoal(id) {
        return axios.delete(`/goal/${id}`);
    }
};