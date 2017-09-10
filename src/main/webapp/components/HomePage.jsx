import React from 'react';
import BlogList from './BlogList.jsx';
import axios from 'axios';

class HomePage extends React.Component {

    constructor(props){
        super(props);
        this.state = { models : [] };
    }
    
    componentDidMount(){
        // Make HTTP reques with Axios
        axios.get("http://localhost:8585/blogitaway/rest/blog?offset=" + 0 + "&limit=" + 20)
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
                                     <a href="#" className="btn btn-common" data-toggle="modal" data-target="#signUpDialog">SIGN UP</a>&nbsp;&nbsp;<a href="#" data-toggle="modal" data-target="#signInDialog" className="btn btn-common" onClick={this.props.onLogin}>SIGN IN</a>
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
                <div id="signInDialog" className="modal fade" role="dialog">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal">&times;</button>
                                <h4 className="modal-title">Sign In</h4>
                            </div>
                            <div className="modal-body">
                                <form id="signInForm">
                                    <div className="form-group">
                                        <label htmlFor="username">Username:</label>
                                        <input type="text" className="form-control" id="username"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="pwd">Password:</label>
                                        <input type="password" className="form-control" id="pwd"/>
                                    </div>
                                    <div className="checkbox">
                                        <label>
                                            <input type="checkbox"/> Remember me</label>
                                    </div>
                                    <button type="submit" data-dismiss="modal" className="btn btn-default">Submit</button>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
                <div id="signUpDialog" className="modal fade" role="dialog">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <button type="button" className="close" data-dismiss="modal">&times;</button>
                                <h4 className="modal-title">Sign Up</h4>
                            </div>
                            <div className="modal-body">
                                <form id="signUpForm">
                                    <div className="form-group">
                                        <label htmlFor="username">Username:</label>
                                        <input type="text" className="form-control" id="username"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="pwd">Password:</label>
                                        <input type="password" className="form-control" id="pwd"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="pwd">Confirm Password:</label>
                                        <input type="password" className="form-control" id="pwd"/>
                                    </div>
                                    <button type="submit" data-dismiss="modal" className="btn btn-default">Submit</button>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
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