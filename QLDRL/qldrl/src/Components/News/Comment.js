import React, { useContext, useEffect, useState } from 'react';
import { Container, Row, Col, Form, Button, Spinner } from 'react-bootstrap';
import APIs, { endpoints } from '../../configs/APIs';
import { UserContext } from '../../App';

const Comment = ({ props }) => {
    const [subComment, setSubComment] = useState(null);
    const [showReplyInput, setShowReplyInput] = useState(false);
    const [replyContent, setReplyContent] = useState('');
    const [isLoading, setIsLoading] = useState(false);
    const idComment = props.id;
    const [user, dispatch] = useContext(UserContext)


    useEffect(() => {
        console.log(props);
    }, [props]);

    const fetchComments = async () => {
        try {
            const url = `${endpoints['binhluancon']}${idComment}`;
            const res = await APIs.get(url);
            console.log(res.data);
            setSubComment(res.data);
        } catch (error) {
            console.error('Error fetching sub-comments:', error);
        }
    };

    const handleReply = async (e) => {
        setIsLoading(true);
        try {
            const newComment = {
                noiDung: replyContent,
                baiVietId: props.baiVietId.id,
                nguoiDungId: user.id,
                thoiGian: new Date(),
                commentId: idComment,
            };

            const response = await APIs.post(`${endpoints['binhluans']}`, newComment);

            console.log('Bình luận đã được tạo:', response.data);
            setReplyContent('');
            setShowReplyInput(false);
            fetchComments();
        } catch (error) {
            console.error('Error sending reply:', error);
        } finally {
            setIsLoading(false);
        }
    };

    return (
        <Container>
            <Row>
                <Col xs={1}>
                    <img
                        style={{ width: '50px', height: '50px' }}
                        src={props.nguoiDungId.avatar}
                        alt="Avatar"
                        className="avatar"
                    />
                </Col>
                <Col xs={11}>
                    <b>{`${props.nguoiDungId.ten} ${props.nguoiDungId.ho}`}</b>
                    <small>- {new Date(props.thoiGian).toLocaleDateString()}</small>
                    <p>{props.noiDung}</p>
                </Col>
                {subComment ? (
                    subComment.map((item, index) => (
                        <React.Fragment key={index}>
                            <Col xs={1}></Col>
                            <Col xs={11}>
                                <Comment props={item} />
                            </Col>
                        </React.Fragment>
                    ))
                ) : (
                    <p style={{ cursor: 'pointer' }} onClick={fetchComments}>
                        Xem tất cả
                    </p>
                )}
                <p style={{ cursor: 'pointer' }} onClick={() => setShowReplyInput(!showReplyInput)}>
                    Trả lời
                </p>
                {showReplyInput && (
                    <Form>
                        <Form.Group controlId="replyContent">
                            <Form.Control
                                type="text"
                                placeholder="Nhập trả lời..."
                                value={replyContent}
                                onChange={(e) => setReplyContent(e.target.value)}
                            />
                        </Form.Group>
                        <Button variant="primary" onClick={handleReply} disabled={isLoading}>
                            {isLoading ? <Spinner as="span" animation="border" size="sm" role="status" aria-hidden="true" /> : 'Gửi'}
                        </Button>
                    </Form>
                )}
                <hr />
            </Row>
        </Container>
    );
};

export default Comment;
