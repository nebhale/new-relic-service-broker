# New Relic Service Broker
[![Build Status](https://travis-ci.org/nebhale/new-relic-service-broker.svg?branch=master)](https://travis-ci.org/nebhale/new-relic-service-broker)

This project is a self-hostable application that provides a service broker that proxies New Relic credentials to applications.  This is typically useful for on-premise deployments of Cloud Foundry that wish to easily bind to an off-premise New Relic deployment.  In order to facilitate self-hosting, the application is designed to work in [Cloud Foundry][p].

## Requirements

### Java, Maven
The application is written in Java and packaged as a self executable JAR file.  This enables it to run in anywhere that Java is available.  Building the application (required for deployment) requires [Maven][v].

## Deployment
_The following instructions assume that you have [created an account][c] and [installed the `cf` command line tool][l]._

In order to automate the deployment process as much as possible, the project contains a Cloud Foundry [manifest][m].  To deploy run the following commands:

```bash
$ mvn package
$ cf push
```

### Environment Variables
Since the application is designed to work in a PaaS environment, all configuration is done with environment variables.  The `LICENSE_KEY` value is the only one that is provided by New Relic.  All others are unique to a deployment.

| Key | Description
| --- | -----------
| `LICENSE_KEY` | The New Relic account license key to provide to all applications.  This can be found on the Account Settings Summary page in New Relic.
| `SECURITY_USER_NAME` | The username that the Cloud Foundry Cloud Controller should use to authenticate.  This can be any value.
| `SECURITY_USER_PASSWORD` | The password that the Cloud Foundry Cloud Controller should use to authenticate.  This can be any value
| `SERVICE-BROKER_PLAN_ID` | The id for the plan advertised by the service broker.  This **must** be a UUID.  A new UUID can be generated [here][u].
| `SERVICE-BROKER_SERVICE_ID` | the id of the service advertised by the service broker.  This **must** be a UUID.  A new UUID can be generated [here][u].

## Developing
The project is set up as a Maven project and doesn't have any special requirements beyond that.


## License
The project is released under version 2.0 of the [Apache License][a].

[a]: http://www.apache.org/licenses/LICENSE-2.0
[c]: http://docs.cloudfoundry.com/docs/dotcom/getting-started.html#signup
[l]: http://docs.cloudfoundry.com/docs/dotcom/getting-started.html#install-cf
[m]: manifest.yml
[p]: http://run.pivotal.io
[u]: http://www.famkruithof.net/uuid/uuidgen
[v]: http://maven.apache.org
