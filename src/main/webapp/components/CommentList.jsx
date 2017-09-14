import React from 'react';
import Comment from './Comment.jsx'

class CommentList extends React.Component {
	render() {
	  	return (
            <ul className="media-list">
                {this.props.models.map(model => <Comment key={model.commentId} {...model} />)}
            </ul>
	  	);
	}
}

export default CommentList;