#!/usr/bin/python
# -*- coding:utf-8 -*-
#@Author: baifeng

import argparse

def _argparse():
    parser = argparse.ArgumentParser(description="This is a mysql client")
    parser.add_argument("--host",action='store',dest='host',default='localhost',help="connect to host")
    parser.add_argument("-u",action='store',dest='user',default='root',required=True,help="user for login")
    parser.add_argument('-p',action='store',dest='password',required=True,help="password for login")
    parser.add_argument('-p',action='store',dest='port',default='3306',type=int,help='port number to login')
    return parser.parse_args()

def main():
    parser = _argparse()
    print(parser)


if __name__ == '__main__':
    main()