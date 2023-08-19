import { useEffect , useState } from 'react';
import React from 'react'

function Default1() {
    const style = {
        outerWidth : "1000px"
    }
    const [emps,setEmps] = useState([]);
    const [message,setMessage] = useState("");
    //debugger;
    const GetLatestData = () => {
        var helper = new XMLHttpRequest();
        helper.onreadystatechange = () => {
            //debugger;
            if(helper.readyState == 4 && helper.status == 200)
            {
              //  debugger;
                setEmps(JSON.parse(helper.responseText));
            }
        }
        helper.open("GET","http://localhost:8080/customer");
        helper.send();
    }
    
    useEffect(() => {
        GetLatestData();
    },[])
  return (<>
               
                <hr></hr>
                <center style={{color: "green"}}>
                        {message}
                </center>
                <hr></hr>
                <div className="table-responsive"   style={{ width: "50%" }}>
                    <table className="table table-bordered">
                    <tbody>
                            {emps.map(emp=>{
                                return <tr key={emp.id}>
                                        <td>{emp.id}</td>
                                        <td>{emp.name}</td>
                                        <td>{emp.address}</td>
                                        <td>{emp.city}</td>
                                        <td>{emp.role}</td>
                                        <td>
                                        <button onClick={()=>{
                                            // DoEdit(emp.No);
                                        }} className="btn btn-warning">Edit</button>
                                        </td>

                                        <td>
                                        <button onClick={()=>{
                                            // DoDelete(emp.No);
                                        }} className="btn btn-danger">Delete</button>
                                        </td>
                                    </tr>
                            })}
                    </tbody>
                    </table>
                </div>
            </>);
}

export default Default1
