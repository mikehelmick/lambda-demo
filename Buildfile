
repositories.remote << 'http://repo1.maven.org/maven2'

THIS_VERSION = "1.0.0"

GUAVA = 'com.google.guava:guava:jar:16.0.1'

def getClasspath
  cp = Buildr.artifacts(GUAVA)
  cp << 'target/classes'
  return cp.join(':')
end

def runTask(clazz)
  system "java -cp #{getClasspath} com.mikehelmick.lambda.#{clazz}"
end

define 'lambda-demo' do
  project.version = THIS_VERSION
  project.group = 'com.mikehelmick'
  manifest['Copyright'] = 'Mike Helmick (C) 2014'

  desc 'Java 8, lambda demo.'

  compile.options.target = '1.8'
  compile.options.lint = 'all'
  compile.with GUAVA
  package :jar

  task :Java7Example => :compile do
    runTask('Java7Example')
  end

  task :RunnableLambda => :compile do
    runTask('RunnableLambda')
  end

  task :SortingExample => :compile do
    runTask('SortingExample')
  end

  task :MapExample => :compile do
    runTask('Map')
  end
end
