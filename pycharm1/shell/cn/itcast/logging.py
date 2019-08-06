#!/usr/bin/python
# -*- coding:utf-8 -*-
#@Author: baifeng

import  logging
#输出的日志将会保存到相应的app.log 中 按相应的格式进行输出
logging.basicConfig(level=logging.INFO,format='%(asctime)s:%(levelname)s:%(message)s',filename='app.log')
logging.debug("debuf")
logging.info("info ")
#下面的会进行默认输出
logging.warning("warniing")
logging.error("error")
logging.critical("critical")
