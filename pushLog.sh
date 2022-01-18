#!/bin/sh
#四个参数：1.远程服务器：root@Ip 2.probe_id 3.task_id 4.timestamp
#创建文件夹
ssh $1 "mkdir -p ~/web-monitor/probeLogs/$2/$3"
#把结果上传到远程文件夹
scp -r locallogs/$2/$3/$4 $1:~/web-monitor/probeLogs/$2/$3