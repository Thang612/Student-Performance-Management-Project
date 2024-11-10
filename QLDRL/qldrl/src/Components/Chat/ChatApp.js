import { useState } from "react";
import Login from '../User/Login';
import Chat from "./Chat";
import { Container } from "react-bootstrap";
import { useContext } from "react";
import { UserContext } from "../../App";



function ChatApp() {
  const [showChat, setShowChat] = useState(false);
  const [name, setName] = useState("");
  const [user, dispatch] = useContext(UserContext)
  
  return (
    <Container style={{position: "relative"}}>
    <div className="App">
      {!user && <Login/>}
      {user && <Chat name={user.ten} />}
    </div>
    </Container>
  );
}

export default ChatApp;
