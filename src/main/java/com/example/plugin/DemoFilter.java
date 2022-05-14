package com.example.plugin;

import org.apache.apisix.plugin.runner.HttpRequest;
import org.apache.apisix.plugin.runner.HttpResponse;
import org.apache.apisix.plugin.runner.filter.PluginFilter;
import org.apache.apisix.plugin.runner.filter.PluginFilterChain;
import org.pf4j.Extension;
import reactor.core.publisher.Mono;

/**
 * Created by chenwenshun on 2022/5/14
 */
@Extension
public class DemoFilter implements PluginFilter {
    @Override
    public String name() {
        return "demoFilter";
    }

    @Override
    public Mono<Void> filter(HttpRequest httpRequest, HttpResponse httpResponse, PluginFilterChain chain) {
        httpRequest.setHeader("uname", "Tony");
        return chain.filter(httpRequest, httpResponse);
    }
}
