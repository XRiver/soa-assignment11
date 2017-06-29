助教您好！
- 主要有2个test类，用junit对webservice进行了检验，一个检验学生信息接口，另一个检验成绩管理接口，login接口在两个测试类中都有涉及。
- 基本覆盖所有正常情况和异常情况，主要截图在截图文件夹中，如果不放心您可以导入eclipse跑一遍，由于打印信息较多，建议单个方法测试
- 成绩可以平分
- 这次作业关于handler权限检验部分主要思路如下
	1. 由于调用的服务没有对于SOAP header有任何要求（包括明文account+password或者authentication token之类的），而login服务也不返回token，所以作业要求中通过handler对header信息进行权限检验，我们是这样实现的：
	2. 我们的handler chain包含3个handler：
	SOAPHeaderAppendHandler(简称AppendHandler，负责往header里面加上权限信息，而权限信息与服务端完全无关)；
	SOAPHeaderCheckHandler(简称CheckHandler，负责检验header中的权限信息，根据请求的服务种类选择是否拦截)；
	PersistenceHandler(负责对发出的、接收的SOAP消息进行持久化，为了做到跨平台支持、不依赖特定的数据库，我们将SOAP消息存到txt文件中)。
	3. 每一次请求服务，依次经过AppendHandler，CheckHandler，PersistenceHandler，达到加权限信息、检查权限信息、持久化的效果；
	每一次收到服务端SOAP消息，依次经过PersistenceHandler，CheckHandler，AppendHandler，但是只有PersistenceHandler起效，对消息进行持久化。

