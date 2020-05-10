# Sample usage of [gradle-webjar-plugin](https://github.com/coditory/gradle-webjar-plugin)

This project presents how to use [gradle-webjar-plugin](https://github.com/coditory/gradle-webjar-plugin)
to separate front end and back end modules in a typical [Spring-boot](https://spring.io/projects/spring-boot) application.

## Back end
Backend project is a simple Spring Webflux application.
- Spring by default serves static resources from `classpath:/static`
- There is an endpoint that forwards all html requests to `classpath:/static/index.html` to serve SPA from front end module

## Front end
Frontend project was generated with [Vue CLI](https://cli.vuejs.org/guide/creating-a-project.html)