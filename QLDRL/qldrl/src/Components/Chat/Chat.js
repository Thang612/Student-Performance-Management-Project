import { useState, useEffect, useRef } from "react";
import { database, ref, push, onValue } from "./firebase";

function Chat({ name }) {
  const [inpMessage, setIptMessage] = useState("");
  const [messages, setMessages] = useState([]);
  const input = useRef();
  useEffect(() => {
    onValue(ref(database, "message"), (data) => {
      let getMsg = [];
      data.forEach((d) => {
        getMsg.push(d.val());
      });
      setMessages(getMsg);
    });
  }, []);
  const handleSendMessage = () => {
    push(ref(database, "message"), {
      name: name,
      message: inpMessage,
      time: new Date().toLocaleString()
    });
    setIptMessage("");

  };
  return (
    <div style={{ height: "70vh", overflow: "auto", display: "flex", flexDirection: "column", alignItems: "center" }}>
      <h1>xin chào {name}</h1>
      <ul style={{ height: "calc(80vh - 200px)", overflowY: "auto", listStyle: "none", padding: 0 }}>
        {messages.map((msg, index) => {
          return (
            <li key={index} style={{ marginBottom: "10px", padding: "10px 30px", backgroundColor: "#f3f3f3", borderRadius: "10px" }}>
              <span style={{ fontWeight: "bold" }}>{msg.name}: </span>
              <span>{msg.message}</span>
              <span><small> - {msg.time}</small></span>
            </li>
          );
        })}
      </ul>
      <div style={{ width: "100%" }}>
        <input 
          type="text"
          value={inpMessage}
          onChange={(e) => {
            setIptMessage(e.target.value);
          }}
          ref={input}
          style={{ width: "calc(100% - 110px)", height:"40px", marginRight: "10px" }}
        />
        <button className="btn  btn-primary" onClick={handleSendMessage} style={{ width: "100px",  height:"40px" }}><i class="fa-solid fa-paper-plane"></i></button>
      </div>
    </div>
  );
}

export default Chat;
