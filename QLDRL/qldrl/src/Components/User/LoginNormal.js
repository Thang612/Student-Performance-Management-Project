import { useContext, useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import cookie from "react-cookies";
import { useNavigate } from "react-router-dom";
import APIs, { authApi, endpoints } from "../../configs/APIs";
import { UserContext } from "../../App";

const LoginNormal = () => {
    const fields = [{
        label: "Tên đăng nhập",
        type: "text",
        field: "username"
    }, {
        label: "Mật khẩu",
        type: "password",
        field: "password"
    }];
    const [users, setUser] = useState({});
    const [user, dispatch] = useContext(UserContext);
    const nav = useNavigate();

    const change = (e, field) => {
        setUser(current => {
            return {...current, [field]: e.target.value}
        })
    }

    const login = async (e) => {
        e.preventDefault();
        try {
            let res = await APIs.post(endpoints['login'], {...users});
            console.info(res.data);
            cookie.save("token", res.data);

            let u = await authApi().get(endpoints['current-user']);
            cookie.save('user', u.data);
            
            dispatch({
                "type": "login",
                "payload": u.data
            });
            nav("/");
        } catch (ex) {
            console.error(ex);
        }
    }

    return (
        <Container>
            <h1 className="text-center text-info mt-1">ĐĂNG NHẬP NGƯỜI DÙNG</h1>
            <Form onSubmit={login}>
                {fields.map(f => <Form.Group key={f.field} className="mb-3" controlId={f.field}>
                    <Form.Label>{f.label}</Form.Label>
                    <Form.Control onChange={e => change(e, f.field)} value={users[f.field]} type={f.type} placeholder={f.label} />
                </Form.Group>)}
                <Form.Group className="mb-3">
                    <Button type="submit" value="primary">Đăng nhập</Button>
                </Form.Group>
            </Form>
        </Container>
    );
}

export default LoginNormal;