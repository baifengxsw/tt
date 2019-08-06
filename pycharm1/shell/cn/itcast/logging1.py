#!/usr/bin/python
# -*- coding:utf-8 -*-
#@Author: baifeng

import  logging
import logging.config
#进行读取配置文件  多输出,逗号分隔
logging.config.fileConfig('logging.cnf')
logging.debug("debuf")
logging.info("info ")
#下面的会进行默认输出
logging.warning("warniing")
logging.error("error")
logging.critical("critical")
