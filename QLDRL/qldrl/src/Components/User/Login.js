import React, { useContext, useState } from 'react';
import { GoogleLogin } from '@react-oauth/google';
import { jwtDecode } from 'jwt-decode';
import { UserContext } from '../../App';
import APIs, { endpoints } from '../../configs/APIs';
import { Link } from 'react-router-dom';

const Login = () => {
  const [user, dispatch] = useContext(UserContext)

  const responseGoogle = async (response) => {
    try {
      const decoded = jwtDecode(response.credential);
      try {
        let url = `${endpoints['getUser']}${decoded.email}`;
        let res = await APIs.get(url);
        dispatch({
          "type": "login",
          "payload":{
            "email": res.data.email,
            "id": res.data.id,
            "ho": res.data.ho,
            "ten": res.data.ten,
            'namSinh': res.data.namSinh,
            'avatar': res.data.avatar
          }
      })
      console.log(res.data)
      } catch (error) {
        console.error('Error fetching user:', error);
      }
    } catch (error) {
      console.error("Error decoding JWT token or fetching user data from backend:", error);
    }
  };

  return (
    <div>
      {user ? (
        <div>
          <Link to="/chitietsinhvien"><p>Xin chào, {user.ho + " " + user.ten}!</p></Link>
          {/* Hiển thị thêm thông tin người dùng nếu cần */}
        </div>
      ) : (
        <GoogleLogin
          onSuccess={responseGoogle}
          onError={(error) => console.log('Login Failed:', error)}
        />
      )}
    </div>
  );
};

export default Login;
