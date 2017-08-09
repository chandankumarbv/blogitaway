$(document).ready(function () {

    var initialize = function () {
        $.addTemplateFormatter({
            PostedByFormatter: function (value, template) {
                return "Posted by " + value;
            },
            IdFormatter: function (value, template) {
                return elemetId(value);
            },
            ViewMoreFormatter: function (value, template) {
                return viewMoreLinkId(value);
            }
        });

        $("#logo").click(function myFunction() {
            loadHomePage();
        });

        $("#home-menu").click(function myFunction() {
            loadHomePage();
        });

        $("#search-box").keydown(function myFunction(event) {
            var x = event.keyCode;

            if (x == 13) { // 13 is the ENTER key
                loadBlogListPage($("#search-box")[0].value);
            }
        });

        $("#signInForm button[type=submit]").on("click", function () {
            var url = "/blogitaway/rest/user/login"
            var userName = $("#signInForm input[id=username]").val()
            var password = $("#signInForm input[id=pwd]").val()
            var user = {
                "userName": userName,
                "password": password
            }
            $.ajax({
                url: url,
                type: 'post',
                data: JSON.stringify(user),
                contentType: "application/json",
                success: function (result) {
                    alert(result);
	    				saveToken(result);
	    				saveCurrentUser(userName);
                },
                error: function (xhr) {
                    alert(xhr.status + " " + xhr.statusText);
                }
            })

        })

        $("#signUpForm button[type=submit]").on("click", function () {
            var url = "/blogitaway/rest/user/"
            var userName = $("#signUpForm input[id=username]").val()
            var password = $("#signUpForm input[id=pwd]").val()
            var user = {
                "userName": userName,
                "password": password
            }
            $.ajax({
                url: url,
                type: 'post',
                data: JSON.stringify(user),
                contentType: "application/json",
                success: function (result) {
                    alert(result);
	    				saveToken(result);
	    				saveCurrentUser(userName);
                },
                error: function (xhr) {
                    alert(xhr.status + " " + xhr.statusText);
                }
            })

        })
        $("#newBlogDialog button[type=submit]").on("click",function(){
		var url = "/blogitaway/rest/blog/"
		var title = $("#newBlogDialog input[id=title]").val()
		var content = tinymce.activeEditor.getContent();
		var user = getUser();
		var blog = {"title":title,"owner":{"userName":user}, "content":content}
		postWithAuth(url,blog,function(result){
			loadHomePage();
		},
		function(xhr){
 			alert(xhr.status+" "+xhr.statusText);
 		}
		)
/* 		$.ajax({
			url:url,
			type:'post',
			data:JSON.stringify(blog),
			contentType:"application/json",
			success:function(result){
				alert(result);
			},
	 		error:function(xhr){
	 			alert(xhr.status+" "+xhr.statusText);
	 		}
		})
 */
          })
    };

    var elemetId = function (value) {
        return "blogid-" + value;
    }

    var viewMoreLinkId = function (value) {
        return "blogid-viewmore-" + value;
    }

    var pages = {
        homePage: "home-page-container",
        blogsListPage: "blog-list-page-container",
        blogDetailsPage: "blog-details-page-container",
    }

    var showPage = function (pageid) {
        for (p in pages) {
            $("#" + pages[p]).hide();
        }

        $("#" + pageid).show();
    }

    var eventHandlerMap = {};

    var addClickHandlerToBlogItems = function (blogs) {
        for (i in blogs) {
            var blog = blogs[i];
            var selector = "#" + elemetId(blog.id);

            var handler = eventHandlerMap[selector];

            if (!handler) {
                handler = function () {
                    loadBlogDetailsPage(blog);
                };

                eventHandlerMap[selector] = handler;
                $(document).on('click', selector, handler);

                $(document).on('click', "#" + viewMoreLinkId(blog.id), function () {
                    loadBlogDetailsPage(blog);
                });
            }
        }
    }

    var services = {
        getBlogs: function (offset, limit, success) {
            callRest("/blogitaway/rest/blog?offset=" + offset + "&limit=" + limit, "get", success, function (xhr) {
                alert(xhr.status + " " + xhr.statusText);
            })
        },

        searchBlogs: function (query, offset, limit, success) {
            if (query) {
                callRest("/blogitaway/rest/blog/search?offset=" + offset + "&limit=" + limit + "&query=" + query, "get", success, function (xhr) {
                    alert(xhr.status + " " + xhr.statusText);
                })
            }
        },

        getBlog: function (blogId, success) {
            if (blogId) {
                callRest("/blogitaway/rest/blog/" + blogId, "get", success, function (xhr) {
                    alert(xhr.status + " " + xhr.statusText);
                })
            }
        }

    };

    var callRest = function (url, type, success, error) {
        $.ajax({
            url: url,
            type: type,
            contentType: "application/json",
            success: success,
            error: error
        })
    };

    var loadHomePage = function () {
        showPage(pages.homePage);

        services.getBlogs(0, 15, function (result) {
            $("#homepage-blogItemsContainer").loadTemplate("templates/blogitem.html", result, {
                afterInsert: addClickHandlerToBlogItems(result)
            });
        });
    };

    var loadBlogListPage = function (query) {
        showPage(pages.blogsListPage);

        services.searchBlogs(query, 0, 15, function (result) {
            $("#blog-list-page-blogItemsContainer").loadTemplate("templates/blogitem.html", result, {
                afterInsert: addClickHandlerToBlogItems(result)
            });
        });
    };

    var loadBlogDetailsPage = function (blog) {
        showPage(pages.blogDetailsPage);

        services.getBlog(blog.id, function (result) {
            $("#blogdetails-contentContainer").loadTemplate("templates/blogdetail.html", result);
        });
    };
    
    function postWithAuth(url,postData,successFn,errorFn){
    	var authToken = localStorage.getItem("token")
    	var authHeader = null;
    	if(authToken != null){
    		authHeader = { "Authorization": "Bearer " + authToken}
    	}
    	 $.ajax({
    			url:url,
    			type:'post',
    			headers: authHeader,
    			data:JSON.stringify(postData),
    			contentType:"application/json",
    			success:successFn,
    	 		error:errorFn
    		})
    }

    function saveToken(token){
    	if(token != null){
    		localStorage.setItem("token",token);
    	}
    }
    function saveCurrentUser(user){
    	if(user != null){
    		localStorage.setItem("user",user);
    	}
    }
    function clearStorage(){
    	localStorage.removeItem("token");
    	localStorage.removeItem("user");
    }
    function getUser(){
    	return localStorage.getItem("user");
    }

    initialize();
    loadHomePage();
});