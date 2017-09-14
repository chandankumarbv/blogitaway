import React from 'react';
import PageHeader from './PageHeader.jsx';
import PageFooter from './PageFooter.jsx';
import HomePage from './HomePage.jsx';
import BlogListPage from './BlogListPage.jsx';
import BlogDetailPage from './BlogDetailPage.jsx';
import * as Constants from './Constants.jsx';
import NewBlogPage from './NewBlog.jsx';
import LoginPage from './login.jsx';
import SignUpPage from './SignUpPage.jsx';
import axios from 'axios';


class App extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            page: Constants.Pages.HOME,
            loggedIn: false,
            loggedInUserDetails: null,
            params: null
        };

		this.goToPage = this.goToPage.bind(this);
		this.goToHomePage = this.goToHomePage.bind(this);
		this.goToBlogListPage = this.goToBlogListPage.bind(this);
		this.goToBlogDetailPage = this.goToBlogDetailPage.bind(this);
		this.goToUserProfilePage = this.goToUserProfilePage.bind(this);
		this.goToLoginPage = this.goToLoginPage.bind(this);
		this.goToSignUpPage = this.goToSignUpPage.bind(this);
		this.onLogin = this.onLogin.bind(this);
		this.logout = this.logout.bind(this);
		this.onSearch = this.onSearch.bind(this);
        this.goToNewBlogPage = this.goToNewBlogPage.bind(this);
    }

    goToPage(page, params){
        this.setState(
        {
            page: page, 
            params: params
        });
    };

    goToNewBlogPage(){
        this.goToPage(Constants.Pages.NEW_BLOG, null);
    }
    
    goToHomePage(){
        this.goToPage(Constants.Pages.HOME, null);
    };

    goToBlogListPage(search){
        this.goToPage(Constants.Pages.BLOG_LIST, {searchText: search});
    };

    goToBlogDetailPage(blogId){
        this.goToPage(Constants.Pages.BLOG_DETAIL, {blogId: blogId});
    };

    goToUserProfilePage(userId){
        this.goToPage(Constants.Pages.USER_PROFILE, {userId: userId});
    };

    goToLoginPage(){
        this.goToPage(Constants.Pages.LOGIN, null);
    };

    goToSignUpPage(){
        this.goToPage(Constants.Pages.SIGNUP, null);
    };

    onLogin(loggedInUserDetails){
        this.setState(
        {
            page: Constants.Pages.HOME, 
            params: null,
            loggedInUserDetails: loggedInUserDetails,
            loggedIn: true,
        });
    }

    logout(){
        this.setState(
        {
            page: Constants.Pages.HOME, 
            params: null,
            loggedInUserDetails: null,
            loggedIn: false
        });
    };

    getBodyComponent(page, params){
        switch(page){
            case Constants.Pages.BLOG_LIST:
                return <BlogListPage onBlogItemClick={this.goToBlogDetailPage} userId={params.userId} searchText={params.searchText}/>;

            case Constants.Pages.BLOG_DETAIL:
                return <BlogDetailPage blogId={params.blogId}/>;

            case Constants.Pages.NEW_BLOG:
                return <NewBlogPage onNewBlogCreated={this.goToHomePage} authToken={this.state.loggedInUserDetails.authToken} userName={this.state.loggedInUserDetails.userName}/>;
                
            case Constants.Pages.LOGIN:
                return <LoginPage onLoginSuccess={this.onLogin}/>;
                
            case Constants.Pages.SIGNUP:
                return <SignUpPage onSignupSuccess={this.onLogin}/>
                
            default:
                return <HomePage onLogin={this.goToLoginPage} onSignUp={this.goToSignUpPage} onBlogItemClick={this.goToBlogDetailPage} loggedIn={this.state.loggedIn}/>;
        }
    };

    onSearch(searchText){
        if(searchText && searchText.trim() != ""){
            this.goToBlogListPage(searchText);
        }
    };

	render() {
        let pageBody = this.getBodyComponent(this.state.page, this.state.params);

	  	return (
            <div>
                <PageHeader logout={this.logout} loggedIn={this.state.loggedIn} onSearch={this.onSearch} onHomeClick={this.goToHomePage} onNewBlogClick={this.goToNewBlogPage}></PageHeader>
                {pageBody}
                <PageFooter></PageFooter>
            </div>
	  	);
	}
}

export default App;