water
=====

一、.gitignore使用说明

1、若是添加maven项目，请在该文件中，增加类似如下 内容：springioc/target

2、若是 普通的java或者web项目，请在该文件中，增加类似如下内容：z-tag-test/build

    本人的编译 目录是 build，若 其他人员的编译目录不是build，请替换成相应的编译目录

该文件的目的，就是忽略 编译.class文件，这样不把 设置的文件目录 提交到git上。

