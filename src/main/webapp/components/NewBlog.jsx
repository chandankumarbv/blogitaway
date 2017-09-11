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
                        <form id="newBlogForm">
                            <div class="form-group">
                                <label for="title">Title:</label>
                                <input type="text" class="form-control" id="title" value={this.state.title}  onChange={this.handleTitleChange} />
                            </div>
                            <div class="form-group">
                                <label for="content">BlogContent:</label>
                                <ReactQuill value={this.state.content} onChange={this.handleChange} />
                            </div>
                            <button type="button" onClick={this.saveBlog}>Submit</button>
                        </form>
                   </div>
                </section>
            </div>
	  	);
	}
}

export default NewBlogPage;