### DOM4J的功能分析与建模

#### 什么是XML

XML意为extensible markup language，即可扩展标记语言。它与HTML类似，但是不同之处在于，XML 被设计用来传输和存储数据，其焦点是数据的内容；而HTML 被设计用来显示数据，其焦点是数据的外观 。XML的主要应用领域在Web开发方面，常常用于简化数据的存储和共享。

XML是可扩展的，因此用户可以创建自己的适合应用程序的自描述标签或者语言； XML承载数据，但是不实现它，也就是说，XML 并不具备成为一种编程语言的资格，因为它不执行任何计算或者算法，只是通常存储在简单的文本文件中，并通过能够解释 XML 的特殊软件处理。

下面先从一个html格式的网页说起

![avatar](./pic/1.png)

上图是我在软件工程课上面用ruby on rails写的一个hello_world的页面，如上图所示。如果使用F12去审查此页面的元素就可以得到如下的结果：

<img src="./pic/2.png" alt="avatar" style="zoom:150%;" />

这个就是HTML的格式。可以看到这个结构类似于一个对象，”对象“名叫html，具有head和body的属性，这里由于是空页面，因此head为空，而body就是很简单的hello，world文字。如果改成UML类图的话，就类似于：

![avatar](./pic/3.png)

我的这个hello world 页面就是html类的一个实例，head为空字符，body为字符串”hello，world“

将这个结构如果绘制成节点的形式，就是这样的：

![avatar](./pic/4.png)

上面的树状结构表现了“属性”和“类”之间的结构关系。基于这样的关系，我们把html叫做此HTML文件的根元素

一个XML格式的文件和上面的类似，比如说如下：

![avatar](./pic/5.png)

如上的代码中创建了2个“课程”类的实例，实例的属性包括课程名称以及授课老师2项，根元素为classes。对于XML格式来说，一个XML文件只能有1个根元素

#### 解析XML

由于XML基于一定的文法进行格式化的数据存储，因此为了从XML文件中提取出有效的信息并过滤掉无用的信息，需要对XML文件进行解析。解析XML的方式有DOM、PULL、SAX等，本文讨论的dom4j是基于DOM的方式设计的。

#### 什么是DOM

DOM，全称为Document Object Model，即文档对象模型，它是HTML和XML文档的编程接口。它提供了对文档的结构化的表述，并定义了一种方式，使得程序可以对该结构进行访问，从而改变文档的结构、样式和内容。

DOM 将文档解析为一个由节点和对象（包含属性和方法的对象）组成的结构集合。它首先读取整个XML文件，然后基于文件给XML文件构建出一个树形结构，创建完毕之后再使用DOM定义的API去访问树结构的各个部位，以检索想要的数据以及对数据进行修改。

#### 什么是SAX

SAX，全称为simple API for XML，与DOM不同的是，SAX基于事件驱动，在读取XML文档内容时，事件源顺序地对文档进行扫描，而不是创建一棵解析树。

由于SAX是类似于“临时解析”的方法，较与DOM，它的解析效率高、占存少、灵活性高，但是解析方法复杂（API接口复杂），可拓展性差，而且最重要的是，无法对 XML 树内容结构进行任何修改。


#### 什么是dom4j

dom4j，全称为Document Object Model for Java，是一个java的开源XML解析包。dom4j允许用户读(Read)、写(Write)、浏览(Navigate)、创建(Create)以及修改(Modify) XML文件。

DOM是一个与具体的语言无关的大型API，而dom4j是一个基于DOM基础在Java上实现的轻量级的API，或者说是一个Java类包。dom4j支持DOM的标准，使得DOM的API使用更为便捷。

另外下面会看到，dom4j不仅是基于DOM的解析包，dom4j里面也会用到SAX的相关API。

#### 示例：dom4j解析xml文件

使用dom4j的解析器去解析上面创建的xml文件，代码如下所示：

```java
package test_dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class d4jdriver
{
    public static void main(String[] args) throws Exception
    {
        SAXReader reader = new SAXReader();
        File myfile = new File("D:\\coding\\java_practice\\src\\test_dom4j\\test1.xml");
        Document doc = reader.read(myfile);
        Element root = doc.getRootElement();
        List<Element> child = root.elements();
        for(Element e: child)
        {
            System.out.println("name: " + e.elementText("name"));
            System.out.println("teacher: " + e.elementText("teacher"));
        }
    }
}
```

