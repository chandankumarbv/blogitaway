import React from 'react';
import axios from 'axios';
import CommentList from './CommentList.jsx';
import ReactQuill from 'react-quill';

class BlogDetailPage extends React.Component {
    
    constructor(props){
        super(props);
        this.state = {
            blog: {
                title: 'DefaultTitle',
                owner: {
                    emailAddress: 'defaultEmail'
                },
                content: 'DefaultContent'
            },
            comments: [],
            commentContent: ''
        };
        
		this.handleChange = this.handleChange.bind(this);
		this.saveComment = this.saveComment.bind(this);
		this.loadComments = this.loadComments.bind(this);
    }
    
    handleChange(value) {
        this.setState({ commentContent: value })
    }
    
    saveComment(){
        axios({
                method:'post',
                url: "rest/blog/" + this.props.blogId + "/comment",
                headers: { "Authorization": "Bearer " + this.props.authToken},
                data: {
                    content: this.state.commentContent,
                    owner: {
                        userName: this.props.userName
                    },
                    createdAt: new Date().toJSON().slice(0,10)
                }
        })
        .then((res) => {
            this.loadComments();
        });
    }
    
    loadComments(){
        axios.get("rest/blog/" + this.props.blogId + "/comment")
                .then((resp) => {
                    this.setState({
                        comments : resp.data,
                        commentContent: ''
                        
                    });
                });
    }
    
    componentDidMount(){
        // Make HTTP reques with Axios
        axios.get("rest/blog/" + this.props.blogId)
            .then((res) => {
                console.log(this.props.blogId);
                console.log(res);
                // Set state with result
                this.setState({
                    blog : res.data
                });
            
                this.loadComments();
            });
    }
    
	render() {
	  	return (
            <div id="blog-details-page-container">
                <section id="blog-details">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-12 col-sm-12">
                                <div className="row">
                                    <div className="col-md-12 col-sm-12">
                                        <div className="single-blog blog-details two-column">
                                            <div className="post-content overflow">
                                                <span id="blogdetails-contentContainer">
                                                    <span>
                                                        <h1 className="post-title bold ">
                                                            <a href="#">{this.state.blog.title}</a>
                                                        </h1>
                                                        <h5 className="post-author">
                                                            <a href="#">Posted By {this.state.blog.owner.userName}</a>
                                                        </h5>
                                                        <div dangerouslySetInnerHTML={{__html: this.state.blog.content}}></div>
                                                    </span>
                                                </span>
                                            </div>
                                        </div>
                                        <div className="response-area">
                                            <h2 className="bold">Comments</h2>
                                            <CommentList models={this.state.comments} />
                                            {
                                                
                                                this.props.loggedIn &&
                                                <h3>Add Comment</h3>
                                                     
                                             }
                                            {
                                               
                                                this.props.loggedIn &&
                                                <div className="form-group">
                                                    <ReactQuill style={{height:"100px"}} value={this.state.commentContent} onChange={this.handleChange} />
                                                    <button type="button" style={{marginTop:"50px"}} onClick={this.saveComment}>Post</button> 
                                                </div>
                                                     
                                             }
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
	  	);
	}
}

export default BlogDetailPage;