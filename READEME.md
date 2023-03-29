查看jar包内容
jar tvf target/springboot3-demo-0.0.1-SNAPSHOT.jar


Springboot中配置文件加载顺序是：
.properties -> .xml ->.yml -> .yaml


# JPA
Respository 接口中常用的几个子接口：
CrudRepository
PagingAndSortingRepository
JpaRepository


# 导出依赖
mvn dependency:copy-dependencies -DoutputDirectory=./dist/lib  -DincludeScope=runtime

# 运行
java -Dloader.path=./target/lib,./target/resources -jar ./target/springboot3-demo-0.0.1-SNAPSHOT.jar


## validator
@Valid属于javax下的，而@Validated属于spring下；
@Valid支持嵌套校验、而@Validated不支持，@Validated支持分组，而@Valid不支持。


## DO/DTO/VO/FORM的区别

DO 就是entity ，对应表实体，和数据库的字段一一对应
DTO 数据传输对象，DTO本身不是业务对象
VO 用于封装传递到前端需要展示的字段，数据库表不需要展示的，不要包含
form 用于封装前端传入的字段， 可以配合@Valid注解，对前端传入数据，进行验证，比如必填字段

BeanUtils.copyProperties(userInputDTO, user);
对象属性，最好为包装类，否则可能出现null与0的问题
这个工具类是对bean之间存在属性名相同的属性进行处理，无论是源bean或者是目标bean中多出来的属性均不处理
BeanUtils是浅拷贝，需注意深浅拷贝的不同