上面的代码的步骤就是，首先导入对应的包以完成相应操作。然后在main函数里面先实例化一个SAXReader（此类即为dom4j包里面的一个类），然后读取xml文件，将文件转化为Document类型，然后读取document类型里面的根目录（本例里面即为classes)，然后根据根目录将里面的元素转化为list，最后用循环的方式打印list里面的各个元素。打印出的结果如下所示：

<img src="./pic/6.png" alt="avatar" style="zoom:67%;" />

以上就是使用dom4j对一个简单的xml格式文件的解析过程

#### 建立需求模型

##### 第一步：正常处理（normal）

```需求建模
【用例名称】
	1. 解析xml格式的文件
【场景】
	who：xml文件，dom4j的xml解析器
	when：调用相关函数时
	where：内存空间中
【用例描述】
	0.导入dom4j的包
	1.创建一个SAXReader类的实例
	2.打开某个xml文件或从数据流那里创建一个Document类的实例
	3.从Document实例中提取出xml格式的Element类型的元素
		3.1.获取根元素
		3.2.通过根元素递归地获得叶子元素
		3.3.获得List类型的元素列表
	4.通过ELement类型的某些方法获取类型的各个属性
【用例价值】
	以面向对象的方式提取出XML格式文件的关键信息
【约束和限制】
	1.被解析的文件必须符合XML的格式
	2.调用dom4j包以及编写解析代码必须符合java的语法，必须在java的环境下进行
```
```需求建模
【用例名称】
	2. 创建xml格式的文件
【场景】
	who：xml文件，dom4j的xml解析器
	when：调用相关函数时
	where：内存空间中
【用例描述】
	0.导入dom4j的包
	1.创建一个Document的实例
	2.创建根元素
	3.对根元素调用函数创建叶子元素
		3.1.增加新元素
		3.2.增加新元素的属性
	4.保存为xml文件或者输出到控制台
【用例价值】
	通过调用API快速完成构建xml格式的文件，减轻了对XML文法掌握的难度
【约束和限制】
	1.调用dom4j包以及编写解析代码必须符合java的语法，必须在java的环境下进行
```
```需求建模
【用例名称】
	3. 修改xml格式的文件
【场景】
	who：xml文件，dom4j的xml解析器
	when：调用相关函数时
	where：内存空间中
【用例描述】
	0.导入dom4j的包
	1.创建一个SAXReader类的实例
	2.从某个文件或数据流那里创建一个Document类的实例
	3.从Document实例中提取出xml格式的Element类型的元素
		3.1.获取根元素
		3.2.通过根元素递归地获得叶子元素
		3.3.获得List类型的元素列表
	4.通过Document类型的查询方法按照属性值检索出待修改的元素
	5.调用Element对应的修改属性的方法修改检索出的元素的属性
	6.保存xml文件或输出
【用例价值】
	通过查询xml中特定元素的方式对特定元素的属性值进行快速修改
【约束和限制】
	1.被解析的文件必须符合XML的格式
	2.调用dom4j包以及编写解析代码必须符合java的语法，必须在java的环境下进行
```

##### 第二步：异常处理（exception）

```需求建模
【用例描述】
	打开某个xml文件或从数据流那里创建一个Document类的实例时：
		ex.1.没有路径
		ex.2.五花八门的路径表达式
		ex.3.路径下没有文件
		ex.4.含xml格式的文件/数据不规范，导致解析器无法运作
		对上述例外的处理：
		1. 检查xml文件是否符合格式规范，如不规范抛出异常进行错误处理
		2. 打不开路径的时候能够报错
		3. 对于正确但是表达怪异的路径能够修正
		4. 没有文件的时候没有内容输出
	从Document实例中提取出xml格式的Element类型的元素时：
		ex.5.没有根元素
		处理：
		1. 依靠读取xml文件的流程帮助筛选此类情形
		2. 检测到没有根元素的时候自动创建根元素，返回的document就是只有根节点的树结构
	创建根元素时：
		ex.6.没有待创建的内容输入
		处理：
		1. 输出空内容，或者只输出头结构<?xml version="1.0" encoding="UTF-8"?>等
	修改属性时：
		ex.7.没有输入
		处理
		1. 检测到修改值为null的时候抛出例外
```
##### 第三步：替代处理（alternative）

```需求建模
【用例描述】
	打开某个xml文件或从数据流那里创建一个Document类的实例时：
        al.1.XML来源为文件（File类型）
        al.2.XML来源为URL
        al.3.XML来源为字符串（String类型）
        al.4.XML来源为控制台输入
        ...
```

#### 需求模型的功能提取

将上述4种用例的动词挑选出来：

