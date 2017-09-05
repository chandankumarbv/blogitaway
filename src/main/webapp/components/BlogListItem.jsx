import React from 'react';

class BlogListItem extends React.Component {
    constructor(props){
		super(props);
		this.onBlogItemClick = this.onBlogItemClick.bind(this);
	}

    onBlogItemClick(event) {
        event.preventDefault();
        this.props.onBlogItemClick(this.props.id);
    };

	render() {
	  	return (
            <div className="col-md-6 col-sm-12 blog-padding-right">
                <div className="single-blog two-column">
                    <div className="post-content overflow">
                        <h2 className="post-title bold"><a href="#" onClick={this.onBlogItemClick}>{this.props.title}</a></h2>
                        <h3 className="post-author"><a href="#">{this.props.author.emailAddress}</a></h3>
                        <p>{this.props.content}</p>
                        <a className="read-more">View More</a>
                        <div className="post-bottom overflow">
                            <ul className="nav nav-justified post-nav">
                                <li><a href="#"><i className="fa fa-tag"></i>Creative</a></li>
                                <li><a href="#"><i className="fa fa-heart"></i>32 Love</a></li>
                                <li><a href="#"><i className="fa fa-comments"></i>3 Comments</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
	  	);
	}
}

export default BlogListItem;