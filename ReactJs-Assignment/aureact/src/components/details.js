import React from 'react'

function details(props) {
   const data=props.location.state.data
    return (
        <div className="container">
            <div className="p-4 p-md-5 mb-4 text-white rounded bg-dark">
    <div className="col-md-12 px-0">
      <h1 className="display-4 fst-italic">Title : {data.name}</h1>
      <h3 className="p-md-3 border-bottom">Author : {data.author}</h3>
      <p className="lead mt-5 my-5">Review : {data.review}</p>
      
    </div>
  </div>
            
           
           
        </div>
    )
}

export default details
