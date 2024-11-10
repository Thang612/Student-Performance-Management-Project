import React, { useContext, useEffect, useReducer, useState } from 'react';
import { useParams } from 'react-router-dom';
import APIs, { endpoints } from '../../configs/APIs';
import { Container, Row, Col } from 'react-bootstrap';
import { FacebookShareButton, TwitterShareButton, FacebookIcon, TwitterIcon } from 'react-share';
import Comment from './Comment';
import { Form, Button } from 'react-bootstrap';
import MySpinner from '../Commons/MySpinner';
import UserReducer from '../../reducers/UserReducer';
import { UserContext } from '../../App';
import EventRegis from '../Event/EventRegis';

const NewsDetail = () => {
    const { id } = useParams();
    const [news, setNews] = useState(null);
    const [comments, setComments] = useState(null);
    const [newCommentContent, setNewCommentContent] = useState('');
    const [isCreatingComment, setIsCreatingComment] = useState(false);
    const [user, dispatch] = useContext(UserContext)

    const fetchNews = async () => {
        try {
            let url = `${endpoints['baiviets']}${id}`;
            let res = await APIs.get(url);
            setNews(res.data);
            console.log(res.data)
        } catch (error) {
            console.error('Error fetching news:', error);
        }
    };

    const fetchComments = async () => {
        try {
            let url = `${endpoints['binhluans']}${id}`;
            let res = await APIs.get(url);
            setComments(res.data);
        } catch (error) {
            console.error('Error fetching news:', error);
        }
    };

    const themBinhLuan = async (event) => {
        event.preventDefault();
        setIsCreatingComment(true);
        try {
            const newComment = {
                noiDung: newCommentContent,
                baiVietId: id,
                nguoiDungId: user.id,
                thoiGian: new Date()
            };

            const response = await APIs.post(`${endpoints['binhluans']}`, newComment);

            console.log('Bình luận đã được tạo:', response.data);

            // Cập nhật danh sách bình luận sau khi tạo bình luận mới thành công (nếu cần)
            fetchComments();
            // Xóa nội dung bình luận khỏi trường nhập liệu sau khi đã gửi thành công
            setNewCommentContent('');
            setIsCreatingComment(false);
        } catch (error) {
            console.error('Error creating comment:', error);
        }
    };

    useEffect(() => {
        fetchNews();
        fetchComments();
    }, [id]);

    if (!news) {
        return <p>Loading...</p>;
    }

    const showNoiDung = (noiDung) => {
        return noiDung.split('<br/>');
    };

    return (
        <Container className="mt-4">
            <Row>
                <Col md={8}>
                    <h2>{news.ten}</h2>
                    <small>Ngày đăng: {new Date(news.ngayTao).toLocaleDateString()}</small>
                    <hr />
                    {showNoiDung(news.noiDung).map((n, index) => (
                        <p key={index}>{n}</p>
                    ))}

                    <div>
                        <FacebookShareButton
                            url={'https://www.example.com'}
                            quote={'KTDiemRenLuyen'}
                            hashtag="#ktquanlydiemrenluyen"
                        >
                            <FacebookIcon size={32} round />
                        </FacebookShareButton>
                        <TwitterShareButton
                            url={'https://www.example.com'}
                            quote={'KTDiemRenLuyen'}
                            hashtag="#ktquanlydiemrenluyen"
                        >
                            <TwitterIcon size={32} round />
                        </TwitterShareButton>
                    </div>
                    {news.hoatDongId && <EventRegis key={0} props={news.hoatDongId} index={0} />}
                    
                </Col>
                <Col md={4} style={{ borderLeft: '1px solid #ccc', height: '100%' }}>
                    <h4>Bài viết liên quan</h4>
                    <ul>

                    </ul>
                </Col>
            </Row>
            <hr />
            <Container>
                <h4>Các bình luận</h4>
                {isCreatingComment ? (
                    <MySpinner /> // Hiển thị spinner khi đang tạo bình luận
                ) : (
                    <Form className="mb-2">
                    <Form.Group className="mb-3" controlId="commentTextarea">
                        <Form.Label>Nhập bình luận của bạn:</Form.Label>
                        <Form.Control
                            as="textarea"
                            rows={3}
                            placeholder="Viết bình luận của bạn ở đây..."
                            value={newCommentContent}
                            onChange={(e) => setNewCommentContent(e.target.value)} />
                    </Form.Group>
                    <Button onClick={themBinhLuan} variant="primary" type="submit">
                        Đăng bình luận
                    </Button>
                </Form>
                )}

                {comments && comments.map(cm => <Row key={cm.id}><Comment props={cm} /></Row>)}
            </Container>
        </Container>
    );
};

export default NewsDetail;
