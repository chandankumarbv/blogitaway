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
                loadBlogListPage();
            }
        });
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

    var blogs = [
        {
            id: 1,
            title: 'Blog 1 Title',
            content: 'Blog 1 content Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',

            owner: {
                emailAddress: 'harish@gmail.com',
            }
        },
        {
            id: 2,
            title: 'Blog 1 Title',
            content: 'Blog 1 content Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',

            owner: {
                emailAddress: 'harish@gmail.com',
            }
        },
        {
            id: 3,
            title: 'Blog 1 Title',
            content: 'Blog 1 content Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',

            owner: {
                emailAddress: 'harish@gmail.com',
            }
        },
        {
            id: 4,
            title: 'Blog 1 Title',
            content: 'Blog 1 content Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',

            owner: {
                emailAddress: 'harish@gmail.com',
            }
        },
        {
            id: 5,
            title: 'Blog 1 Title',
            content: 'Blog 1 content Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',

            owner: {
                emailAddress: 'harish@gmail.com',
            }
        },
        {
            id: 6,
            title: 'Blog 1 Title',
            content: 'Blog 1 content Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',

            owner: {
                emailAddress: 'harish@gmail.com',
            }
        },
        {
            id: 7,
            title: 'Blog 1 Title',
            content: 'Blog 1 content Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber [...]',

            owner: {
                emailAddress: 'harish@gmail.com',
            }
        }
    ];


    var loadHomePage = function () {
        showPage(pages.homePage);

        $("#homepage-blogItemsContainer").loadTemplate("templates/blogitem.html", blogs, {
            afterInsert: addClickHandlerToBlogItems(blogs)
        });
    };

    var loadBlogListPage = function () {
        showPage(pages.blogsListPage);

        $("#homepage-blogItemsContainer").loadTemplate("templates/blogitem.html", blogs);

        addClickHandlerToBlogItems(blogs);
    };

    var loadBlogDetailsPage = function (blog) {
        showPage(pages.blogDetailsPage);
    };

    initialize();
    loadHomePage();
});