```
打开、创建、提取、获取、获得
检索
增加、保存、输出
修改
```

建立功能矩阵

| 功能编号 | 功能描述                      | 备注                                        |
| -------- | ----------------------------- | ------------------------------------------- |
| 001      | 打开XML文件                   | 使用的是java的基础类File                    |
| 002      | 通过input数据流创建XML文件    | 使用的是java基础的IO的相关方法              |
| 003      | 创建SAXReader类的实例         | SAXReader中的SAX就是上面提到的SAX           |
| 004      | 用SAXReader提取出Document实例 | Document的树结构是Reader通过SAX的方式创建的 |
| 005      | 获取Document的根元素          | 方法是Document类定义的                      |
| 006      | 从根元素获取叶子元素          | 方法是Element类定义的                       |
| 007      | 按照特定属性检索叶子元素      | 方法是Document类定义的                      |
| 008      | 创建根元素                    | 输入参数为根元素的名字                      |
| 009      | 增加新元素                    | 输入参数为元素名字（或者说是“实例”的名字）  |
| 010      | 增加元素的属性                | 输入参数包括属性名以及属性内容              |
| 011      | 保存XML文件                   | 使用的是XMLWriter类的方法                   |
| 012      | 打印XML文件                   | 同上，通过java中的基础的IO方法输出到控制台  |
| 013      | 修改叶子元素的内容            | 使用Element的相关方法修改                   |

对于上述用例的类的抽取，根据dom4j官方给出的示例代码里面已经能够看到涉及的类了，分别是`SAXReader`, `Document`, `Element`,  `Node`等。从4类用例的示例代码中提取出的结构用UML表示如下所示：

![avatar](./pic/7.png)

对于代码中另外的一些类，有的是java里面别的通用的包里面调用的，有的虽然属于dom4j.jar，但是我认为不是分析的重点，就没有列举了。

从上面UML图可以得到一些有用的信息，比如说Element、Node和Document之间有一些同名的方法，这不禁让人联想到它们的继承关系树里面可能有共同的祖先，或者它们使用了同样的接口。

另外，由于上述UML图的构造来自dom4j.github.io所给出的示例代码，因此是从用户/调用者的角度去构造的，可以看到这几个类的一个统一的特点就是它们都没有在示例代码中直接调用属性，而是调用相关方法来获得属性，例如Element类的getName方法，以此将属性封装到类中进行保护，调用者无法直接访问这些内容，这体现了dom4j作者的良好的代码素养。

#### 借助源码进行进一步分析

##### 使用Intellij Idea的绘图工具展示UML图

![avatar](./pic/d4jstructure.png)

通过idea的工具可以绘制出这些类型之间的关系，如上图所示，可以看到Element和Document属于Node的子节点，其余的几个类之间没有相互关联。最细的虚线是注解关系，例如在DocumentHelper的定义文件最上面有一行

```java
@SuppressWarnings("unused")
public final class DocumentHelper {
    private DocumentHelper() {
    }
    ...
}
```

这个表示该属性在方法或类中没有使用。添加此注解可以去除属性上的黄色警告。

##### 通过源码对实际执行流程进行进一步的了解

###### SAXReader.read()

借助idea对SAXReader此类的结构进行进一步解析：

![avatar](./pic/8.png)

可以看到它的read方法重载了8次，分别对应了8种可能的输入类型，返回值均为Document类，其中dom4j官方给的示例里面使用的是读取本地文件的read函数，也就是`read(File): Document`

```java
public Document read(File file) throws DocumentException {
        try {
            ...
            //正常执行流程
            }
            return read(source);
        } catch (FileNotFoundException e) {
            throw new DocumentException(e.getMessage(), e);
        }
    }
```

由于本阶段的分析不是分析核心源码，因此用一张流程图来描述一下read函数的正常的执行过程

<img src="./pic/9.png" alt="avatar" style="zoom:67%;" />

首先，从文件类型file中读取文件数据，这里使用到了InputSource这个类。根据`saxproject.org`给出的定义，InputSource类允许SAX应用程序在单个对象中封装有关输入源的信息， 解析器将使用InputSource对象来确定如何读取XML输入。

然后SAXReader会确认编码是什么，如果还没设置，就调用相关的函数设置编码

