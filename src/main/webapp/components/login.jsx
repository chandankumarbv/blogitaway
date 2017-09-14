import React from 'react';
import axios from 'axios';

class LoginPage extends React.Component {
    constructor(props) {
        super(props)
        this.state = { 
            userName: '',
            password: ''
        } // You can also pass a Quill Delta here
        this.handleUserNameChange = this.handleUserNameChange.bind(this)
        this.handlePasswordChange = this.handlePasswordChange.bind(this)
        this.loginClick = this.loginClick.bind(this)
    }

    handleUserNameChange(e) {
        this.setState({ userName: e.target.value })
    }
    
    handlePasswordChange(e) {
    	this.setState({password : e.target.value});
    }
    
    loginClick(){
        axios.post("rest/user/login", {
                userName: this.state.userName,
                password: this.state.password
          })
          .then((res) => {
                alert(res.data);
                
                this.props.onLoginSuccess({
                    authToken: res.data,
                    userName: this.state.userName
                });
          });
    }
    
	render() {
	  	return (
            <div id="new-blog-page-container" className="padding-top">
               <section id="page-breadcrumb">
                    <div className="vertical-center sun">
                        <div className="container">
                            <div className="row">
                                <div className="action">
                                    <div className="col-sm-12">
                                        <h1 className="title">Login</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="new-blog-page">
                   <div className="container">
                        <form id="signInForm">
                                <div className="form-group">
                                    <label htmlFor="username">Username:</label>
                                    <input type="text" className="form-control" id="username" onChange={this.handleUserNameChange}/>
                                </div>
                                <div className="form-group">
                                    <label htmlFor="pwd">Password:</label>
                                    <input type="password" className="form-control" id="pwd"
                                    onChange={this.handlePasswordChange}/>
                                </div>
                                <div className="checkbox">
                                    <label>
                                        <input type="checkbox"/> Remember me</label>
                                </div>
                                <button type="button" className="btn btn-default" onClick={this.loginClick}>Submit</button>
                         </form>
                   </div>
                </section>
            </div>
	  	);
	}
}

export default LoginPage;