import xml.etree.ElementTree as et
stu = et.Element("student")
name = et.SubElement(stu,"Name")
name.attrib = {"lang","on"}
name.text = "xiashuangwu"

age = et.SubElement(stu,"age")

age.text=16

stu.write('result.xml', encoding='utf-8')
