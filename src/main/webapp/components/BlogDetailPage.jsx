import React from 'react';

class BlogDetailPage extends React.Component {
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
                                                        <h2 className="post-title bold">
                                                            <a href="#">Title</a>
                                                        </h2>
                                                        <h3 className="post-author">
                                                            <a href="#">Author</a>
                                                        </h3>
                                                        <span>Content</span>
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