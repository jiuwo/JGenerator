# JGenerator
  * 基于 FreeMarker 的适用于Mybatis的通用代码生成器
  * 适用只是项目自带模板适应于Mybatis，主程序为通用代码生成器，修改模板即可支持自定义项目

# 配置

  ``` xml
db.url=jdbc:mysql://127.0.0.1:3306/jiuwo?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false&autoReconnect=true
db.user=root
db.password=abc@123
db.name=jiuwo

package.root.name=org.jiuwo
package.root.path=jiuwo
package.model.name=contract
package.model.path=/jiuwo/source/jiuwo-contract/src/main/java/org/jiuwo/contract/generator/
package.model.level=1
package.dao.name=dao
package.dao.path=/jiuwo/source/jiuwo-dao/src/main/java/org/jiuwo/dao/generator/
package.dao.level=1
package.service.impl.name=service
package.service.impl.path=/jiuwo/source/jiuwo-service/src/main/java/org/jiuwo/service/impl/generator/
package.service.impl.level=1
package.service.name=service
package.service.path=/jiuwo/source/jiuwo-service/src/main/java/org/jiuwo/service/generator/
package.service.level=1
package.mapper.path=/jiuwo/source/jiuwo-dao/src/main/resources/mapping/generator/
package.mapper.level=1
trim.strings=true
generator.root=.generator
package.db.name=
  ```

# 执行

  ``` java
  java -jar JGenerator.jar config.properties
  ```

  * 可以多配置，在执行时指定用哪个配置即可
  * 如果程序有BUG或好的建议请提给我，谢谢!
