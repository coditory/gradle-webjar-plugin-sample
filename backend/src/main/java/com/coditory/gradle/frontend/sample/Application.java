package com.coditory.gradle.frontend.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.http.MediaType.TEXT_HTML;
import static org.springframework.web.reactive.function.server.RouterFunctions.resources;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@SpringBootApplication
public class Application {
    static public void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Returns index.html on all urls that:
     * - do not start with "/api/"
     * - do not contain a dot (omit static resources like "main.js")
     */
    @Bean
    public RouterFunction<ServerResponse> indexRouter(
            @Value("classpath:/static/index.html")
                    Resource indexHtml
    ) {
        IndexPageRequestPredicate predicate = new IndexPageRequestPredicate();
        HandlerFunction<ServerResponse> indexHtmlResponse =
                request -> ok()
                        .contentType(TEXT_HTML)
                        .bodyValue(indexHtml);
        return route(predicate, indexHtmlResponse);
    }

    @Bean
    RouterFunction<ServerResponse> staticResourcesRouter() {
        return resources("/**", new ClassPathResource("static/"));
    }

    private static class IndexPageRequestPredicate implements RequestPredicate {
        private final AntPathMatcher antPathMatcher = new AntPathMatcher();

        @Override
        public boolean test(ServerRequest request) {
            String path = request.path();
            return request.method() == HttpMethod.GET
                    && (path.equals("/") || (pathIsNotAFile(path) && pathIsNotApi(path)));
        }

        private boolean pathIsNotAFile(String path) {
            return antPathMatcher.match("/**/{path:[^\\.]*}", path);
        }

        private boolean pathIsNotApi(String path) {
            return !antPathMatcher.match("/api/**", path);
        }
    }
}