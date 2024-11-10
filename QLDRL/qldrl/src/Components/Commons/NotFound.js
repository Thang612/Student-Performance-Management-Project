import React from 'react';
import { Link } from 'react-router-dom';
import { Container, Row } from 'react-bootstrap';

const NotFound = () => {
    return (
        <Container>
            <Row className="justify-content-center">
                <div className="col-md-6">
                    <h1>404 - Không tìm thấy trang</h1>
                    <p>Xin lỗi, trang bạn đang tìm kiếm không tồn tại.</p>
                    <Link to="/">Quay lại trang chính</Link>
                </div>
            </Row>
        </Container>
    );
};

export default NotFound;
