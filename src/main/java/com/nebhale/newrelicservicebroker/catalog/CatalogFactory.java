/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nebhale.newrelicservicebroker.catalog;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.UUID;

@Configuration
public class CatalogFactory {

    @Bean
    Catalog catalog(@Value("${serviceBroker.serviceId}") String serviceId,
                    @Value("${serviceBroker.planId}") String planId) {
        // @formatter:off
        return new Catalog()
            .service()
                .id(UUID.fromString(serviceId))
                .name("newrelic")
                .description("Manage and monitor your apps")
                .bindable(true)
                .tags("newrelic", "management", "monitoring", "apm")
                .metadata()
                    .displayName("New Relic")
                    .imageUrl(URI.create("https://newrelic.com/images/logo/logo-newrelic-white.png"))
                    .longDescription("New Relic is the all-in-one web app performance tool that lets you see " +
                                     "performance from the end user experience, through servers, and down to the " +
                                     "line of code.")
                    .providerDisplayName("New Relic, Inc.")
                    .documentationUrl(URI.create("https://docs.newrelic.com"))
                    .supportUrl(URI.create("https://support.newrelic.com/home"))
                    .and()
                .plan()
                    .id(UUID.fromString(planId))
                    .name("standard")
                    .description("Broker for static New Relic credentials")
                    .metadata()
                        .bullets("JVM Performance analyzer", "Database call response time & throughput",
                                 "Performance data API access")
                        .displayName("Standard")
                        .and()
                    .free(true)
                    .and()
                .and();
        // @formatter:on
    }

}
