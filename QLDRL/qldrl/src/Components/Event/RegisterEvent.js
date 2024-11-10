import { useContext, useEffect, useState } from 'react';
import APIs, { endpoints } from '../../configs/APIs';
import MySpinner from '../Commons/MySpinner';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import EventListRegis from './EventListRegis';
import { UserContext } from '../../App';

function RegisterEvent() {
        const [loading, setLoading] = useState(false);

    const [hockis, setHocKis] = useState([]);
    const [hocki, setHocKi] = useState(null);
    const [filteredHoatDongs, setFilteredHoatDongs] = useState([]);
    const [user,dispatch] = useContext(UserContext);
    const loadHocKi = async () => {
        setLoading(true);
        try {
            let url = `${endpoints['hockinamhoc']}`;
            let res = await APIs.get(url);
            setHocKis(res.data);
        } catch (error) {
            console.error("Error fetching data:", error);
            // Hiển thị thông báo lỗi cho người dùng hoặc thực hiện hành động khác tùy thuộc vào yêu cầu
        } finally {
            setLoading(false); // Set loading to false after API call
        }
        
    }

    const loadHoatDong = async () => {
        setLoading(true);
        try {
            const url = `${endpoints['hoatdong']}chuadangky/?hocki=${hocki}&sinhvien=${user.id}`;
            console.info(url);
            const res = await APIs.get(url);
            setFilteredHoatDongs(res.data);
        } catch (ex) {
            console.error(ex);
        } finally {
            setLoading(false); 
        }
    }

    useEffect(() => {
        loadHoatDong();
        console.log(filteredHoatDongs)

    }, [hocki]);

    useEffect(() => {
        loadHocKi();
    }, []);

   
    return (
        <>
        <Container>
        {loading && <MySpinner />}
        <label>Học kì - năm học</label>
        <Form.Select aria-label="Học kì - năm học" onChange={(e) => setHocKi(e.target.value)}>
            <option value="0">***Chọn học kì cần xem***</option>
           {hockis.map(hk => <option key={hk.id} value={hk.id}>Học kì {hk.hocKiId.hocKi} - {hk.namHocId.namHoc}</option>)} 
        </Form.Select>

        <EventListRegis filteredHoatDongs = {filteredHoatDongs}/>
        </Container>
        </>
    );
}

export default RegisterEvent;

