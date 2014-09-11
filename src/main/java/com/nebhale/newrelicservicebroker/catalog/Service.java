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

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

final class Service {

    private final Catalog catalog;

    private final Object monitor = new Object();

    private volatile UUID id;

    private volatile String name;

    private volatile String description;

    private volatile Boolean bindable;

    private final List<String> tags = new ArrayList<>();

    private final ServiceMetadata serviceMetadata = new ServiceMetadata(this);

    private final List<String> requires = new ArrayList<>();

    private final List<Plan> plans = new ArrayList<>();

    private volatile DashboardClient dashboardClient;

    Service(Catalog catalog) {
        this.catalog = catalog;
    }

    UUID getId() {
        synchronized (this.monitor) {
            Assert.notNull(this.id, "Services must specify an id");
            return this.id;
        }
    }

    String getName() {
        synchronized (this.monitor) {
            Assert.notNull(this.name, "Services must specify a name");
            return this.name;
        }
    }

    String getDescription() {
        synchronized (this.monitor) {
            Assert.notNull(this.description, "Services must specify a description");
            return this.description;
        }
    }

    Boolean getBindable() {
        synchronized (this.monitor) {
            Assert.notNull(this.bindable);
            return this.bindable;
        }
    }

    List<String> getTags() {
        synchronized (this.monitor) {
            return this.tags;
        }
    }

    @JsonProperty("metadata")
    ServiceMetadata getServiceMetadata() {
        synchronized (this.monitor) {
            return this.serviceMetadata;
        }
    }

    List<String> getRequires() {
        synchronized (this.monitor) {
            return this.requires;
        }
    }

    List<Plan> getPlans() {
        synchronized (this.monitor) {
            return this.plans;
        }
    }

    @JsonProperty("dashboard_client")
    DashboardClient getDashboardClient() {
        synchronized (this.monitor) {
            return this.dashboardClient;
        }
    }

    Catalog and() {
        synchronized (this.monitor) {
            return this.catalog;
        }
    }

    Service id(UUID id) {
        synchronized (this.monitor) {
            this.id = id;
            return this;
        }
    }

    Service name(String name) {
        synchronized (this.monitor) {
            this.name = name;
            return this;
        }
    }

    Service description(String description) {
        synchronized (this.monitor) {
            this.description = description;
            return this;
        }
    }

    Service bindable(Boolean bindable) {
        synchronized (this.monitor) {
            this.bindable = bindable;
            return this;
        }
    }

    Service tags(String... tags) {
        synchronized (this.monitor) {
            Arrays.stream(tags).forEach(this.tags::add);
            return this;
        }
    }

    ServiceMetadata metadata() {
        synchronized (this.monitor) {
            return this.serviceMetadata;
        }
    }

    Service requires(String... requires) {
        synchronized (this.monitor) {
            Arrays.stream(requires).forEach(this.requires::add);
            return this;
        }
    }

    Plan plan() {
        synchronized (this.monitor) {
            Plan plan = new Plan(this);
            this.plans.add(plan);
            return plan;
        }
    }

    DashboardClient dashboardClient() {
        synchronized (this.monitor) {
            this.dashboardClient = new DashboardClient(this);
            return this.dashboardClient;
        }
    }

}
