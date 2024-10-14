import axios from 'axios';

const API_BASE_URL = 'http://localhost:9000/';

class AuthService {
  register(user) {
    return axios.post(`${API_BASE_URL}/register`, {
      username: user.username,
      name: user.name,
      password: user.password,
      address: user.address,
      city: user.city,
      stateCode: user.stateCode,
      zip: user.zip,
      role: user.role
    });
  }
}

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  }

}
