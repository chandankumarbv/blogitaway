import React from 'react';
import BlogList from './BlogList.jsx';

class BlogListPage extends React.Component {
    constructor(props){
        super(props);

        this.state = {
            models : [
                {
                    id: 1,
                    title: 'Advanced business cards design',
                    content: 'Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',
                    author:{
                        emailAddress: 'micron News'
                    }
                },
                {
                    id: 2,
                    title: 'Advanced business cards design',
                    content: 'Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',
                    author:{
                        emailAddress: 'micron News'
                    }
                },
                {
                    id: 3,
                    title: 'Advanced business cards design',
                    content: 'Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',
                    author:{
                        emailAddress: 'micron News'
                    }
                },
                {
                    id: 4,
                    title: 'Advanced business cards design',
                    content: 'Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',
                    author:{
                        emailAddress: 'micron News'
                    }
                },
                {
                    id: 5,
                    title: 'Advanced business cards design',
                    content: 'Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',
                    author:{
                        emailAddress: 'micron News'
                    }
                },
                {
                    id: 6,
                    title: 'Advanced business cards design',
                    content: 'Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',
                    author:{
                        emailAddress: 'micron News'
                    }
                },
                {
                    id: 7,
                    title: 'Advanced business cards design',
                    content: 'Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',
                    author:{
                        emailAddress: 'micron News'
                    }
                }
            ]
        };
    }

	render() {
	  	return (
			<div id="blog-list-page-container" className="padding-top">
                <section id="page-breadcrumb">
                    <div className="vertical-center sun">
                        <div className="container">
                            <div className="row">
                                <div className="action">
                                    <div className="col-sm-12">
                                        <h1 className="title">Search Results</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <section id="blog" className="padding-top">
                    <div className="container">
                        <div className="row">
                            <div className="col-md-12 col-sm-12">
                                <BlogList models={this.state.models}/>
                                <div className="blog-pagination">
                                    <ul className="pagination">
                                        <li><a href="#">left</a></li>
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li className="active"><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">6</a></li>
                                        <li><a href="#">7</a></li>
                                        <li><a href="#">8</a></li>
                                        <li><a href="#">9</a></li>
                                        <li><a href="#">right</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
	  	);
	}
}

export default BlogListPage;