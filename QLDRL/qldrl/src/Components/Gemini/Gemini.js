import React, { useState } from "react";
import axios from "axios";
import {
    MainContainer,
    ChatContainer,
    MessageList,
    MessageInput,
    TypingIndicator,
    Message
} from '@chatscope/chat-ui-kit-react';
import '@chatscope/chat-ui-kit-styles/dist/default/styles.min.css';

const API_KEY = "AIzaSyC1A5E5gVpBmcOvF5ihLFU--hbrGp9BFfk";

function Gemini() {
    const [question, setQuestion] = useState("");
    const [messages, setMessages] = useState([]);
    const [isTyping, setIsTyping] = useState(false);
    const [isChatOpen, setIsChatOpen] = useState(false);

    async function handleSend(innerHtml) {
        const newMessage = innerHtml;
        setIsTyping(true);

        // Lưu câu hỏi vào state
        setMessages(prevMessages => [
            ...prevMessages,
            { message: newMessage, sender: "user", direction: "outgoing" }
        ]);

        try {
            const response = await axios({
                url: `https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=${API_KEY}`,
                method: "post",
                data: {
                    contents: [{ parts: [{ text: newMessage }] }],
                },
            });

            const answerText = response.data.candidates[0].content.parts[0].text;

            // Lưu câu trả lời vào state
            setMessages(prevMessages => [
                ...prevMessages,
                { message: answerText, sender: "ChatGPT", direction: "incoming" }
            ]);
        } catch (error) {
            console.log(error);
            setMessages(prevMessages => [
                ...prevMessages,
                { message: "Sorry - Something went wrong. Please try again!", sender: "ChatGPT", direction: "incoming" }
            ]);
        }

        setIsTyping(false);
    }

    function toggleChat() {
        setIsChatOpen(prev => !prev);
    }

    function handleClickOutside(event) {
        if (!event.target.closest('.chat-container') && !event.target.closest('.chat-toggle-button') && isChatOpen) {
            setIsChatOpen(false);
        }
    }

    React.useEffect(() => {
        document.addEventListener('click', handleClickOutside);
        return () => {
            document.removeEventListener('click', handleClickOutside);
        };
    }, [isChatOpen]);

    return (
        <div className="App">
            <button className="chat-toggle-button" onClick={toggleChat}>
                <i className="fa-brands fa-rocketchat"></i>
            </button>
            {isChatOpen && (
                <div className="chat-container">
                    <div style={{ position: "relative", height: "500px", width: "400px" }}>
                        <MainContainer>
                            <ChatContainer>
                                <MessageList
                                    scrollBehavior="smooth"
                                    typingIndicator={isTyping ? <TypingIndicator content="Gemini is typing" /> : null}
                                >   
                                    
                                    {messages.map((message, i) => (
                                        <Message key={i} model={{
                                            message: message.message,
                                            sentTime: "just now",
                                            sender: message.sender,
                                            direction: message.direction,
                                            position: "single"
                                        }} />
                                    ))}
                                </MessageList>
                                <MessageInput placeholder="Type message here" onSend={handleSend} />        
                            </ChatContainer>
                        </MainContainer>
                    </div>
                </div>
            )}
        </div>
    );
}

export default Gemini;
