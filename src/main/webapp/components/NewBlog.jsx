import React from 'react';
import ReactQuill from 'react-quill';
import axios from 'axios';

class NewBlogPage extends React.Component {
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
        var axios_instance = axios.create({
          headers: { "Authorization": "Bearer " + this.props.authToken}
        })
        axios({
                method:'post',
                url:'rest/blog/',
                headers: { "Authorization": "Bearer " + this.props.authToken},
                data: {
                    title: this.state.title,
                    content: this.state.content,
                    owner: {
                        userName: this.props.userName
                    }
                }
        })
        .then((res) => {
            this.props.onNewBlogCreated();
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
                                        <h1 className="title">Add a new blog</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="new-blog-page">
                   <div className="container">
                        <form id="newBlogForm">
                            <div className="form-group">
                                <label htmlFor="title">Title:</label>
                                <input type="text" className="form-control" id="title" value={this.state.title}  onChange={this.handleTitleChange} />
                            </div>
                            <div className="form-group">
                                <label htmlFor="content">BlogContent:</label>
                                <ReactQuill style={{height:"100px"}} value={this.state.content} onChange={this.handleChange} />
                            </div>
                            <button type="button" style={{marginTop:"50px"}} onClick={this.saveBlog}>Submit</button>
                        </form>
                   </div>
                </section>
            </div>
	  	);
	}
}

export default NewBlogPage;