# New Relic Service Broker
[![Build Status](https://travis-ci.org/nebhale/new-relic-service-broker.svg?branch=master)](https://travis-ci.org/nebhale/new-relic-service-broker)

This project is a self-hostable application that provides a service broker that proxies New Relic credentials to applications.  This is typically useful for on-premise deployments of Cloud Foundry that wish to easily bind to an off-premise New Relic deployment.  In order to facilitate self-hosting, the application is designed to work in [Cloud Foundry][].

## Requirements

### Java, Maven
The application is written in Java and packaged as a self executable JAR file.  This enables it to run in anywhere that Java is available.  Building the application (required for deployment) requires [Maven][].

## Deployment
_The following instructions assume that you have [created an account][cloud-foundry-account] and [installed the `cf` command line tool][]._

In order to automate the deployment process as much as possible, the project contains a Cloud Foundry [manifest][].  To deploy run the following commands:

```bash
$ mvn -Dmaven.test.skip=true package
$ cf push
```

### Environment Variables
Since the application is designed to work in a PaaS environment, all configuration is done with environment variables.

| Key | Description
| --- | -----------
| `LICENSE_KEY` | The New Relic account license key to provide to all application
| `SECURITY_USER_NAME` | The username that the cloud controller should use to authenticate
| `SECURITY_USER_PASSWORD` | The password that the cloud controller should use to authenticate
| `SERVICE-BROKER_PLAN_ID` | The id for the plan advertised by the service broker
| `SERVICE-BROKER_SERVICE_ID` | the id of the service advertised by the service broker

## Developing
The project is set up as a Maven project and doesn't have any special requirements beyond that.


## License
The project is released under version 2.0 of the [Apache License][].

[Apache License]: http://www.apache.org/licenses/LICENSE-2.0
[Cloud Foundry]: http://run.pivotal.io
[cloud-foundry-account]: http://docs.cloudfoundry.com/docs/dotcom/getting-started.html#signup
[installed the `cf` command line tool]: http://docs.cloudfoundry.com/docs/dotcom/getting-started.html#install-cf
[manifest]: manifest.yml
[Maven]: http://maven.apache.org
