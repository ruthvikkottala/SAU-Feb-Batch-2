import React,{useState} from 'react'
import { useSelector,useDispatch } from "react-redux";
import { getBooks } from "../redux/books/bookAction";
import { Link } from "react-router-dom";
function Home() {
    let [list,setList]=useState([])
    let [bookname,setName]=useState('')
    let books=useSelector(state=>state.books);
    const dispatch=useDispatch();
    dispatch(getBooks());
   
    const getList=()=>{
        setList(books.map((obj,idx)=><h3 className="p-2 list-group-item list-group-item-action btn-outline-success"  style={{borderRadius: "1rem"}} key={idx}><Link className="text-reset" to={{
            pathname: '/details',
            state: {
              data: obj
            }
          }} >{obj.name}</Link></h3>))
    }
    const handleChange=(e)=>{
       
        setName(e.target.value)
        
    }
    const search=()=>{
        let trial=[]
        for(let i=0;i<books.length;i++){
            let st=books[i].name.toLowerCase()
            let st2=bookname.toLowerCase()
            if(st.search(st2)!==-1){
                trial.push(<h3 className="p-2 list-group-item list-group-item-action btn-outline-success"  style={{borderRadius: "1rem"}} key={i} ><Link className="text-reset" to={{
                    pathname: '/details',
                    state: {
                      data: books[i]
                    }
                  }}>{books[i].name}</Link></h3>)
            }
          
        }
        
        setList(trial)
    }

    return (
        <div>
            {/* <div className="jumbotron jumbotron-fluid">
                <div className="container">
                    <h1 className="display-4">Home component</h1>
                    <p className="lead">There’s no question that getting a book as a present is great no matter what the title or when it happens. But what about those books that we’re given that are so special they alter the course of our lives in some way or change the way we think about the world?

                Read it Forward spoke with some of our favorite authors about the book they received that has given them the most joy over the years. We hope that pausing to think about the life-changing magic of literature will be a wonderful compliment to your holiday season!</p>
                </div>
            </div>
            <button onClick={getList}>Click me</button><br/>
            <input type="text" name="bookname" onChange={handleChange}></input>
            <button onClick={search}>Search</button>
            <div id="target" className="list-group">{list}</div> */}
             
            <div class="s130">
            <div className="container">
                    <h1 className="display-4">Home component</h1>
                    <p className="lead">There’s no question that getting a book as a present is great no matter what the title or when it happens. But what about those books that we’re given that are so special they alter the course of our lives in some way or change the way we think about the world?

                Read it Forward spoke with some of our favorite authors about the book they received that has given them the most joy over the years. We hope that pausing to think about the life-changing magic of literature will be a wonderful compliment to your holiday season!</p>
                <button className="btn btn-lg btn-outline-secondary px-6 fw-bold" style={{borderRadius: "5rem",padding:".5rem 5rem"}} onClick={getList}>Show All</button><br/>
                </div>
        <form>
        <div class="inner-form">
        <div class="input-field first-wrap">
        <div class="svg-wrapper">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
        <path d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
        </svg>
        </div>
        <input id="search" type="text" placeholder="What are you looking for?" name="bookname" onChange={handleChange}/>
        </div>
        <div class="input-field second-wrap">
        <button class="btn-search" type="button" onClick={search}>SEARCH</button>
        </div>
        </div>
        <span class="info">ex.Any keyword Little, Go, It</span>
        </form>
        <div id="target" className="list-group">{list}</div>
        </div>
        </div>
       
    )

}
export default Home
