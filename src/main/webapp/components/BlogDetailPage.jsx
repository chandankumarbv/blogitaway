import React from 'react';
import axios from 'axios';

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
            }
        };
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
                                                            @ {this.state.blog.owner.userName}
                                                        </h5>
                                                        <div dangerouslySetInnerHTML={{__html: this.state.blog.content}}></div>
                                                    </span>
                                                </span>
                                            </div>
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