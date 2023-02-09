# This repository is deprecated and will be archived
We moved [here](https://github.com/eclipse-tractusx/traceability-foss-backend) and the actual development takes place [here](https://github.com/catenax-ng/tx-traceability-foss-backend)

<div style="display: flex; align-items: center;justify-content: center;align-content: center;">
   <img src="./docs/trace-x-logo.svg" alt="Product Traceability FOSS Backend (TRACE-FOSS)" style="width:200px;"/>
   <h1 style="margin: 10px 0 0 10px">Product Traceability FOSS Backend</h1>
</div>

[![Apache 2 License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://github.com/eclipse-tractusx/traceability-foss-backend/blob/main/LICENSE)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=catenax-ng_traceability-foss-backend&metric=coverage)](https://sonarcloud.io/summary/overall?id=catenax-ng_traceability-foss-backend)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=catenax-ng_traceability-foss-backend&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=catenax-ng_traceability-foss-backend)
[![Kics](https://github.com/eclipse-tractusx/traceability-foss-backend/actions/workflows/kics.yml/badge.svg)](https://github.com/eclipse-tractusx/traceability-foss-backend/actions/workflows/kics.yml)
[![Trivy](https://github.com/eclipse-tractusx/traceability-foss-backend/actions/workflows/trivy.yml/badge.svg)](https://github.com/eclipse-tractusx/traceability-foss-backend/actions/workflows/trivy.yml)
[![VeraCode](https://github.com/eclipse-tractusx/traceability-foss-backend/actions/workflows/veracode.yaml/badge.svg)](https://github.com/eclipse-tractusx/traceability-foss-backend/actions/workflows/veracode.yaml)
[![Eclipse DASH IP Check](https://github.com/eclipse-tractusx/traceability-foss-backend/actions/workflows/eclipse-dash.yml/badge.svg)](https://github.com/eclipse-tractusx/traceability-foss-backend/actions/workflows/eclipse-dash.yml)


## What is TRACE-FOSS?

Trace-FOSS is a system for tracking parts along the supply chain. A high level of transparency across the supplier network enables faster intervention based on
a recorded event in the supply chain. This saves costs by seamlessly tracking parts and creates trust through clearly defined and secure data access by the companies and persons involved in the process.

## Getting started

### Prerequisites

* JDK 17
* [Docker Engine](https://docs.docker.com/engine/)

### Installation

* see [Installation guide](INSTALL.md)

### Releasing

* see [Releasing guide](./docs/RELEASE.md)

### Running tests

#### Unit tests

To run unit tests invoke following command:

```sh
./gradlew test
```

#### Integration tests

Product Traceability FOSS Backend relies on [Testcontainers library](https://www.testcontainers.org/) in order to provide
persistence layer, thus [Docker Engine](https://docs.docker.com/engine/) is required to be running.

To run integration tests invoke following command:

```sh
./gradlew integrationTest
```

#### Running all tests

To run all tests invoke following command:

```sh
./gradlew testAll
```

*Please note that this task depends on `integrationTest` task, so it's required to have [Docker Engine](https://docs.docker.com/engine/) running.*

#### Generating OpenAPI clients

OpenAPI clients are generated based on [OpenAPI Specification files](./openapi) and [correlated gradle tasks](build.gradle.kts).

OpenAPI tasks have dependency on JavaCompile task that is OpenAPI client classes are automatically generated once you build the project
and there should not be a need to generate them manually, however following command can be used for such purpose:

```sh
./gradlew generateAasRegistryApi
```

## API documentation
The project follows [OpenAPI Specification](https://swagger.io/specification/) in order to document implemented REST Endpoints. The documentation can be found under [/openapi directory](./openapi/traceability-foss-backend.json)
or can be viewed in the Swagger UI accessing the url: `{projectBasePath}/api/swagger-ui/index.html`

## Coding styles

To maintain coding styles we utilize [EditorConfig](https://editorconfig.org/) tool, see [configuration](.editorconfig)
file for the details.

### IDE plugins

* IntelliJ IDEA ships with built-in support for .editorconfig files
* [Eclipse plugin](https://github.com/ncjones/editorconfig-eclipse#readme)
* [Visual studio code plugin](https://marketplace.visualstudio.com/items?itemName=EditorConfig.EditorConfig)

## Licenses
Apache 2.0 (https://www.apache.org/licenses/LICENSE-2.0) - see [LICENSE](./LICENSE)
