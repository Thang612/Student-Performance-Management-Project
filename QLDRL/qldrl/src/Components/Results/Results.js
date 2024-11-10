import React, { useEffect, useState } from 'react';
import Table from 'react-bootstrap/Table';
import ResultsCeil from './ResultsCeil';
import APIs, { endpoints } from '../../configs/APIs';
import { Container, Form } from 'react-bootstrap';

const Results = () => {
  const fixedWidth = { width: '150px' }; // You can adjust this value as needed
  const dieuValues = [1, 2, 3, 4, 5]; // Adjust as needed
  const [loading, setLoading] = useState(false);
  const [hockis, setHocKis] = useState([]);
  const [hocki, setHocKi] = useState();

  const loadHocKi = async () => {
    setLoading(true);
    try {
      let url = `${endpoints['hockinamhoc']}`;
      let res = await APIs.get(url);
      setHocKis(res.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    } finally {
      setLoading(false); // Set loading to false after API call
    }
  }

  useEffect(() => {
    loadHocKi();
  }, []);

  return (
    <>
      <Container>
      <h4>Kết quả rèn luyện</h4>
      <label>Học kì - năm học</label>
      <Form.Select aria-label="Học kì - năm học" onChange={(e) => setHocKi(e.target.value)}>
        <option value="0">***Chọn học kì cần xem***</option>
        {hockis.map(hk => (
          <option key={hk.id} value={hk.id}>Học kì {hk.hocKiId.hocKi} - {hk.namHocId.namHoc}</option>
        ))}
      </Form.Select>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Tên hoạt động</th>
            <th style={fixedWidth}>Điểm sinh viên</th>
            <th style={fixedWidth}>Điểm tối đa</th>
          </tr>
        </thead>
        <tbody>
          {dieuValues.map(dieu => (
            <ResultsCeil key={dieu} dieu={dieu} hocki={hocki} />
          ))}
        </tbody>
        <tr style={{ fontWeight: 'bold', backgroundColor: 'skyblue' }}>
          <th></th>
          <th></th>
          <th style={fixedWidth}>Tổng cộng</th>
          <th style={fixedWidth}>100</th>
        </tr>
      </Table>
      </Container>
    </>
  );
}

export default Results;
