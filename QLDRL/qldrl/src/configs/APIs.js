import axios from "axios";
import cookie from "react-cookies";

const BASE_URL = 'http://localhost:8080/QuanLyDiemRenLuyen/';

export const endpoints = {
    'baiviets': '/api/baiviets/',
    'binhluans': '/api/binhluans/',
    'binhluancon': '/api/binhLuanCon/',
    'hockinamhoc': '/api/hockinamhoc/',
    'hoatdong': '/api/hoatdongs/',
    'ketqua': '/api/ketquarenluyen/',
    'baothieu': '/api/baothieu/',
    'getUser': '/api/loginSinhVien/',
    'register': '/api/nguoidung/',
    'dslop': '/api/dslop/',
    'dsnamhoc': '/api/dsNamhoc/',
    'login': '/api/login',
    'current-user': '/api/current-user'
}

export const authApi = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': `${cookie.load('token')}`
        }
    });
}

export default axios.create({
    baseURL: BASE_URL
});


