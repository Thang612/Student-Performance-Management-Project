import Pagination from 'react-bootstrap/Pagination';
import Table from 'react-bootstrap/Table';
import { useEffect, useState } from 'react';
import EventRegis from './EventRegis';


const EventListRegis = ({filteredHoatDongs}) =>{
    const [currentPage, setCurrentPage] = useState(1);
    const [itemsPerPage] = useState(10);

     // Tính toán dữ liệu cho trang hiện tại
     const indexOfLastItem = currentPage * itemsPerPage;
     const indexOfFirstItem = indexOfLastItem - itemsPerPage;
     const currentItems = filteredHoatDongs.slice(indexOfFirstItem, indexOfLastItem);
 
     const handlePageChange = (pageNumber) => {
         setCurrentPage(pageNumber);
     };
 
    return (
        <>
        <h4>Đăng ký hoạt động</h4>
        <Table striped bordered hover size="sm">
          <thead>
            <tr>
              <th>STT</th>
              <th>Điều</th>
              <th>Hoạt động</th>
              <th>Khoa</th>
              <th>Điểm</th>
              <th>Trạng thái</th>
            </tr>
          </thead>
          <tbody>
            {currentItems.length > 0 && currentItems.map((hd, index) => (
              <EventRegis key={index} props={hd} index={index} />
            ))}
          </tbody>
        </Table>
        <Pagination>
            <Pagination.First onClick={() => handlePageChange(1)} disabled={currentPage === 1} />
            <Pagination.Prev onClick={() => handlePageChange(currentPage - 1)} disabled={currentPage === 1} />
            {[...Array(Math.ceil(filteredHoatDongs.length / itemsPerPage))].map((_, i) => (
                <Pagination.Item key={i+1} active={i+1 === currentPage} onClick={() => handlePageChange(i+1)}>
                    {i+1}
                </Pagination.Item>
            ))}
            <Pagination.Next onClick={() => handlePageChange(currentPage + 1)} disabled={currentPage === Math.ceil(filteredHoatDongs.length / itemsPerPage)} />
            <Pagination.Last onClick={() => handlePageChange(Math.ceil(filteredHoatDongs.length / itemsPerPage))} disabled={currentPage === Math.ceil(filteredHoatDongs.length / itemsPerPage)} />
        </Pagination>
        </>
    )
}

export default EventListRegis