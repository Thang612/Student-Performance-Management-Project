import { useEffect, useState } from "react";
import APIs, { endpoints } from '../../configs/APIs';
import MySpinner from "../Commons/MySpinner";

const fixedWidth = { width: '150px' }; // You can adjust this value as needed

const ResultsCeil = ({ dieu, hocki }) => {
  const [diems, setDiems] = useState([]);
  const [diemDieu, setDiemDieu] = useState(null);
  const [loading, setLoading] = useState(false);

  const fetchChiTietDiem = async () => {
    setLoading(true);
    try {
      let url = `${endpoints['ketqua']}${dieu}?hocki=${hocki}&sinhvien=1`;
      let res = await APIs.get(url);
      setDiems(res.data);
    } catch (error) {
      console.error('Error fetching details:', error);
    } finally {
      setLoading(false);
    }
  };

  const fetchDieu = async () => {
    try {
      let url = `${endpoints['ketqua']}dieu/${dieu}?hocki=${hocki}&sinhvien=1`;
      let res = await APIs.get(url);
      setDiemDieu(res.data);
    } catch (error) {
      console.error('Error fetching dieu:', error);
    }
  };

  useEffect(() => {
    if (hocki) {
      fetchChiTietDiem();
      fetchDieu();
    }
  }, [dieu, hocki]);

  if (loading) return <MySpinner />;

  if (!diemDieu || diemDieu.length === 0) return null;

  const tongDiem = useState();

  return (
    <>
      <tr style={{ fontWeight: 'bold', backgroundColor: 'blue' }}>
        <td colSpan={2}><b>Điều: {diemDieu[0][1]}</b></td>
        <td style={fixedWidth}>{diemDieu[0][3]}</td>
        <td style={fixedWidth}>{diemDieu[0][2]}</td>
      </tr>
      {diems.map((d, index) => <Ceil key={index} index={index + 1} ceil={d} />)}
    </>
  );
}

const Ceil = ({ ceil, index }) => {
  return (
    <tr>
      <td>{index}</td>
      <td>{ceil[0]}</td>
      <td style={fixedWidth}>{ceil[1]}</td>
      <td style={fixedWidth}>{ceil[1]}</td>
    </tr>
  );
}

export default ResultsCeil;
