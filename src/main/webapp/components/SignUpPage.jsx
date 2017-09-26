import React from 'react';
import axios from 'axios';

class SignUpPage extends React.Component {
    constructor(props) {
        super(props)
        this.state = { 
            content: '',
            title: ''
        } // You can also pass a Quill Delta here
        this.handleChange = this.handleChange.bind(this)
        this.handleTitleChange = this.handleTitleChange.bind(this)
        this.saveBlog = this.saveBlog.bind(this)
        this.signUpClick = this.signUpClick.bind(this)
        this.validatePassword = this.validatePassword.bind(this)
    }

    validatePassword(value){
        if(this.refs.password.value != this.refs.confirmpassword.value){
            document.getElementById("passwordMatchError").style.visibility = "visible";
            return false;
        }else{
            document.getElementById("passwordMatchError").style.visibility = "hidden";
            return true;
        }
        
        
    }
    
    handleChange(value) {
        this.setState({ content: value })
    }
    
    handleTitleChange(e) {
    	this.setState({title : e.target.value});
    }
    
    signUpClick(){
        if(this.validatePassword()){
            axios.post("rest/user", {
                userName: this.refs.username.value,
                password: this.refs.password.value
          })
          .then((res) => {
                alert(res.data);
                
                this.props.onSignupSuccess({
                    authToken: res.data,
                    userName: this.refs.username.value
                });
          })
          .catch((err) => {
              alert(err.response.data.message)
          })
            
          ;
        }
    }
    
    saveBlog(){
        axios.post("rest/blog/", {
                title: this.state.title,
                content: this.state.content
          })
          .then((res) => {
            this.props.onNewBlogCreated();
          });
    }
    
	render() {
	  	return (
            <div id="new-blog-page-container" className="padding-top">
               <section id="page-breadcrumb" >
                    <div className="vertical-center sun">
                        <div className="container">
                            <div className="row">
                                <div className="action">
                                    <div className="col-sm-12">
                                        <h1 className="title">Sign Up</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="new-blog-page">
                   <div className="container">
                       <form id="signUpForm">
                                    <div className="form-group">
                                        <label htmlFor="username">Username:</label>
                                        <input type="text" className="form-control" id="username" ref="username" />
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="pwd">Password:</label>
                                        <input type="password" className="form-control" id="pwd" onChange={this.validatePassword} ref="password" />
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="pwd">Confirm Password:</label>
                                        <input type="password" className="form-control" id="pwd" onChange={this.validatePassword} ref="confirmpassword"/>
                                    </div>
                                     <div className="form-group" style={{visibility:"hidden"}} id="passwordMatchError"><img src="images/warning.png" style={{marginRight: "10px"}}/>Password do not match !</div> 
                                    <button type="submit" onClick={this.signUpClick} data-dismiss="modal" className="btn btn-default">Submit</button>
                        </form>
                   </div>
                </section>
            </div>
	  	);
	}
}

export default SignUpPage;