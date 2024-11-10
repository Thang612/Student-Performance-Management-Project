function deleteHoatDong(url) {
    fetch(url, {method: 'delete'}).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("ERROR");
    });
}




function drawChartTheoKhoa(ctx, labels, data,title) {
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: title ,
                    data: data,
                    borderWidth: 1,
                    backgroundColor:['red', 'green', 'blue', 'gold', 'brown', 'orange']
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

function deleteBaiViet(url) {
    fetch(url, {method: 'delete'}).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("ERROR");
    });
}

function updateBaoThieu(url, data) {
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => {
        if (res.status === 200 || res.status === 204) {
            location.reload();
        } else {
            alert("ERROR");
        }
    }).catch(error => {
        console.error('Error:', error);
        alert("ERROR");
    });
}
function deleteBaoThieu(url) {
    fetch(url, {method: 'delete'}).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("ERROR");
    });
}
