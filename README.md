# jdk9-liquibase-agent

This java agent is designed to Patch the file 'liquibase.util.SystemUtils'

As of now, running liquibase with jdk9 will result in this stacktrace

`
Caused by: java.lang.StringIndexOutOfBoundsException: begin 0, end 3, length 1
	at java.base/java.lang.String.checkBoundsBeginEnd(String.java:3116)
	at java.base/java.lang.String.substring(String.java:1885)
	at liquibase.util.SystemUtils.getJavaVersionAsFloat(SystemUtils.java:1154)
	at liquibase.util.SystemUtils.<clinit>(SystemUtils.java:819)
	... 15 more	
`

to fix this, you can use this projects jar file run your application with the vm-option
' -javaagent:/path/to/jdk9-liquibase-agent.jar'

Please note that you will also need ByteBuddy on your classpath:
https://mvnrepository.com/artifact/net.bytebuddy/byte-buddy