然后SAXReader获取文件的绝对路径，如果路径非空，那么创建一个临时的stringbuffer类型的字符串作为路径。此类型的字符串支持多次修改并不会产生新的未使用对象。在检测路径的时候，SAXReader会检测是否是以路径分隔符开头，如果不是以路径分隔符开头，就给它加上1个/符号。由于可能存在的跨平台问题，SAXReader检测路径的时候使用的是静态变量File.separator而不是字符'/'，以此解决不同平台上可能使用的不同的分隔符，但是在dom4j处理的内部统一采用了'/'作为分隔符。然后SAXReader将路径中的双反斜杠\\\替换为了/，这是考虑路径中可能存在这样的转义字符。

最后将StringBuffer转为string之后赋给source，这时候将InputSource类型的source作为输入调用另一个重载的read(InputSource)函数，以它的返回值作为返回值返回。	

此外在代码最开始以及之后的catch部分也增加了检测例外的机制。SAXReader在最开始向调用者抛出DocumentException例外，用于检测可能出现的解析出错问题，因此调用者在使用SAXReader时需要执行例外处理语句

```java
catch (DocumentException e) {
    e.printStackTrace();
}
```

而SAXReader自身由于也调用了别的函数，它也会catch别的函数抛出的异常。这里catch的异常是找不到文件的情况，找到之后也通过抛出DocumentException的方式传递给上级调用者。

###### SAXReader.read(InputSource)

此函数才是真正进行XML格式解析的函数，别的重载函数基本上都是将格式转化为InputSource之后再调用此函数的。这种方式就实现了之前需求分析里面所给出的替代处理过程。

```java
public Document read(InputSource in) throws DocumentException {
        try {
            ...
            //正常执行过程
        } catch (Exception e) {
            if (e instanceof SAXParseException) {
                //触发例外
				...
                throw new DocumentException(message, e);
            } else {
                throw new DocumentException(e.getMessage(), e);
            }
        }
    }
```

首先获取一个XMLReader的类型，注意到此类型之前出现在UML中，是XMLWriter的父类。然后给这个reader安装XML过滤器以获得甄别XML格式文件中有效信息的能力。

接下来注册了一个EntityResolver类型的实例。根据`SAXproject.org`的描述，EntityResolver的作用是对外部实例的自定义处理 ，当应用程序要从数据库或其他专用输入源构建XML文档时，或者使用URL以外的URI类型构建XML文档时， 就需要此类型的帮助。

接下来再给reader安装上SAXContentHandler这个模块，SAXContentHandler 通过SAX事件的方式构建dom4j树，在SAX里面有一个接口ContentHandler，其作用是处理所有对XML内容解析时产生的所有事件，看来在dom4j里面SAXContentHandler应该是对SAX中定义的同名接口进行调用，或者是造了个同样功能的轮子，由于代码有点复杂就没有继续了解这个模块了。在给reader装上SAXContentHandler模块之前，定义好的SAXContentHandler实例自己先给设置了一大堆东西，如下：

| 操作名称                          | 用途                                          |
| --------------------------------- | --------------------------------------------- |
| setIncludeInternalDTDDeclarations | 设置是否将内部的DTD声明扩展为DocumentType对象 |
| setIncludeExternalDTDDeclarations | 设置是否将外部的DTD声明扩展为DocumentType对象 |
| setEntityResolver                 | 设置EntityResolver                            |
| setInputSource                    | 设置InputSource                               |
| setMergeAdjacentText              | 设置在分析时是否应将相邻的文本节点合并在一起  |
| setStripWhitespaceText            | 设置是否应忽略元素开始和结束标签之间的空格    |
| setIgnoreComments                 | 设置是否忽略注释                              |

其中DTD（文档类型定义）的作用是定义 XML 文档的合法构建模块。DTD 可被成行地声明于 XML 文档中，也可作为一个外部引用。

将SAXContentHandler装到reader之后再使用configure reader方法来给reader安装、配置之前装上的所有模块。最后再调用parse方法对InputSource进行解析。

最后返回时使用SAXContentHandler的getDocument（）方法返回，但是显然这个方法从命名来看只是一个getXXX属性的函数，在这一步之前，相应的Document对象已经构建完成了。

由于这个地方给reader设置了许多模块，如果逐行分析reader在这些模块/方法的帮助下如何解析InputSource的话比较复杂，而且本阶段任务只是功能分析与建模，不必深入研究源码的执行流程，因此这里就略过不谈了。

再看一下本地的例外处理部分，这里需要catch的例外是SAX解析时的例外，除了继续向上层模块抛出Document例外之外，这里针对SAX解析例外做了简单的处理，就是将发生例外时候处于XML文件的行数、id号以及解析例外自身携带的信息打包好之后借助Document例外抛给上级处理。

