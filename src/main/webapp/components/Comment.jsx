import React from 'react';

class Comment extends React.Component {
    constructor(props){
		super(props);
	}

	render() {
	  	return (
            <li className="media">
                <div className="post-comment">
                    <div className="media-body">
                        <span><i className="fa fa-user"></i>Posted by <a href="#">{this.props.owner.userName}</a></span>
                        <div dangerouslySetInnerHTML={{__html:  this.props.content}}></div>
                        <ul className="nav navbar-nav post-nav">
                            <li><a href="#"><i className="fa fa-clock-o"></i>{this.props.createdAt}</a></li>
                        </ul>
                    </div>
                </div>
            </li>
	  	);
	}
}

export default Comment;