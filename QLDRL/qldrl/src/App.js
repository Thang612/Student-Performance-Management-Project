import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Outlet, Route, Routes } from "react-router-dom"
import './App.css';
import Header from "./Components/Commons/Header";
import Home from "./Components/Home/Home";
import Footer from "./Components/Commons/Footer";
import Login from "./Components/User/Login";
import NewsDetail from './Components/News/NewsDetail';
import NotFound from './Components/Commons/NotFound';
import RegistedEvent from './Components/Event/RegistedEvent';
import RegisterEvent from './Components/Event/RegisterEvent';
import Results from './Components/Results/Results';
import ChatApp from './Components/Chat/ChatApp';
import { GoogleOAuthProvider } from '@react-oauth/google';
import { createContext, useReducer } from 'react';
import UserReducer from './reducers/UserReducer';
import Register from './Components/User/Register';
import LoginNormal from './Components/User/LoginNormal';
import UserDetail from './Components/User/UserDetail';

export const UserContext = createContext();

function App() {

  const [user, dispatch] = useReducer(UserReducer)

  return (
    <UserContext.Provider value ={[user, dispatch]}>
    <GoogleOAuthProvider clientId="558699822073-bo52ighlvksekp2lj1q2b4f8stvi9a4r.apps.googleusercontent.com">
    <BrowserRouter>
      <Header/>
      <Routes>
        <Route path="/login" element={<Login/>}/>
        <Route path="/" element={<Home/>}/>
        <Route path="/baiviet/:id" element={<NewsDetail/>}/> 
        <Route path="/hoatdong/*" element={<Outlet/>}>
          <Route path="dathamgia" element={<RegistedEvent/>}/>
          <Route path="dangky" element={<RegisterEvent/>}/>
          <Route path="ketqua" element={<Results/>}/>
        </Route>
        <Route path="/diendan/" element={<ChatApp/>}/> 
        <Route path="/dangky/" element={<Register/>}/> 
        <Route path="/dangnhap/" element={<LoginNormal/>}/>
        <Route path="/chitietsinhvien/" element={<UserDetail/>}/>
        <Route path="*" element={<NotFound/>}/> 
      </Routes>
      <Footer/>
    </BrowserRouter>
    </GoogleOAuthProvider>
    </UserContext.Provider>
  );
}

export default App;
