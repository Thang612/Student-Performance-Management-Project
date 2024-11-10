const Event = ({ props,index })=>{
    console.log(props)
    return (
        <tr>
            <td>{index + 1}</td>
            <td>{props[0].dieuId.dieu}</td>
            <td>{props[0].ten}</td>
            <td>{props[0].khoaId.ten}</td>
            <td>{props[0].diem}</td>
            <td>{props[1] ? 'Đã tham gia' : 'Đã đăng kí'}</td>
        </tr>
    );
}

export default Event;