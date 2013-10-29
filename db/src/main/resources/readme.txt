一、maven使用oracle的连接jar
	因为 oracle的连接jar需要授权，所以默认情况下，从 maven的官方库中，是下载不下来的，请按照如下方式进行设置到本地的库中
	1、拷贝本机使用的oracle驱动jar 到 当前用户的根目录下，例如：win7系统，拷贝到C:\Users\Administrator下（和.m2是同一目录下）
	2、执行如下语句：
	mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.2.0 -Dpackaging=jar -Dfile=ojdbc14.jar
	
	说明：
	-DartifactId：maven的artifactId
	-DgroupId：maven的groupId
	-Dversion：maven的version
	-Dpackaging：指定是jar形式
	-Dfile：拷贝的jar名称