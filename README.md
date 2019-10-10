# sbt-github-actions-example

[![Actions Status](https://github.com/Kevin-Lee/github-actions-sbt-example/workflows/Docker%20Image%20CI/badge.svg)](https://github.com/Kevin-Lee/github-actions-sbt-example/actions)
[![Actions Status](https://github.com/Kevin-Lee/github-actions-sbt-example/workflows/CI/badge.svg)](https://github.com/Kevin-Lee/github-actions-sbt-example/actions)

[![Coverage Status](https://coveralls.io/repos/github/Kevin-Lee/github-actions-sbt-example/badge.svg?branch=master)](https://coveralls.io/github/Kevin-Lee/github-actions-sbt-example?branch=master)

# Build Config Tree
```
├── .docker
│  ├── docker-compose.yml
│  └── sbt-project
│     └── Dockerfile
├── .github
│  └── workflows
│     ├── dockerimage.yml
│     ├── sbt-build-simple.sh
│     ├── sbt-build.sh
│     ├── sbt-run-test.yml
│     └── sbt-run.sh
```