import React from 'react';
import BlogList from './BlogList.jsx';
import axios from 'axios';
import {SERVER} from './Constants.jsx';

class HomePage extends React.Component {

    constructor(props){
        super(props);
        this.state = { models : [] };
    }
    
    componentDidMount(){
        // Make HTTP request with Axios
        axios.get(SERVER + "rest/blog?offset=" + 0 + "&limit=" + 20)
          .then((res) => {
            console.log(res);
            // Set state with result
            this.setState({
                models : res.data
            });
          });
    }

	render() {
	  	return (
			<div id="home-page-container">
                <section id="home-slider">
                    <div className="container">
                        <div className="main-slider">
                            {  !this.props.loggedIn &&
                                <div className="slide-text">
                                     <a href="#" className="btn btn-common" onClick={this.props.onSignUp}>SIGN UP</a>&nbsp;&nbsp;<a href="#" className="btn btn-common" onClick={this.props.onLogin}>SIGN IN</a>
                                </div>
                            }
                            {
                                this.props.loggedIn &&
                                <div className="slide-text">
                                     <h1><b>Welcome</b></h1>
                                </div>
                            }
                            <img src="images/home/slider/slide1/house.png" className="img-responsive slider-house" alt="slider image"/>
                            <img src="images/home/slider/slide1/circle1.png" className="slider-circle1" alt="slider image"/>
                            <img src="images/home/slider/slide1/circle2.png" className="slider-circle2" alt="slider image"/>
                            <img src="images/home/slider/slide1/cloud1.png" className="slider-cloud1" alt="slider image"/>
                            <img src="images/home/slider/slide1/cloud2.png" className="slider-cloud2" alt="slider image"/>
                            <img src="images/home/slider/slide1/cloud3.png" className="slider-cloud3" alt="slider image"/>
                            <img src="images/home/slider/slide1/sun.png" className="slider-sun" alt="slider image"/>
                            <img src="images/home/cycle.png" className="slider-cycle" alt=""/>
                        </div>
                    </div>
                </section>
                <section id="services">
                    <div className="container">
        <BlogList models={this.state.models} onBlogItemClick={this.props.onBlogItemClick}/>
                    </div>
                </section>
            </div>
	  	);
	}
}

export default HomePage;