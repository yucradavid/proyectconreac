import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://localhost:82', // Cambia esto a la URL de tu gateway
});

instance.interceptors.request.use((config) => {
    const token = localStorage.getItem('token');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

export default instance;
