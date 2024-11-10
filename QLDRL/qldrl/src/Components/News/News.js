import Card from 'react-bootstrap/Card';
import Tooltip from 'react-bootstrap/Tooltip';
import OverlayTrigger from 'react-bootstrap/OverlayTrigger';
import { useNavigate } from 'react-router-dom';

const News = (props) => {
    const navigate = useNavigate();

    const showNews = (id) => {
        navigate(`/baiviet/`+ id);
    }

    const formatDate = (timestamp) => {
        const date = new Date(timestamp);
        return date.toLocaleDateString();
      };

    return (
        
        <OverlayTrigger
            placement="bottom"
            overlay={<Tooltip id="tooltip-top">Nhấn để xem chi tiết</Tooltip>}>
            <Card onClick={() => showNews(props.id)} border="secondary" style={{ width: '100%' }}>
                <Card.Header>Ngày tạo: {formatDate(props.ngayTao)}</Card.Header>
                <Card.Body>
                    <Card.Title>{props.ten}</Card.Title>
                    <Card.Text className="line-clamp">
                        {props.noiDung}
                    </Card.Text>
                </Card.Body>
            </Card>
        </OverlayTrigger>      
        
        
    );
}

export default News;