import Spinner from 'react-bootstrap/Spinner';

const MySpinner = () => {
    return (
        <div className="d-flex justify-content-center align-items-center" style={{ height: '100vh' }}>
            <Spinner animation="border" variant="info" />
        </div>
    )
}

export default MySpinner;
