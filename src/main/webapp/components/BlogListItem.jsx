import React from 'react';

class BlogListItem extends React.Component {
    constructor(props){
		super(props);
		this.onBlogItemClick = this.onBlogItemClick.bind(this);
		this.trimBlogContent = this.trimBlogContent.bind(this);
	}

    onBlogItemClick(event) {
        event.preventDefault();
        this.props.onBlogItemClick(this.props.id);
    };
    
    trimBlogContent(blogContent){
        var length = 40;
        var trimmedString = blogContent.length > length ? 
                blogContent.substring(0, length) + "..." : blogContent;
                return trimmedString;
    }

	render() {
	  	return (
            <div className="col-md-6 col-sm-12 blog-padding-right">
                <div className="single-blog two-column">
                    <div className="post-content overflow">
                        <h2 className="post-title bold"><a href="#" onClick={this.onBlogItemClick}>{this.props.title}</a></h2>
                        
                        <div dangerouslySetInnerHTML={{__html: this.trimBlogContent(this.props.content)}}></div>
                        <a className="read-more" onClick={this.onBlogItemClick}>View More</a>
                        <div className="post-bottom overflow">
                            <ul className="nav nav-justified post-nav">
                                <li>Author: {this.props.owner.userName}</li>
                                <li>Created @: {this.props.createdAt}</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
	  	);
	}
}

export default BlogListItem;