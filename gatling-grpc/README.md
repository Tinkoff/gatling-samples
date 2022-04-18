# Gatling Mygrpc Project

[[_TOC_]]

## CI

Simulations are run using [perf-ci-template](https://gitlab.tcsbank.ru/perf-core/perf-ci-template) and [gatling-docker-gun](https://gitlab.tcsbank.ru/perf-core/gatling-docker-gun)

All CI configuration can be found in [.gitlab-ci.yml](.gitlab-ci.yml)

## Launch and debug

### Project structure

```bash
src.test.resources - project resources
src.test.scala.ru.tinkoff.load.mygrpc.cases - simple cases
src.test.scala.ru.tinkoff.load.mygrpc.scenarios - common load scenarios assembled from simple cases
src.test.scala.ru.tinkoff.load.mygrpc - common test configs
```

### Debug

1. Debug test with 1 user, requires proxy on localhost:8888, eg using Fiddler or Wireshark

```bash
"Gatling / testOnly ru.tinkoff.load.mygrpc.Debug"
```

2. Run test from IDEA with breakpoints

```bash
ru.tinkoff.load.GatlingRunner
```

### Launch test

```bash
"Gatling / testOnly ru.tinkoff.load.mygrpc.MaxPerformance" - maximum performance test
"Gatling / testOnly ru.tinkoff.load.mygrpc.Stability" - stability test
```

## Links

Performance team slack channel: [#team-performance-ask](https://tinkoff.slack.com/archives/CEY0FJD5Y)

Simulation run notifications: [#performance-test-runs](https://tinkoff.slack.com/archives/C011K6YS1GS)

Performance testing projects: [repositories](https://devplatform.tcsbank.ru/performance/repositories)

Cosmos: [latest runs](https://devplatform.tcsbank.ru/performance/cosmos/latest)

Wiki info page: [Performance & Load](https://wiki.tcsbank.ru/pages/viewpage.action?pageId=19441513)

Performance CI template info: [perf-ci-template](https://gitlab.tcsbank.ru/perf-core/perf-ci-template)

Gatling Docker Gun info: [gatling-docker-gun](https://gitlab.tcsbank.ru/perf-core/gatling-docker-gun)
