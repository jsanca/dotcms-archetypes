# dotCMS Maven Archetypes

This repository contains Maven archetypes for creating dotCMS plugin blueprints.

Each archetype provides a starting point for a specific kind of dotCMS extension, such as REST endpoints, workflow actionlets, web interceptors, hooks, viewtools, and other plugin patterns.

## Requirements

Before using these archetypes, make sure you have:

- Java installed and available in your terminal.
- Maven installed and available in your terminal.
- This repository cloned locally.

You can verify your environment with:

```bash
java -version
mvn -version
````

## Installing the archetypes locally

From the root of this repository, run:

```bash
chmod +x install-me.bash
./install-me.bash
```

The script will search for Maven archetypes under folders named `archetype`, for example:

```text
rest/archetype/pom.xml
actionlet/archetype/pom.xml
webinterceptor/archetype/pom.xml
```

Each archetype will be installed into your local Maven repository using:

```bash
mvn clean install
```

The script will also update your local Maven archetype catalog using:

```bash
mvn archetype:crawl
```

The script is safe to run multiple times. Existing local archetypes with the same `groupId`, `artifactId`, and `version` will be reinstalled.

## Using an archetype

After installing the archetypes locally, you can generate a new dotCMS plugin project using Maven.

Example using the REST endpoint archetype:

```bash
mvn archetype:generate \
  -DarchetypeCatalog=local \
  -DarchetypeGroupId=com.dotcms \
  -DarchetypeArtifactId=rest-endpoint-example-archetype \
  -DarchetypeVersion=0.2 \
  -DgroupId=jsanca \
  -DartifactId=dotcms-content-model-inspector \
  -Dversion=1.0.0-SNAPSHOT \
  -Dpackage=jsanca.dotcms.inspector \
  -DinteractiveMode=false
```

This will create a new project named:

```text
dotcms-content-model-inspector
```

Then you can enter the generated project and build it:

```bash
cd dotcms-content-model-inspector
mvn clean package
```

## Parameters

When generating a project, these are the most important parameters:

| Parameter             | Description                                                                       |
| --------------------- | --------------------------------------------------------------------------------- |
| `archetypeCatalog`    | Use `local` to generate from archetypes installed in your local Maven repository. |
| `archetypeGroupId`    | The group ID of the archetype. Usually `com.dotcms`.                              |
| `archetypeArtifactId` | The artifact ID of the archetype you want to use.                                 |
| `archetypeVersion`    | The version of the archetype.                                                     |
| `groupId`             | The Maven group ID of the project you are generating.                             |
| `artifactId`          | The Maven artifact ID and folder name of the generated project.                   |
| `version`             | The version of the generated project.                                             |
| `package`             | The base Java package for the generated source code.                              |
| `interactiveMode`     | Use `false` to generate the project without interactive prompts.                  |

## Available archetypes

| Folder                 | Purpose                                                                            |
| ---------------------- | ---------------------------------------------------------------------------------- |
| `actionlet`            | Blueprint for adding a workflow actionlet.                                         |
| `app`                  | Blueprint for adding a configuration app for dotCMS.                               |
| `contenttype`          | Blueprint for programmatically adding a content type.                              |
| `hooks`                | Blueprint for adding hooks to do pre and post interception on the `ContentletAPI`. |
| `hooks.validations`    | Blueprint for adding custom validation hooks during `ContentletAPI` check-in.      |
| `pubsub`               | Blueprint for implementing pub/sub with PostgreSQL.                                |
| `pushpublish.listener` | Blueprint for subscribing to and listening for push publish events.                |
| `rest`                 | Blueprint for adding a new REST endpoint to dotCMS.                                |
| `validation`           | Blueprint for adding a validation actionlet.                                       |
| `viewtool`             | Blueprint for adding a Velocity viewtool.                                          |
| `webinterceptor`       | Blueprint for adding a web interceptor.                                            |

## Typical workflow

```bash
git clone <this-repository-url>
cd dotcms-archetypes

chmod +x install-me.bash
./install-me.bash

cd ../your-plugins-folder

mvn archetype:generate \
  -DarchetypeCatalog=local \
  -DarchetypeGroupId=com.dotcms \
  -DarchetypeArtifactId=rest-endpoint-example-archetype \
  -DarchetypeVersion=0.2 \
  -DgroupId=com.example \
  -DartifactId=my-dotcms-rest-plugin \
  -Dversion=1.0.0-SNAPSHOT \
  -Dpackage=com.example.dotcms.rest \
  -DinteractiveMode=false

cd my-dotcms-rest-plugin
mvn clean package
```

## Notes

These archetypes are intended as blueprints. After generating a project, review and adjust:

* The Maven coordinates.
* The Java package.
* The bundle metadata.
* The dotCMS core version.
* The generated example classes.
* Any plugin-specific configuration.

Generated projects are standalone Maven projects by default. They are not expected to be children of this archetype repository.

````