##### 设计模式：过滤器模式

刚刚给reader安装过滤器的时候有一个比较有意思的设计模式，就是过滤器模式。过滤器模式允许开发人员使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来。就好像在滤水的时候将水源从大小口径不一的滤芯过一遍之后将各式杂质清除一样，每一级过滤器都可以执行一个特定的功能，将不同功能的过滤器级联之后就可以将数据流进行多种处理了。

由于每个过滤模块都是一个相对独立，内部实现了一个相对完整的功能的模块，因此内聚程度高；模块与模块之间的关联则不紧密，可能仅仅是将它们的输入/输出级联一下（也可能有更复杂的关系），耦合程度低。这就体现了高内聚低耦合的设计理念。

##### dom4j实际代码对于上述列举出的例外的处理方式

对于XML文法错误所引发的一系列问题，在dom4j解析的时候都会报错而终止解析过程。由于知识和能力受限，实际分析的时候我难以定位到每种例外发生时候的代码处理逻辑。因此实际在测试代码的时候我故意按照可能发生的例外修改了XML文件，以这种放方式来观察dom4j如何处理这些例外的。比如说：

###### 把路径写错：

![avatar](./pic/10.png)

这时候程序会向控制台输出这样的信息，提示找不到文件。	

###### 如果将路径中的分隔符进行混搭：

![avatar](./pic/11.png)

<img src="./pic/12.png" alt="avatar" style="zoom:67%;" />

程序能够正常解析完毕，这是多亏了刚才分析SAXReader的时候实现的分隔符处理操作；

###### 如果故意将XML文件写得不符合格式规定：

![avatar](./pic/13.png)

![avatar](./pic/14.png)

可以看到在SAXReader安装了各种模块之后都能够检测得到，采取的方式都是终止报错，注意到在报错信息中含有语法提示，比如说错误在哪一行，这正是read(InputSource)抛出的那个带有行信息的例外传递到了控制台。

###### 如果在创建XML的时候没有任何输入：

<img src="./pic/16.png" alt="avatar" style="zoom:67%;" />

这时候控制台输出的XML文件将文件头给补齐了，但是实际上这个地方真的要挑刺的话可以认为没有根元素，创建的XML文件还是有点问题，解决方案是可以帮用户补齐一个空的根元素，比如说

```xml
<?xml version="1.0" encoding="UTF-8"?>
<default></default>
```

###### 如果在修改XML的时候没有任何输入：

![avatar](./pic/15.png)

同样的，dom4j采用的方式是抛出例外，终止程序，控制台显示出错误类型。

综上所述，可以看到，dom4j对于常见的一些例外，可能更多倾向于将问题留给用户解决，因为例外可能无法被程序解决。

而对于一些不会产生歧义的例外，dom4j可以无视这种错误，自行修正之后正常工作，比如说路径的分隔符不统一。



###### 参考资料

[1]   https://www.cnblogs.com/sharpest/p/7877501.html 

[2]  https://developer.mozilla.org/zh-CN/docs/Web/API/Document_Object_Model/Introduction 

[3]  https://github.com/dom4j/dom4j/wiki/FAQ 

[4]  https://www.runoob.com/xml/xml-tutorial.html 

[5]  https://wiki.jikexueyuan.com/project/xml/overview.html 

[6]  https://blog.csdn.net/chenweitang123/article/details/6255108 

[7]  https://blog.csdn.net/qq_38254978/article/details/77870598 

[8]  https://www.tutorialspoint.com/java_xml/java_dom4j_parser.htm 

[9]  https://segmentfault.com/a/1190000011332759#articleHeader0 

[10]  https://dom4j.github.io/ 

[11]  https://www.cnblogs.com/huanjianlin/archive/2013/04/03/2997303.html 

[12]  http://www.saxproject.org/apidoc/org/xml/sax/InputSource.html 

[13]  https://blog.csdn.net/wei_zhi/article/details/52837635 

[14]  https://docs.oracle.com/middleware/11119/core/OCLAR/oracle/sdp/presence/integration/DocumentException.html 

[15]  http://www.saxproject.org/apidoc/org/xml/sax/EntityResolver.html 

[16]  https://blog.csdn.net/zlb824/article/details/7462827 

[17]  https://dom4j.github.io/javadoc/1.6.1/org/dom4j/io/SAXContentHandler.html 

[18]  http://www.blogjava.net/DLevin/archive/2012/11/18/391545.html 

[19]  https://www.runoob.com/dtd/dtd-tutorial.html 









