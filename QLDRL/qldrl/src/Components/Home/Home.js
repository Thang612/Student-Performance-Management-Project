import { useContext, useEffect, useState } from "react";
import APIs, { endpoints } from "../../configs/APIs";
import MySpinner from "../Commons/MySpinner";
import News from "../News/News";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Gemini from "../Gemini/Gemini";



const Home = () => {
    const [baiviets, setBaiViets] = useState([]);
    const [loading, setLoading] = useState(false);

    const loadBaiViets = async () => {
        setLoading(true);
        try {
            let url = `${endpoints['baiviets']}`;
            let res = await APIs.get(url);
            setBaiViets(res.data);
        } catch (ex) {
            console.error(ex);
        } finally {
            setLoading(false); // Set loading to false after API call
        }
    }

    useEffect(() => {
        loadBaiViets();
    }, []); // Empty dependency array to run once when component mounts

    return (
        <>
            <Gemini/>
            <Container>
            <h4>Các bài viết</h4>
            <hr/>
            {loading && <MySpinner />}
            {baiviets.map(b =><Row className="m-1">< News key={b.id} {...b} /></Row>)}
            </Container>
        </>
    );
}

export default Home;
