import { useEffect, useRef, useState } from "react";
import { Button, Container, Form, Alert } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import APIs, { endpoints } from "../../configs/APIs";
import MySpinner from "../Commons/MySpinner";

const Register = () => {
    const fields = [{
        label: "Họ và tên lót",
        type: "text",
        field: "ho"     
    }, {
        label: "Tên người dùng",
        type: "text",
        field: "ten"
    }, {
        label: "Ngày sinh",
        type: "date",
        field: "namSinh"
    }, {
        label: "Email",
        type: "email",
        field: "email"
    }, {
        label: "Tên đăng nhập",
        type: "text",
        field: "username"
    }, {
        label: "Mật khẩu",
        type: "password",
        field: "password"
    }, {
        label: "Xác nhận mật khẩu",
        type: "password",
        field: "confirm"
    }];

    const [user, setUser] = useState({});
    const [errors, setErrors] = useState({});
    const avatar = useRef();
    const nav = useNavigate();
    const [lop, setLop] = useState([]);
    const [loading, setLoading] = useState(false);
    const [namhoc, setNamHoc] = useState([]);
    const [avatarError, setAvatarError] = useState(null);

    const loadLop = async () => {
        setLoading(true);
        try {
            let url = `${endpoints['dslop']}`;
            let res = await APIs.get(url);
            setLop(res.data);
        } catch (error) {
            console.error("Error fetching data:", error);
        } finally {
            setLoading(false);
        }
    }

    const loadNamHoc = async () => {
        setLoading(true);
        try {
            let url = `${endpoints['dsnamhoc']}`;
            let res = await APIs.get(url);
            setNamHoc(res.data);
            console.log(res.data);
        } catch (error) {
            console.error("Error fetching data:", error);
        } finally {
            setLoading(false);
        }
    }

    const change = (e, field) => {
        setUser(current => ({
            ...current,
            [field]: e.target.value
        }));
        setErrors(current => ({
            ...current,
            [field]: ''
        }));
    }

    const validateForm = () => {
        let valid = true;
        let newErrors = {};

        fields.forEach(f => {
            if (!user[f.field]) {
                valid = false;
                newErrors[f.field] = `${f.label} không được để trống`;
            }
        });

        if (!user.gioiTinh) {
            valid = false;
            newErrors['gioiTinh'] = 'Giới tính không được để trống';
        }

        if (!user.namId) {
            valid = false;
            newErrors['namId'] = 'Năm học không được để trống';
        }

        if (!user.lopId) {
            valid = false;
            newErrors['lopId'] = 'Lớp không được để trống';
        }

        setErrors(newErrors);
        return valid;
    }

    const register = async (e) => {

        e.preventDefault();
        setLoading(true);
        if (!validateForm()) {
            const firstErrorField = Object.keys(errors).find(key => errors[key]);
            if (firstErrorField) {
                document.getElementById(firstErrorField).focus();
            }
            return;
        }

        let form = new FormData();
        for (let key in user)
            if (key !== 'confirm')
                form.append(key, user[key]);

        if (avatar.current.files.length > 0) {
            form.append('file', avatar.current.files[0]);
        }

        try {
            let res = await APIs.post(endpoints['register'], form, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            });

            if (res.status === 201) {
                alert("Đăng ký thông tin thành công");
                nav("/"); // Đảm bảo rằng nav function được định nghĩa và chính xác
            } else {
                console.error('Unexpected response status:', res.status);
            }
        } catch (ex) {
            console.error('Exception occurred:', ex);
        }finally{
            setLoading(false)
        }
    }

    useEffect(() => {
        loadLop();
        loadNamHoc();
    }, []);

    return (
        
        <Container>
            <h1 className="text-center text-info mt-1">ĐĂNG KÝ NGƯỜI DÙNG</h1>
            {loading ? (
            <MySpinner />
        ):(
            <Form onSubmit={register}>
                {fields.map(f => (
                    <Form.Group key={f.field} className="mb-3" controlId={f.field}>
                        <Form.Label>{f.label}</Form.Label>
                        <Form.Control
                            onChange={e => change(e, f.field)}
                            value={user[f.field] || ''}
                            type={f.type}
                            placeholder={f.label}
                            isInvalid={!!errors[f.field]}
                        />
                        <Form.Control.Feedback type="invalid">
                            {errors[f.field]}
                        </Form.Control.Feedback>
                    </Form.Group>
                ))}
                <Form.Group className="mb-3" controlId="gioiTinh">
                    <Form.Label>Giới tính</Form.Label>
                    <Form.Control as="select" onChange={e => change(e, 'gioiTinh')} value={user.gioiTinh || ''} isInvalid={!!errors.gioiTinh}>
                        <option value="">Chọn Giới tính</option>
                        <option key="1" value="1">Nam</option>
                        <option key="0" value="0">Nữ</option>
                    </Form.Control>
                    <Form.Control.Feedback type="invalid">
                        {errors.gioiTinh}
                    </Form.Control.Feedback>
                </Form.Group>
                {loading && <MySpinner />}
                <Form.Group className="mb-3" controlId="namId">
                    <Form.Label>Năm học</Form.Label>
                    <Form.Control as="select" onChange={e => change(e, 'namId')} value={user.namId || ''} isInvalid={!!errors.namId}>
                        <option value="">Chọn năm học</option>
                        {namhoc.map(nh => (
                            <option key={nh.id} value={nh.id}>{nh.namHoc}</option>
                        ))}
                    </Form.Control>
                    <Form.Control.Feedback type="invalid">
                        {errors.namId}
                    </Form.Control.Feedback>
                </Form.Group>
                <Form.Group className="mb-3" controlId="lopId">
                    <Form.Label>Lớp</Form.Label>
                    <Form.Control as="select" onChange={e => change(e, 'lopId')} value={user.lopId || ''} isInvalid={!!errors.lopId}>
                        <option value="">Chọn lớp</option>
                        {lop.map(cls => (
                            <option key={cls.id} value={cls.id}>{cls.ten}</option>
                        ))}
                    </Form.Control>
                    <Form.Control.Feedback type="invalid">
                        {errors.lopId}
                    </Form.Control.Feedback>
                </Form.Group>
                <Form.Group className="mb-3" controlId="avatar">
                    <Form.Label>Ảnh đại diện</Form.Label>
                    <Form.Control type="file" accept=".png,.jpg" ref={avatar} />
                    {avatarError && <Alert variant="danger">{avatarError}</Alert>}
                </Form.Group>
                <Form.Group className="mb-3">
                    <Button type="submit" variant="primary">Đăng ký</Button>
                </Form.Group>
            </Form>
        )}
        </Container>
    
    );
}

export default Register;
