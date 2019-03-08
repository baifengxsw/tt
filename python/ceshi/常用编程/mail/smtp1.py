#!/usr/bin/env python
# -*- coding:utf-8 -*-
#@Author: baifeng
import smtplib
from email.mime.text import  MIMEText
# 以html文件格式进行发送
mail_content = """
                        <!DOCTYPE html>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title></title>
                    
                </head>
                <body>
                    <!--
                        1. 创建一个8行一列的表格
                        2. 第一部份: LOGO部分: 嵌套一个一行三列的表格
                        3. 第二部分: 导航栏部分 : 放置5个超链接
                        4. 第三部分: 轮播图 
                        5. 第四部分: 嵌套一个三行7列表格
                        6. 第五部分: 直接放一张图片
                        7. 第六部分: 抄第四部分的
                        8. 第七部分: 放置一张图片
                        9. 第八部分: 放一堆超链接
                    -->
                    <table  width="100%" >
                        <!--第一部份: LOGO部分: 嵌套一个一行三列的表格-->
                        <tr>
                            <td>
                                <table  width="100%">
                                    <tr>
                                        <td>
                                            <img src="../img/logo2.png" />
                                        </td>
                                        <td>
                                            <img src="../image/header.jpg" />
                                        </td>
                                        <td>
                                            <a href="#">登录</a>
                                            <a href="#">注册</a>
                                            <a href="#">购物车</a>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!--第二部分: 导航栏部分 : 放置5个超链接-->
                        <tr bgcolor="black">
                            <td height="50px">
                                <a href="#"><font color="white">首页</font></a>
                                <a href="#"><font color="white">手机数码</font></a>
                                <a href="#"><font color="white">鞋靴箱包</font></a>
                                <a href="#"><font color="white">电脑办公</font></a>
                                <a href="#"><font color="white">香烟酒水</font></a>
                            </td>
                        </tr>
                        <!--第三部分: 轮播图 -->
                        <tr>
                            <td>
                                <img src="../img/1.jpg" width="100%" />
                            </td>
                        </tr>
                        <!--第四部分: 嵌套一个三行7列表格-->
                        <tr>
                            <td>
                                <table  width="100%" height="500px"> 
                                    <tr>
                                        <td colspan="7">
                                            <h3>最新商品<img src="../img/title2.jpg"></h3>
                                        </td>
                                    </tr>
                                    <tr align="center">
                                        <!--左边大图的-->
                                        <td rowspan="2" width="206px" height="480px">
                                            <img src="../products/hao/big01.jpg" />
                                        </td>
                                        <td colspan="3" height="240px">
                                            <img src="../products/hao/middle01.jpg" width="100%" height="100%" />								
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                    </tr>
                                    <tr align="center">
                                        
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!--第五部分: 直接放一张图片-->
                        <tr>
                            <td>
                                <img src="../products/hao/ad.jpg" width="100%" />
                            </td>
                        </tr>
                        <!--第六部分: 抄第四部分的-->
                        <tr>
                            <td>
                                <table  width="100%" height="500px"> 
                                    <tr>
                                        <td colspan="7">
                                            <h3>热门商品<img src="../img/title2.jpg"></h3>
                                        </td>
                                    </tr>
                                    <tr align="center">
                                        <!--左边大图的-->
                                        <td rowspan="2" width="206px" height="480px">
                                            <img src="../products/hao/big01.jpg" />
                                        </td>
                                        <td colspan="3" height="240px">
                                            <img src="../products/hao/middle01.jpg" width="100%" height="100%" />								
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                    </tr>
                                    <tr align="center">
                                        
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                        <td>
                                            <img src="../products/hao/small06.jpg" />
                                            <p>洗衣机</p>
                                            <p><font color="red">$998</font></p>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 第七部分: 放置一张图片-->
                        <tr>
                            <td>
                                <img src="../image/footer.jpg" width="100%" />
                            </td>
                        </tr>
                        <!--第八部分: 放一堆超链接-->
                        <tr>
                            <td align="center">
                                        
                                <a href="#">关于我们</a>
                                <a href="#">联系我们</a>
                                <a href="#">招贤纳士</a>
                                <a href="#">法律声明</a>
                                <a href="#">友情链接</a>
                                <a href="#">支付方式</a>
                                <a href="#">配送方式</a>
                                <a href="#">服务声明</a>
                                <a href="#">广告声明</a>
                                <br />
            Copyright © 2005-2016 传智商城 版权所有
                            </td>
                        </tr>
                    </table>
                </body>
            </html>

        """
msg = MIMEText(mail_content,"html","utf-8")
#构建发送文件的原始信息
from_addr = "1072396463@qq.com"
from_pwd = "ledgijjyrwgibcbg"
to_addr = "xiaswuxxxx@163.com"
#输入邮件服务器的地址
smtp_srv = "smtp.qq.com"
try:
    srv = smtplib.SMTP_SSL(smtp_srv.encode(),465)
    srv.login(from_addr,from_pwd)
    srv.sendmail(from_addr,[to_addr],msg.as_string())
    srv.quit()
except Exception as e:
    print(e)
