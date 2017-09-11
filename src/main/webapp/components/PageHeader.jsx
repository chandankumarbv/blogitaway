import React from 'react';

class PageHeader extends React.Component {
	constructor(params){
		super(params);

		this.state = {
			searchText: ""
		};

		this.handleChange = this.handleChange.bind(this);
		this.onkeypress = this.onkeypress.bind(this);
	};

	onkeypress(event){
		if(event.charCode==13){
			this.props.onSearch(this.state.searchText);
    	}
	};

	handleChange(e) {
    	this.setState({searchText : e.target.value});
  	};

	render() {
	  	return (
			<header id="header">
				<div className="container">
					<div className="row">
						<div className="col-sm-12 overflow">
							<div className="social-icons pull-right">
								<ul className="nav nav-pills">
									<li><a href=""><i className="fa fa-facebook"></i></a></li>
									<li><a href=""><i className="fa fa-twitter"></i></a></li>
									<li><a href=""><i className="fa fa-google-plus"></i></a></li>
									<li><a href=""><i className="fa fa-dribbble"></i></a></li>
									<li><a href=""><i className="fa fa-linkedin"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div className="navbar navbar-inverse" role="banner">
					<div className="container">
						<div className="navbar-header">
							<button type="button" className="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span className="sr-only">Toggle navigation</span>
								<span className="icon-bar"></span>
								<span className="icon-bar"></span>
								<span className="icon-bar"></span>
							</button>

							<a id="logo" className="navbar-brand" onClick={this.props.onHomeClick}>
								<h1><img src="images/logo.png" alt="logo"/></h1>
							</a>

						</div>
						<div className="collapse navbar-collapse">
							<ul className="nav navbar-nav navbar-right">
								<li id="home-menu"><a onClick={this.props.onHomeClick}>Home</a></li>
								{
									this.props.loggedIn && <li><a onClick={this.props.onNewBlogClick}>New Blog</a></li>
								}
								{
									this.props.loggedIn && <li><a onClick={this.props.logout}>Sign Out</a></li>
								}
							</ul>
						</div>
						<div className="search">
							<div role="form">
								<i className="fa fa-search"></i>
								<div className="field-toggle">
									<input id="search-box" type="text" className="search-form" autoComplete="off" placeholder="Search Blogs" onChange={ this.handleChange } onKeyPress={this.onkeypress}/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>
	  	);
	}
}

export default PageHeader;