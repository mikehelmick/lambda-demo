
repositories.remote << 'http://repo1.maven.org/maven2'

THIS_VERSION = "1.0.0"

define 'lambda-demo' do
  project.version = THIS_VERSION
  project.group = 'com.mikehelmick'
  manifest['Copyright'] = 'Mike Helmick (C) 2014'

  desc 'Java 8, lambda demo.'

  compile.options.target = '1.8'
  compile.options.lint = 'all'
  compile.with 'com.google.guava:guava:jar:16.0.1'
  package :jar

  run.using :main => "com.mikehelmick.lambda.Demo"
end
