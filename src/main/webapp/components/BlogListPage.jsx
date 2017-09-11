import React from 'react';
import BlogList from './BlogList.jsx';
import axios from 'axios';

class BlogListPage extends React.Component {
    constructor(props){
        super(props);
        this.state = {models:[]};
    }
    
    componentDidMount(){
        // Make HTTP reques with Axios
        axios.get("rest/blog/search?offset=" + 0 + "&limit=" + 20 + "&query=" + this.props.searchText)
          .then((res) => {
            console.log(this.props.searchText);
            console.log(res);
            // Set state with result
            this.setState({
                models : res.data
            });
          });
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
                                <BlogList models={this.state.models} onBlogItemClick={this.props.onBlogItemClick}/>
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