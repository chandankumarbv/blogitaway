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
    }

    handleChange(value) {
        this.setState({ content: value })
    }
    
    handleTitleChange(e) {
    	this.setState({title : e.target.value});
    }
    
    saveBlog(){
        axios.post("http://localhost:8585/blogitaway/rest/blog/", {
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
                <section id="new-blog-page">
                   <div className="container">
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
                </section>
            </div>
	  	);
	}
}

export default SignUpPage;