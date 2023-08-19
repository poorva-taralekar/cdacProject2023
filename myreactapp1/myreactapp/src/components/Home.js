//rfce
import React from 'react'
import './Home.css'
//import homeImg from './imgs/Home.jpg'
function Home() {

    const divStyle = {
        backgroundColor: '#D3D3D3',     // Background color
        border: '2px solid',    // Border
        padding: '50px',            // Additional styling properties can be added
        marginTop: '400px',
        marginBottom: '50px',
        
        
    };
    // const homeStyle = {
    //     backgroundImage: 'url("/imgs/Home.jpg")', // Replace with the actual path to your image
    //     backgroundSize: 'cover', // Adjust the sizing of the background image
    //     backgroundPosition: 'center', // Adjust the position of the background image
    //     width: '300px',
    //     height: '200px'
    // };
    return (
      
       // <div >
       <section class="section bg-light pb-0" >
         <img src="/imgs/Home.jpg" alt='Background'className='image'/> 
            <div class="container" style={divStyle} className='overlay'>

        <div class="row check-availabilty" id="next">
          <div class="block-32" data-aos="fade-up" data-aos-offset="-200">

            <form action="#">
              <div class="row">
                <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                  <label for="checkin_date" class="font-weight-bold text-black">Check In</label>
                  <div class="field-icon-wrap">
                    <div class="icon"><span class="icon-calendar"></span></div>
                    <input type="text" id="checkin_date" class="form-control"/>
                  </div>
                </div>
                <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                  <label for="checkout_date" class="font-weight-bold text-black">Check Out</label>
                  <div class="field-icon-wrap">
                    <div class="icon"><span class="icon-calendar"></span></div>
                    <input type="text" id="checkout_date" class="form-control"/>
                  </div>
                </div>
                <div class="col-md-6 mb-3 mb-md-0 col-lg-3">
                  <div class="row">
                    <div class="col-md-6 mb-3 mb-md-0">
                      <label for="adults" class="font-weight-bold text-black">City</label>
                      <div class="field-icon-wrap">
                        <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                        <select name="" id="adults" class="form-control">
                          <option value="">1</option>
                          <option value="">2</option>
                          <option value="">3</option>
                          <option value="">4+</option>
                        </select>
                      </div>
                    </div>
                    
                  </div>
                </div>
                <div class="col-md-6 col-lg-3 align-self-end">
                  <button class="btn btn-primary btn-block text-white">Check Availabilty</button>
                </div>
              </div>
            </form>
          </div>


        </div>
      </div>
          </section>
         // </div>
  )
}

export default Home