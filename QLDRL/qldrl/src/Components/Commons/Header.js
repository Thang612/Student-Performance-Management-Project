import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link } from 'react-router-dom';
import Login from '../User/Login';
import Register from '../User/Register';

function Header() {
    const logoUrl = process.env.PUBLIC_URL + '/logo.png';
  return (
    <Navbar expand="lg" className="bg-body-tertiary" >
      <Container fluid>
        <Navbar.Brand ><Link to="/"><img style={{ maxHeight: '60px' }} src={logoUrl}></img></Link></Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: '100px' }}
            navbarScroll
          >
            <Nav.Link><Link to="/" className="text-info">Trang chủ</Link></Nav.Link>
            <NavDropdown  className="text-info" title="Hoạt động" id="navbarScrollingDropdown">
            <NavDropdown.Item  className="text-info" as={Link} to="hoatdong/dathamgia">Hoạt động đã đăng ký</NavDropdown.Item>
            <NavDropdown.Item  className="text-info" as={Link} to="hoatdong/dangky">Đăng kí hoạt động</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item  className="text-info" as={Link} to="hoatdong/ketqua">Kết quả rèn luyện</NavDropdown.Item>

            </NavDropdown>
            <Nav.Link>
              <Link  className="text-info" to="/diendan">
              Diễn đàn</Link>
            </Nav.Link>
            <Nav.Link>
              <Login/>
            </Nav.Link>
            <Nav.Link>
            <Link  className="text-info" to="/dangnhap">
            Đăng nhập</Link>
            </Nav.Link>
            <Nav.Link>
            <Link  className="text-info" to="/dangky">
            Đăng ký</Link>
            </Nav.Link>
          </Nav>
          <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search"
              className="me-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
          </Form>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;