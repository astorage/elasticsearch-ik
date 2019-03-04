1、elasticsearch6.6.1不能使用6.6.0的ik插件。yb01分支，这个是在elasticsearch-analysis-ik工程，6.6.0分支上，修改elasticsearch.version 为6.6.1，然后package，可以在elasticsearch6.6.1使用。
2、在1的基础上增加添加了从mysql热加载词库的功能——分支yb。这个也是在elasticsearch6.6.1上使用。
