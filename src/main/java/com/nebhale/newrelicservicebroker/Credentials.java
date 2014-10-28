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

package com.nebhale.newrelicservicebroker;

/**
 * A holder for credential information such as the license key
 */
public final class Credentials {

    private final String licenseKey;

    /**
     * Creates a new instance with a given license key
     *
     * @param licenseKey the license key to expose
     */
    public Credentials(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    /**
     * Returns the license key
     *
     * @return the license key
     */
    public String getLicenseKey() {
        return this.licenseKey;
    }

}
