import { useEffect, useState } from 'react';
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';
import APIs, { endpoints } from '../../configs/APIs';
import { Container, Form, Table } from 'react-bootstrap';
import MySpinner from '../Commons/MySpinner';

const BaoThieu =()=> {
    const [loading, setLoading] = useState(false);
    const [hockis, setHocKis] = useState([]);
    const [hocki, setHocKi] = useState(null);
    const [dieu, setDieu] = useState();
    const [hoatdong, setHoatDong] = useState([]);
    const fectchBaoThieu = async (dieu) => {
        setLoading(true);
        try {
            let url = `${endpoints['baothieu']}${dieu}?hocki=${hocki}&sinhvien=1`;
            let res = await APIs.get(url);
            setHoatDong(res.data)
            console.log(hoatdong)
            console.log(url)
        } catch (error) {
            console.error('Error fetching news:', error);
        }finally{
            setLoading(false);
        }
    };

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

    const themEvent = async (hoatDongId) => {
        setLoading(true);
        try {
            const newBaoThieu = {
                trangThai: false,
                hoatDongId: hoatDongId,
                sinhVienId: 1
            };
            console.log(newBaoThieu)
            await APIs.post(`${endpoints['baothieu']}`, newBaoThieu);
            
        } catch (error) {
            console.error('Error creating:', error);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        loadHocKi();
    }, []);

    useEffect(() => {
        fectchBaoThieu(dieu)
    }, [dieu, hocki]);


  return (
    <>
        <Container>
        <label>Học kì - năm học</label>
        <Form.Select aria-label="Học kì - năm học" onChange={(e) => setHocKi(e.target.value)}>
            <option value="0">***Chọn học kì cần xem***</option>
           {hockis.map(hk => <option key={hk.id} value={hk.id}>Học kì {hk.hocKiId.hocKi} - {hk.namHocId.namHoc}</option>)} 
        </Form.Select>
        <div className="d-flex ">
            <button className="btn btn-primary" onClick={() => setDieu(1)}>Điều 1</button>
            <button className="btn btn-primary" onClick={() => setDieu(2)}>Điều 2</button>
            <button className="btn btn-primary" onClick={() => setDieu(3)}>Điều 3</button>
            <button className="btn btn-primary" onClick={() => setDieu(4)}>Điều 4</button>
            <button className="btn btn-primary" onClick={() => setDieu(5)}>Điều 5</button>
        </div>
        <h4>Danh sách điều {dieu}</h4>
        <Table>
            {loading&& <MySpinner/>}
            {hoatdong.map(hd=> 
            <tr>
                <td><button className="btn btn-success" onClick={()=>themEvent(hd[0])}>Báo Thiếu</button></td>
                <td>{hd[1]}</td>
                <td>{hd[2]}</td>
            </tr>)}
        </Table>
        </Container>
    </>

  );
}

export default BaoThieu;