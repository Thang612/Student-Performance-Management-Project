import React, { useContext, useState } from 'react';
import APIs, { endpoints } from '../../configs/APIs';
import MySpinner from '../Commons/MySpinner';
import { PayPalButtons, PayPalScriptProvider } from '@paypal/react-paypal-js';
import { UserContext } from '../../App';

const EventRegis = ({ props, index }) => {
    const [loading, setLoading] = useState(false);
    const [registered, setRegistered] = useState(false);
    const [paidFor, setPaidFor] = useState(false    )
    const [error, setError] = useState (null)
    const [user, dispatch] = useContext(UserContext)

    const themEvent = async () => {
        setLoading(true);
        try {
            const newEvent = {
                trangThai: false,
                hoatDongId: props.id,
                sinhVienId: user.id
            };

            await APIs.post(`${endpoints['hoatdong']}`, newEvent);
            alert("Đăng ký hoạt động thành công")
            setRegistered(true); // Set the registered state to true
        } catch (error) {
            console.error('Error creating comment:', error);
        } finally {
            setLoading(false);
        }
    };

    if (registered) {
        return null; // Do not render anything if registered
    }

    const handleApprove = ()=>{
        themEvent()
        setPaidFor(true)
    }
    if(paidFor){
        alert("Thanh toán cho hoạt động thành công")
    }
    if (error){
        alert(error)
    }
    return (
        <>
            {loading && <MySpinner />}
            <tr>
                <td>{index + 1}</td>
                <td>{props.dieuId?.dieu}</td>
                <td>{props.ten}</td>
                <td>{props.khoaId?.ten}</td>
                <td>{props.diem}</td>
                <td>{props.phi == null ? <button onClick={themEvent}>Đăng ký</button> : (
                    <PayPalScriptProvider options={{ clientId: 'ATpjUjaxfhH7tz2Ck2Qt51OKYOggjZj70hFVsyScAEyl3LaT-jj07QjV8FLgPjCcmypxcNcdfatuMz3c' }}>
                        <PayPalButtons
                            style={{
                                color: "blue",
                                layout: "horizontal",
                                height: 25,
                                tagline: false,
                                shape: "pill"
                            }}
                            onClick={(data, actions) => {
                                const hasAlready = false;
                                if (hasAlready){
                                    setError("Ba da thanh toan cho hoat dong nay")
                                    return actions.reject()
                                } else {
                                    return actions.resolve()
                                }

                            }}
                            createOrder={(data, actions) => {
                                return actions.order.create({
                                    purchase_units: [
                                        {
                                            description: "Thanh toán hoạt động",
                                            amount: {
                                                value: props.phi // Số tiền cần thanh toán
                                            }
                                        }
                                    ]
                                });
                            }}
                            onApprove={async(data, actions) => {
                                const order = await actions.order.capture()
                                console.log("order", order)

                                handleApprove()
                            }}
                            onCancel={()=>{
                                alert("Thanh toán đã bị hủy");
                            }}
                            onError={(err) => {
                                setError(err)
                                console.error("Paypal checkout onError", err)
                            }}
                        />
                    </PayPalScriptProvider>
                )}</td>
            </tr>
        </>
    );
};

export default EventRegis;
