
name := "scalqa"

sonatypeBundleDirectory := (ThisBuild / baseDirectory).value / "make" / "release" / "sonatype-staging"
publishTo               := sonatypePublishToBundle.value


autoAPIMappings := true

apiMappings += ((unmanagedBase.value / "a-library.jar") -> url("https://example.org/api/"))