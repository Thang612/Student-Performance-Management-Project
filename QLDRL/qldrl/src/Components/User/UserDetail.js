import { useContext } from "react"
import { UserContext } from "../../App"
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';


const UserDetail = ()=>{
    const [user, dispatch] = useContext(UserContext);
    console.log(user.namsinh)
    return(
        <>
        {user && 
         <Card style={{ width: '18rem' }}>
            <Card.Img variant="top" src={user.avatar} />
            <Card.Body>
                <Card.Title>{user.ho + user.ten}</Card.Title>
                <Card.Text>
                    Email: {user.email}
                </Card.Text>
                <Card.Text>
                    Năm sinh: {new Date(user.namSinh).toLocaleDateString()}
                </Card.Text>
            </Card.Body>
        </Card>
        }
        </>
    )
}

export default UserDetail;