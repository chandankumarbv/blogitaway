import React from 'react';
import BlogListItem from './BlogListItem.jsx'

class BlogList extends React.Component {
	render() {
	  	return (
			<div className="row">
                {this.props.models.map(model => <BlogListItem key={model.id} {...model} onBlogItemClick={this.props.onBlogItemClick}/>)}
            </div>
	  	);
	}
}

export default BlogList;